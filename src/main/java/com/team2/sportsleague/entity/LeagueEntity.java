package com.team2.sportsleague.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
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

    public void setSports(String sports) {
        this.sports = sports;
    }
}
