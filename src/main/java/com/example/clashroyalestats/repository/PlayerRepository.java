package com.example.clashroyalestats.repository;

import com.example.clashroyalestats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
