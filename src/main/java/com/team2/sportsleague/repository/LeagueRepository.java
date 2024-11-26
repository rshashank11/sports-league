package com.team2.sportsleague.repository;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.config.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeagueRepository {

    // Method to fetch all leagues
    public List<LeagueEntity> findAll() {
        List<LeagueEntity> leagues = new ArrayList<>();
        String query = "SELECT * FROM leagues ORDER BY schedule ASC";  // Query to fetch all leagues sorted by schedule

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                leagues.add(mapResultSetToLeague(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // You may want to log this instead of printing
        }

        return leagues;
    }

    // Method to fetch upcoming leagues (schedule > NOW)
    public List<LeagueEntity> getUpcomingLeagues() {
        List<LeagueEntity> leagues = new ArrayList<>();
        String query = "SELECT * FROM leagues WHERE schedule > NOW() ORDER BY schedule ASC";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                leagues.add(mapResultSetToLeague(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // You may want to log this instead of printing
        }

        return leagues;
    }

    // Method to fetch recent leagues (schedule <= NOW)
    public List<LeagueEntity> getRecentLeagues() {
        List<LeagueEntity> leagues = new ArrayList<>();
        String query = "SELECT * FROM leagues WHERE schedule <= NOW() ORDER BY schedule DESC";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                leagues.add(mapResultSetToLeague(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // You may want to log this instead of printing
        }

        return leagues;
    }

    // Method to fetch leagues by sport
    public List<LeagueEntity> getLeaguesBySport(String sport) {
        List<LeagueEntity> leagues = new ArrayList<>();
        String query = "SELECT * FROM leagues WHERE sports LIKE ? ORDER BY schedule ASC";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + sport + "%");  // Add wildcard for partial match
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                leagues.add(mapResultSetToLeague(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // You may want to log this instead of printing
        }

        return leagues;
    }

    // Method to map result set to LeagueEntity
    private LeagueEntity mapResultSetToLeague(ResultSet resultSet) throws SQLException {
        return new LeagueEntity(
                resultSet.getString("name"),
                resultSet.getTimestamp("schedule").toLocalDateTime(),
                resultSet.getTimestamp("last_registration_date").toLocalDateTime(),
                resultSet.getString("venue"),
                parseSports(resultSet.getString("sports"))
        );
    }

    // Helper method to parse sports field (assuming a comma-separated list)
    private List<String> parseSports(String sports) {
        List<String> sportsList = new ArrayList<>();
        if (sports != null && !sports.isEmpty()) {
            String[] sportsArray = sports.split(",");
            for (String sport : sportsArray) {
                sportsList.add(sport.trim());  // Remove any extra spaces
            }
        }
        return sportsList;
    }
}
