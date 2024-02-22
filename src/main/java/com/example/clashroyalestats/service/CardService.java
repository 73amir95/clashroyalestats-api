package com.example.clashroyalestats.service;

import com.example.clashroyalestats.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public HashSet<Object> getCards(){
        var cards = cardRepository.findAll();
        var cardNames = new HashSet<>();
        for( var card : cards)
            cardNames.add(card.getName());
        return cardNames;
    }
}
