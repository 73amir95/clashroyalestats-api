package com.example.clashroyalestats.model;

import jakarta.persistence.*;

@Entity
@Table
public class PlayerCards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "card_name", referencedColumnName = "id")
    private Card card;


    public PlayerCards(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public PlayerCards() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "PlayerCards{" +
                "id=" + id +
                ", player=" + player +
                ", card=" + card +
                '}';
    }
}
