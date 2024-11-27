package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.Ranking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankingRepository {

    private final JdbcTemplate jdbcTemplate;

    public RankingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Query to get all rankings with user and sport details
    public List<Ranking> getAllRankings() {
        String sql = "SELECT u.username, r.wins, r.losses, r.points, r.rank, s.sport_name " +
                "FROM rankings r " +
                "JOIN users u ON r.user_id = u.user_id " +
                "JOIN sports s ON r.sport_id = s.sport_id " +
                "ORDER BY r.rank ASC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new Ranking(
                rs.getString("username"),
                rs.getInt("wins"),
                rs.getInt("losses"),
                rs.getInt("points"),
                rs.getInt("rank"),
                rs.getString("sport_name")
        ));
    }
}
