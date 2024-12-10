package com.team2.sportsleague.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class League {
    public League() {
    }

    private Integer id;
    private String name;
    private LocalDateTime schedule;
    private LocalDateTime lastRegistrationDate;
    private String venue;
    private String sports;


    public League(Integer id, String name, LocalDateTime schedule, LocalDateTime lastRegistrationDate, String venue, String sports) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
        this.lastRegistrationDate = lastRegistrationDate;
        this.venue = venue;
        this.sports = sports;
    }
}
