package com.example.clashroyalestats.service;

import com.example.clashroyalestats.model.Player;
import com.example.clashroyalestats.model.PlayerCards;
import com.example.clashroyalestats.repository.PlayerCardsRepository;
import com.example.clashroyalestats.repository.PlayerRepository;
import com.example.clashroyalestats.repository.UpgradeCostRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerCardsRepository playerCardsRepository;
    private final UpgradeCostRepository upgradeCostRepository;
    private HashMap<Integer, Integer> costMap;

    public PlayerService(PlayerRepository playerRepository, PlayerCardsRepository playerCardsRepository, UpgradeCostRepository upgradeCostRepository) {
        this.playerRepository = playerRepository;
        this.playerCardsRepository = playerCardsRepository;
        this.upgradeCostRepository = upgradeCostRepository;
        this.costMap = intializeCostMap();
    }


    public Player getPlayer(Long id){
        return playerRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));
    }

    private HashMap<Integer, Integer> intializeCostMap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        var upgradeCosts = upgradeCostRepository.findAll();
        for (var cost : upgradeCosts)
            map.put(cost.getLevel(), cost.getCost());
        return map;
    }

    private int calculateCost(int level) {
        var totalCost = 0;
        for (int i = 2; i <= level; i++) {
            if (costMap.containsKey(i))
                totalCost += costMap.get(i);
        }
        return totalCost;
    }

    public int calculateTotalCost(Long playerId) {
        var player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with this id."));

        List<PlayerCards> playerCards = playerCardsRepository.findByPlayerId(player);
        var totalCost = 0;
        for (var pc : playerCards) {
            var card = pc.getCard();
            var level = card.getLevel();
            totalCost += calculateCost(level);
        }

        return totalCost;
    }


}
