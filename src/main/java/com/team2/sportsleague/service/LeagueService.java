package com.team2.sportsleague.service;

import java.time.LocalDateTime;

public class LeagueService {
    private String name;
    private LocalDateTime schedule;
    private LocalDateTime lastRegistrationDate;
    private String venue;

    // Constructor
    public LeagueService(String name, LocalDateTime schedule, LocalDateTime lastRegistrationDate, String venue) {
        this.name = name;
        this.schedule = schedule;
        this.lastRegistrationDate = lastRegistrationDate;
        this.venue = venue;
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public LocalDateTime getLastRegistrationDate() {
        return lastRegistrationDate;
    }

    public String getVenue() {
        return venue;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public void setLastRegistrationDate(LocalDateTime lastRegistrationDate) {
        this.lastRegistrationDate = lastRegistrationDate;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
