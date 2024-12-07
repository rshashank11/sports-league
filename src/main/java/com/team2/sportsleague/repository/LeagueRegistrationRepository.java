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
        assignPlayerToMatch(userId, leagueId);
    }

    private void assignPlayerToMatch(Long userId, Long leagueId) {
        String findMatchSql = "SELECT match_id FROM matches WHERE league_id = ? AND player1_id IS NOT NULL AND player2_id IS NULL LIMIT 1";
        List<Long> matchIds = jdbcTemplate.query(findMatchSql, new Object[]{leagueId}, (rs, rowNum) -> rs.getLong("match_id"));

        if (!matchIds.isEmpty()) {
            Long matchId = matchIds.get(0);

            String updateMatchSql = "UPDATE matches SET player2_id = ? WHERE match_id = ?";
            jdbcTemplate.update(updateMatchSql, userId, matchId);

            String updatePlayerNameSql = "UPDATE matches SET player2_name = (SELECT name FROM users WHERE user_id = ?) WHERE match_id = ?";
            jdbcTemplate.update(updatePlayerNameSql, userId, matchId);

        } else {
            String createMatchSql = "INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, round_number) "
                    + "VALUES (?, ?, NULL, (SELECT name FROM users WHERE user_id = ?), NULL, 0, 0, 1)";
            jdbcTemplate.update(createMatchSql, leagueId, userId, userId);
        }
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
