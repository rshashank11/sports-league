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

        Map<Integer, List<Match>> matchesByRound = matches.stream()
                .collect(Collectors.groupingBy(Match::getRoundNumber));  // Group by round number

        List<Round> rounds = new ArrayList<>();
        for (Map.Entry<Integer, List<Match>> entry : matchesByRound.entrySet()) {
            // Add the list of matches (entry.getValue()) to the Round constructor
            rounds.add(new Round(entry.getValue()));  // Pass only the list of matches, not the map
        }

        return rounds;
    }
}
