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
    Integer player1Score;
    Integer player2Score;
    Integer winner_id;
    int roundNumber;
}
