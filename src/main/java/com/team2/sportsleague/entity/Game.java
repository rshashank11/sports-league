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

