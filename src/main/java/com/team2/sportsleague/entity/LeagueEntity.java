package com.team2.sportsleague.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class LeagueEntity {

    private Integer id;
    @Setter
    private String name;
    @Setter
    private LocalDateTime schedule;
    @Setter
    private LocalDateTime lastRegistrationDate;
    @Setter
    private String venue;
    @Setter
    private String sports;


    public LeagueEntity(Integer id, String name, LocalDateTime schedule, LocalDateTime lastRegistrationDate, String venue, String sports) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
        this.lastRegistrationDate = lastRegistrationDate;
        this.venue = venue;
        this.sports = sports;
    }


}
