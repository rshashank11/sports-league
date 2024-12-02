package com.team2.sportsleague.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String slug;

    // Adding photos field for association
    private transient List<Photo> photos; // `transient` to avoid persistence issues (or use proper mapping in JPA)

    // Getters and Setters
    public long getId() { // Changed return type to `long`
        return id;
    }

    public void setId(long id) { // Changed parameter type to `long`
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

    public List<Photo> getPhotos() { // Getter for photos
        return photos;
    }

    public void setPhotos(List<Photo> photos) { // Setter for photos
        this.photos = photos;
    }
}
