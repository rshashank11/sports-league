//package com.team2.sportsleague.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Photo {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String src;
//    private String metadata;
//
//    // Many-to-one relationship with Game
//    @ManyToOne
//    private Game game;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSrc() {
//        return src;
//    }
//
//    public void setSrc(String src) {
//        this.src = src;
//    }
//
//    public String getMetadata() {
//        return metadata;
//    }
//
//    public void setMetadata(String metadata) {
//        this.metadata = metadata;
//    }
//
//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }
//}


package com.team2.sportsleague.entity;

public class Photo {

    private Long id;
    private String src;
    private String metadata;
    private Long gameId; // Store the foreign key explicitly

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
