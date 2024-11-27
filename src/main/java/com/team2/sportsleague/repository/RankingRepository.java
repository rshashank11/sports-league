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
            rs.getString("name"),
            rs.getInt("wins"),
            rs.getInt("losses"),
            rs.getInt("points")
    );



    public List<Ranking> getAllRankings() {
        String sql = """
        SELECT 
            u.name, 
            r.wins, 
            r.losses, 
            r.points
        FROM rankings r
        JOIN users u ON r.user_id = u.user_id
        ORDER BY r.points DESC
    """;

        try {
            return jdbcTemplate.query(sql, rankingRowMapper);
        } catch (Exception e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw e;
        }
    }



}
