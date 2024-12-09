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

    public void updateMatchScores(int player1Score, int player2Score, int matchId, int leagueId, Long userId) {

        matchRepository.updateScores(player1Score, player2Score, matchId, leagueId);
        matchRepository.generateNextRoundIfNeeded(leagueId);
    }

    public List<Round> getAllRounds(int leagueId) {
        List<Round> rounds = matchRepository.getAllRounds(leagueId);
        if (rounds == null || rounds.isEmpty()) {
            System.out.println("No rounds found for leagueId: " + leagueId);
        } else {
            System.out.println("Rounds found: " + rounds.size());
        }

        return rounds;
    }

    public boolean isUserOwnerOfMatch(int matchId, Long userId) {
        return matchRepository.isUserOwnerOfMatch(matchId, userId);
    }
}