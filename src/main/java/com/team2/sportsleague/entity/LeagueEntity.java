package com.team2.sportsleague.entity;

import java.time.LocalDateTime;
import java.util.List;

public class LeagueEntity {
    private String name;
    private LocalDateTime schedule;
    private LocalDateTime lastRegistrationDate;
    private String venue;
    private String sports; // Add sports field


    public LeagueEntity(String name, LocalDateTime schedule, LocalDateTime lastRegistrationDate, String venue, String sports) {
        this.name = name;
        this.schedule = schedule;
        this.lastRegistrationDate = lastRegistrationDate;
        this.venue = venue;
        this.sports = sports;
    }


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

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }
}
