package com.team2.sportsleague.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeagueDTO {
    private String name;
    private String schedule;
    private String lastRegistrationDate;
    private String venue;
    private String sport;

}

