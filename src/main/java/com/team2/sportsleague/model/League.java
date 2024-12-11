package com.team2.sportsleague.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class League {
    public League() {
    }

    private Integer id;
    private String name;
    private LocalDateTime schedule;
    private LocalDateTime lastRegistrationDate;
    private String venue;
    private String sports;

}
