package com.team2.sportsleague.model;


import lombok.Data;

@Data
public class Ranking {
    private String name;
    private int wins;
    private int losses;
    private int rank;
    private int points;

    public Ranking(String name, int wins, int losses, int rank, int points) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.rank = rank;
        this.points = points;
    }

    // Getters and setters (if needed)
}
