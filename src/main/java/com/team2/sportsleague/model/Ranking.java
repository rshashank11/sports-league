package com.team2.sportsleague.model;

public class Ranking {
    private String name;      // User's name
    private int wins;         // Number of wins
    private int losses;       // Number of losses
    private int rank;         // Rank
    private int points;       // Points

    // Constructor, getters, setters
    public Ranking(String name, int wins, int losses, int rank, int points) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.rank = rank;
        this.points = points;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
