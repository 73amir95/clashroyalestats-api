package com.example.clashroyalestats.repository;

import com.example.clashroyalestats.model.Player;
import com.example.clashroyalestats.model.PlayerCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerCardsRepository extends JpaRepository<PlayerCards, Long> {

    @Query("SELECT s FROM PlayerCards s WHERE s.player = ?1")
    List<PlayerCards> findByPlayerId(Player player);
}
