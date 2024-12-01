package com.team2.sportsleague.entity;

import jakarta.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String src;
    private String metadata;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSrc() { return src; }
    public void setSrc(String src) { this.src = src; }
    public String getMetadata() { return metadata; }
    public void setMetadata(String metadata) { this.metadata = metadata; }
    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }
}
