package com.team2.sportsleague.repository;
import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;

import java.util.List;

public interface MatchRepository {
    List<Round> getAllRounds();
}
