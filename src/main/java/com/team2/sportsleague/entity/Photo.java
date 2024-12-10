package com.team2.sportsleague.entity;

public class Photo {

    private Long id;
    private Long gameId;       // The gameId is a Long
    private String src;        // The file path is a String
    private String metadata;   // The metadata is a String

    public Photo() {
    }

    public Photo(Long gameId, String src, String metadata) {
        this.gameId = gameId;
        this.src = src;
        this.metadata = metadata;
    }

    // Getters and setters for the new fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
