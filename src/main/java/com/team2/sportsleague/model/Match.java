package com.team2.sportsleague.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Match {

    int matchId;
    int player1_id;
    int player2_id;
    String player1_name;
    String player2_name;
    Integer score_player1;
    Integer score_player2;
    Integer winner_id;
    int round_number;
}
