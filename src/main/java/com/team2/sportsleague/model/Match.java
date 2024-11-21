package com.team2.sportsleague.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Match {

    int playerId1;
    int playerId2;
    String playerName1;
    String playerName2;
    int playerScore1;
    int playerScore2;
}
