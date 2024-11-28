package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MatchRepositoryJDBC implements MatchRepository {
    private JdbcTemplate jdbc;
    private RowMapper<Match> matchMapper;

    public MatchRepositoryJDBC(JdbcTemplate aJdbc){
        this.jdbc = aJdbc;
        setMatchMapper();
    }
    private void setMatchMapper(){
        matchMapper = (rs,i)-> new Match(
                rs.getInt("player1_id"),
                rs.getInt("player2_id"),
                rs.getString("player1_name"),
                rs.getString("player2_name"),
                rs.getInt("score_player1"),
                rs.getInt("score_player2"),
                rs.getInt("winner_id"),
                rs.getInt("round_number")
        );
    }

    @Override
    public List<Round> getAllRounds(){
        String sql = "SELECT * FROM matches ORDER BY round_number, match_id";
        List<Match> matches = jdbc.query(sql, matchMapper);

        // Group matches by round number
        Map<Integer, List<Match>> matchesByRound = matches.stream()
                .collect(Collectors.groupingBy(Match::getRoundNumber));

        List<Round> rounds = new ArrayList<>();
        for (Map.Entry<Integer, List<Match>> entry : matchesByRound.entrySet()) {
            rounds.add(new Round(entry.getValue()));  // Build the round objects
        }

        // Add logic for semi-finals and finals dynamically
        while (canGenerateNextRound(rounds)) {
            List<Match> previousRoundMatches = rounds.get(rounds.size() - 1).getMatches();
            List<Match> nextRoundMatches = generateNextRoundMatches(previousRoundMatches);
            rounds.add(new Round(nextRoundMatches));
        }

        return rounds;
    }

    private boolean canGenerateNextRound(List<Round> rounds) {
        List<Match> lastRoundMatches = rounds.get(rounds.size() - 1).getMatches();  //get the last round
        return lastRoundMatches.stream().allMatch(match -> match.getWinner_id() != null); // check if all matches have a winners
    }

    private List<Match> generateNextRoundMatches(List<Match> previousRoundMatches) {
        List<Match> nextRoundMatches = new ArrayList<>();

        for (int i = 0; i < previousRoundMatches.size(); i += 2) {      // doing two matches at the same time hence += 2
            Match match1 = previousRoundMatches.get(i);
            Match match2 = previousRoundMatches.get(i + 1);

            // Ensure both matches have winners before creating the next match
            if (match1.getWinner_id() != null && match2.getWinner_id() != null) {
                // Determine winner names
                String winnerName1 = match1.getWinner_id().equals(match1.getPlayerId1())
                        ? match1.getPlayerName1()
                        : match1.getPlayerName2();

                String winnerName2 = match2.getWinner_id().equals(match2.getPlayerId1())
                        ? match2.getPlayerName1()
                        : match2.getPlayerName2();

                Match nextMatch = new Match(
                        match1.getWinner_id(),  // playerId1 from match1 winner
                        match2.getWinner_id(),  // playerId2 from match2 winner
                        winnerName1,            // Player 1 Name
                        winnerName2,            // Player 2 Name
                        15,                   // player1Score
                        10,                   // player2Score
                        null,                   // winner_id
                        match1.getRoundNumber() // Increment round number
                );

                nextRoundMatches.add(nextMatch);
            }
        }
        return nextRoundMatches;
    }
}
