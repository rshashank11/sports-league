package com.team2.sportsleague.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Round {
    private List<Match> matches;
}