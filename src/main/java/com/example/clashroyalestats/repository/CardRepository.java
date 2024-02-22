package com.example.clashroyalestats.repository;

import com.example.clashroyalestats.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}
