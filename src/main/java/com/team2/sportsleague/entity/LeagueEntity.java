package com.team2.sportsleague.entity;

import java.time.LocalDateTime;

public class LeagueEntity {
    private String name;
    private LocalDateTime schedule;
    private LocalDateTime lastRegistrationDate;
    private String venue;

    public LeagueEntity(String name, LocalDateTime schedule, LocalDateTime lastRegistrationDate, String venue) {
        this.name = name;
        this.schedule = schedule;
        this.lastRegistrationDate = lastRegistrationDate;
        this.venue = venue;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public LocalDateTime getLastRegistrationDate() {
        return lastRegistrationDate;
    }

    public void setLastRegistrationDate(LocalDateTime lastRegistrationDate) {
        this.lastRegistrationDate = lastRegistrationDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
