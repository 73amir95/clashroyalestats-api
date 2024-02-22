package com.example.clashroyalestats.controller;

import com.example.clashroyalestats.model.Player;
import com.example.clashroyalestats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "{playerId}")
    public Player getPlayer(@PathVariable("playerId") Long id){
        var player = playerService.getPlayer(id);
        var totalCost = playerService.calculateTotalCost(id);
        player.setTotalCost(totalCost);
        return player;
    }
}
