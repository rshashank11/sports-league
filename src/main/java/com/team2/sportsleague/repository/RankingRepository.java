package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.Ranking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankingRepository {

    private final JdbcTemplate jdbcTemplate;

    public RankingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Ranking> rankingRowMapper = (rs, rowNum) -> new Ranking(
            rs.getString("name"),   // User's name
            rs.getInt("wins"),      // Number of wins
            rs.getInt("losses"),    // Number of losses
            rs.getInt("rank"),      // Rank
            rs.getInt("points")     // Points
    );

    public List<Ranking> getAllRankings() {
        String sql = """
        SELECT 
            u.name, 
            r.wins, 
            r.losses, 
            r.rank, 
            r.points
        FROM rankings r
        JOIN users u ON r.user_id = u.user_id
        ORDER BY r.rank ASC
    """;

        try {
            return jdbcTemplate.query(sql, rankingRowMapper);
        } catch (Exception e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw e;
        }
    }


}
