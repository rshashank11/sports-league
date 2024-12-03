package com.team2.sportsleague.repository;

import com.team2.sportsleague.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper for converting result set into Game object
    private static final class GameMapper implements RowMapper<Game> {
        @Override
        public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
            Game game = new Game();
            game.setId(rs.getLong("id"));
            game.setName(rs.getString("name"));
            game.setSlug(rs.getString("slug"));
            return game;
        }
    }

    // Fetch all games
    public List<Game> findAll() {
        String sql = "SELECT * FROM games";
        return jdbcTemplate.query(sql, new GameMapper());
    }

    // Fetch a game by its slug
    public Game findBySlug(String slug) {
        String sql = "SELECT * FROM games WHERE slug = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{slug}, new GameMapper());
    }
}
