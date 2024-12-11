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

    public MatchRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setMatchMapper();
    }

    private void setMatchMapper() {
        matchMapper = (rs, i) -> new Match(
                rs.getInt("match_id"),
                rs.getInt("league_id"),
                rs.getInt("player1_id"),
                rs.getInt("player2_id"),
                rs.getString("player1_name"),
                rs.getString("player2_name"),
                rs.getObject("score_player1", Integer.class),
                rs.getObject("score_player2", Integer.class),
                rs.getObject("winner_id", Integer.class),
                rs.getInt("round_number")
        );
    }

    // Expose the matchMapper for the tests
    public RowMapper<Match> getMatchMapper() {
        return matchMapper;
    }

    @Override
    public List<Round> getAllRounds(int leagueId) { // Updated to filter by leagueId
        String sql = "SELECT * FROM matches WHERE league_id = ? ORDER BY round_number, match_id";
        List<Match> matches = jdbc.query(sql, matchMapper, leagueId);

        // Group matches by round number
        Map<Integer, List<Match>> matchesByRound = matches.stream()
                .collect(Collectors.groupingBy(Match::getRound_number));

        List<Round> rounds = new ArrayList<>();
        for (Map.Entry<Integer, List<Match>> entry : matchesByRound.entrySet()) {
            rounds.add(new Round(entry.getValue()));  // Build the round objects
        }

        return rounds;
    }

    private boolean canGenerateNextRound(List<Round> rounds) {
        List<Match> lastRoundMatches = rounds.get(rounds.size() - 1).getMatches(); // Get the last round
        return lastRoundMatches.stream().allMatch(match -> match.getWinner_id() != null); // Check if all matches have winners
    }

    public void updateScores(int player1Score, int player2Score, int matchId, int leagueId) {
        try {
            // Update the scores for player1 and player2
            String sql = "UPDATE matches SET score_player1 = ?, score_player2 = ? WHERE match_id = ? AND league_id = ?";
            jdbc.update(sql, player1Score, player2Score, matchId, leagueId);

            // Update the winner based on the scores
            String updateWinnerSql = "UPDATE matches SET winner_id = CASE " +
                    "WHEN score_player1 > score_player2 THEN player1_id " +
                    "WHEN score_player2 > score_player1 THEN player2_id " +
                    "ELSE NULL END " +
                    "WHERE match_id = ? AND league_id = ?";
            jdbc.update(updateWinnerSql, matchId, leagueId);
        } catch (Exception e) {
            throw e;
        }
    }

    public int getNextMatchId() {
        String sql = "SELECT MAX(match_id) FROM matches";
        Integer maxId = jdbc.queryForObject(sql, Integer.class);
        return (maxId == null ? 1 : maxId + 1);
    }

    public void generateNextRoundIfNeeded(int leagueId) {
        // Retrieve all rounds for the specific league
        List<Round> rounds = getAllRounds(leagueId);

        // Check if we can generate the next round
        if (canGenerateNextRound(rounds)) {
            // Get the last round's matches
            List<Match> lastRoundMatches = rounds.get(rounds.size() - 1).getMatches();

            // Generate the next round matches
            List<Match> nextRoundMatches = generateNextRoundMatches(lastRoundMatches, leagueId);

            // SQL query to insert new matches for the next round into the database
            String sql = "INSERT INTO matches (match_id, league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Loop through the generated matches and insert them into the database
            for (Match match : nextRoundMatches) {
                jdbc.update(sql,
                        getNextMatchId(),            // Match ID
                        match.getLeagueId(),           // League ID
                        match.getPlayer1_id(),         // Player 1 ID
                        match.getPlayer2_id(),         // Player 2 ID
                        match.getPlayer1_name(),       // Player 1 Name
                        match.getPlayer2_name(),       // Player 2 Name
                        match.getScore_player1(),      // Player 1 Score
                        match.getScore_player2(),      // Player 2 Score
                        match.getWinner_id(),          // Winner ID
                        match.getRound_number()
                );
            }
        }
    }

    private List<Match> generateNextRoundMatches(List<Match> previousRoundMatches, int leagueId) {
        List<Match> nextRoundMatches = new ArrayList<>();

        // If we are in the final round and only have one match
        if (previousRoundMatches.size() == 1) {
           // No new match to generate
        } else {
            for (int i = 0; i < previousRoundMatches.size(); i += 2) {
                // Ensure we don't go beyond the bounds of the list
                if (i + 1 < previousRoundMatches.size()) {
                    Match match1 = previousRoundMatches.get(i);
                    Match match2 = previousRoundMatches.get(i + 1);

                    if (match1.getWinner_id() != null && match2.getWinner_id() != null) {
                        String winnerName1 = getWinnerName(match1);
                        String winnerName2 = getWinnerName(match2);

                        Match nextMatch = new Match(
                                getNextMatchId(),
                                leagueId,
                                match1.getWinner_id(),
                                match2.getWinner_id(),
                                winnerName1,
                                winnerName2,
                                0,
                                0,
                                null,
                                match1.getRound_number() + 1
                        );
                        nextRoundMatches.add(nextMatch);
                    }
                }
            }
        }
        return nextRoundMatches;
    }

    private String getWinnerName(Match match) {
        return match.getWinner_id().equals(match.getPlayer1_id()) ? match.getPlayer1_name() : match.getPlayer2_name();
    }

    public boolean isUserOwnerOfMatch(int matchId, Long userId) {
        String sql = "SELECT COUNT(*) FROM matches WHERE match_id = ? AND (player1_id = ? OR player2_id = ?)";
        Integer count = jdbc.queryForObject(sql, Integer.class, matchId, userId, userId);
        return count != null && count > 0;
    }

}
