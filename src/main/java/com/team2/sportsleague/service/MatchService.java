package com.team2.sportsleague.service;

import com.team2.sportsleague.model.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team2.sportsleague.repository.MatchRepositoryJDBC;
import java.util.List;

@Service
public class MatchService {
    private final MatchRepositoryJDBC matchRepository;

    public MatchService(MatchRepositoryJDBC matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void updateMatchScores(int player1Score, int player2Score, int matchId) {

        matchRepository.updateScores(player1Score, player2Score, matchId);
    }

    public List<Round> getAllRounds() {
        return matchRepository.getAllRounds();
    }
}