package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MatchRepositoryJDBCTest {

    @Autowired
    private MatchRepositoryJDBC matchRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        // Temporarily disable foreign key checks
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 0");

        // Drop existing tables
        jdbcTemplate.execute("DROP TABLE IF EXISTS matches");
        jdbcTemplate.execute("DROP TABLE IF EXISTS users");

        // Re-enable foreign key checks
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 1");

        // Create the 'users' table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (" +
                "user_id INT AUTO_INCREMENT, " +
                "username VARCHAR(255) NOT NULL UNIQUE, " +
                "name VARCHAR(255) NOT NULL, " +
                "password VARCHAR(255) NOT NULL, " +
                "email VARCHAR(255), " +
                "department VARCHAR(255), " +
                "role VARCHAR(255), " +
                "profile_image VARCHAR(255) DEFAULT 'default.jpg', " +
                "enabled BOOLEAN DEFAULT TRUE, " +
                "PRIMARY KEY (user_id))");

        // Create the 'matches' table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS matches (" +
                "match_id INT AUTO_INCREMENT, " +
                "league_id INT, " +
                "player1_id INT, " +
                "player2_id INT, " +
                "player1_name VARCHAR(255), " +
                "player2_name VARCHAR(255), " +
                "score_player1 INT DEFAULT 0, " +
                "score_player2 INT DEFAULT 0, " +
                "winner_id INT, " +
                "round_number INT, " +
                "PRIMARY KEY (match_id), " +
                "FOREIGN KEY (player1_id) REFERENCES users(user_id), " +
                "FOREIGN KEY (player2_id) REFERENCES users(user_id))");

        // Insert test data into the 'users' table
        jdbcTemplate.update("INSERT INTO users (username, name, password) VALUES ('Player1', 'John Doe', 'password123')");
        jdbcTemplate.update("INSERT INTO users (username, name, password) VALUES ('Player2', 'Jane Doe', 'password123')");
        jdbcTemplate.update("INSERT INTO users (username, name, password) VALUES ('Player3', 'Alice Smith', 'password123')");
        jdbcTemplate.update("INSERT INTO users (username, name, password) VALUES ('Player4', 'Bob Brown', 'password123')");

        // Insert test data into the 'matches' table
        jdbcTemplate.update("INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number) " +
                "VALUES (1, 1, 2, 'Player1', 'Player2', 2, 1, 1, 1)");
        jdbcTemplate.update("INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number) " +
                "VALUES (1, 3, 4, 'Player3', 'Player4', 0, 1, 4, 1)");
    }


    @Test
    public void testGetAllRounds() {
        int leagueId = 1;
        List<Round> rounds = matchRepository.getAllRounds(leagueId);

        assertNotNull(rounds);
        assertEquals(1, rounds.size());

        List<Match> matches = rounds.get(0).getMatches();
        assertEquals(2, matches.size());
        assertEquals("Player1", matches.get(0).getPlayer1_name());
        assertEquals("Player2", matches.get(0).getPlayer2_name());
    }

    @Test
    public void testUpdateScores() {
        int player1Score = 3;
        int player2Score = 2;
        int matchId = 1;
        int leagueId = 1;

        matchRepository.updateScores(player1Score, player2Score, matchId, leagueId);

        Match match = jdbcTemplate.queryForObject(
                "SELECT * FROM matches WHERE match_id = ?",
                new Object[]{matchId},
                matchRepository.getMatchMapper());

        assertEquals(player1Score, match.getScore_player1());
        assertEquals(player2Score, match.getScore_player2());
    }

    @Test
    public void testGetNextMatchId() {
        int nextMatchId = matchRepository.getNextMatchId();
        assertEquals(3, nextMatchId); // Next match_id should be 3
    }

    @Test
    public void testGenerateNextRoundIfNeeded() {
        int leagueId = 1;

        jdbcTemplate.update("UPDATE matches SET winner_id = player1_id WHERE round_number = 1");

        matchRepository.generateNextRoundIfNeeded(leagueId);

        List<Round> rounds = matchRepository.getAllRounds(leagueId);
        assertEquals(2, rounds.size());
    }

    @Test
    public void testIsUserOwnerOfMatch() {
        int matchId = 1;
        long userId = 1;

        boolean isOwner = matchRepository.isUserOwnerOfMatch(matchId, userId);
        assertTrue(isOwner);

        long nonOwnerUserId = 5;
        boolean isNotOwner = matchRepository.isUserOwnerOfMatch(matchId, nonOwnerUserId);
        assertFalse(isNotOwner);
    }
}
