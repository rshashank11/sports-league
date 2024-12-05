//package com.team2.sportsleague.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Game {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String name;
//    private String slug;
//
//    @OneToMany(mappedBy = "game")
//    private List<Photo> photos = new ArrayList<>();
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSlug() {
//        return slug;
//    }
//
//    public void setSlug(String slug) {
//        this.slug = slug;
//    }
//
//    public List<Photo> getPhotos() {
//        return photos;
//    }
//
//    public void setPhotos(List<Photo> photos) {
//        this.photos = photos;
//    }
//}


package com.team2.sportsleague.entity;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private long id;
    private String name;
    private String slug;
    private List<Photo> photos = new ArrayList<>(); // Initialize photos list

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}

