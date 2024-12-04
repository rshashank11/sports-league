package com.team2.sportsleague.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeagueRegistrationRepository {

    private final JdbcTemplate jdbcTemplate;

    public LeagueRegistrationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Long> getUserJoinedLeagues(Long userId) {
        String sql = "SELECT league_id FROM league_registrations WHERE user_id = ?";

        return jdbcTemplate.queryForList(sql, Long.class, userId);
    }

    public boolean isUserAlreadyRegistered(Long userId, Long leagueId) {
        String sql = "SELECT COUNT(*) FROM league_registrations WHERE user_id = ? AND league_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId, leagueId);
        return count > 0;
    }

    public void registerUserToLeague(Long userId, Long leagueId) {
        if (isUserAlreadyRegistered(userId, leagueId)) {
            throw new IllegalArgumentException("User has already registered for this league.");
        }

        String sql = "INSERT INTO league_registrations (league_id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, leagueId, userId);
    }
    public int getRegistrationCountForLeague(Long leagueId) {
        String sql = "SELECT COUNT(*) FROM league_registrations WHERE league_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, leagueId);
    }

    public void unregisterUserFromLeague(Long userId, Long leagueId) {
        String sql = "DELETE FROM league_registrations WHERE user_id = ? AND league_id = ?";
        jdbcTemplate.update(sql, userId, leagueId);
    }

}
