package com.team2.sportsleague.repository;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.config.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeagueRepository {

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
            e.printStackTrace();
        }

        return leagues;
    }

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
            e.printStackTrace(); // Log the error for debugging
        }

        return leagues;
    }

    private LeagueEntity mapResultSetToLeague(ResultSet resultSet) throws SQLException {
        return new LeagueEntity(
                resultSet.getString("name"),
                resultSet.getTimestamp("schedule").toLocalDateTime(),
                resultSet.getTimestamp("last_registration_date").toLocalDateTime(),
                resultSet.getString("venue")
        );
    }
}
