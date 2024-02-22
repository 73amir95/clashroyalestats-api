package com.example.clashroyalestats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class UpgradeCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private Integer level;
    @NotBlank
    @NotNull
    private Integer cost;


    public UpgradeCost(Long id, Integer level, Integer cost) {
        this.id = id;
        this.level = level;
        this.cost = cost;
    }

    public UpgradeCost() {
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpgradeCost{" +
                "id=" + id +
                ", level=" + level +
                ", cost=" + cost +
                '}';
    }
}
