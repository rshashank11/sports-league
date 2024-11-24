package com.team2.sportsleague.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Match {

    int playerId1;
    int playerId2;
    String playerName1;
    String playerName2;
    int player1Score;
    int player2Score;
}