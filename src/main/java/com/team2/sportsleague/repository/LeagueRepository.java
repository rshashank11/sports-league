package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.League;
import com.team2.sportsleague.config.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeagueRepository {

    public List<League> findAll() {
        List<League> leagues = new ArrayList<>();
        String query = "SELECT * FROM leagues ORDER BY schedule ASC";

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


    public List<League> getUpcomingLeagues() {
        List<League> leagues = new ArrayList<>();
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


    public List<League> getRecentLeagues() {
        List<League> leagues = new ArrayList<>();
        String query = "SELECT * FROM leagues WHERE schedule <= NOW() ORDER BY schedule DESC";

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


    public List<League> getLeaguesBySport(String sport) {
        List<League> leagues = new ArrayList<>();
        String query = "SELECT * FROM leagues WHERE sports LIKE ? ORDER BY schedule ASC";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + sport + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                leagues.add(mapResultSetToLeague(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leagues;
    }


    private League mapResultSetToLeague(ResultSet resultSet) throws SQLException {
        return new League(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("schedule").toLocalDateTime(),
                resultSet.getTimestamp("last_registration_date").toLocalDateTime(),
                resultSet.getString("venue"),
                resultSet.getString("sports")
        );
    }


    private List<String> parseSports(String sports) {
        List<String> sportsList = new ArrayList<>();
        if (sports != null && !sports.isEmpty()) {
            String[] sportsArray = sports.split(",");
            for (String sport : sportsArray) {
                sportsList.add(sport.trim());
            }
        }
        return sportsList;
    }

    public void createLeague(League league) throws SQLException {
        String query = "INSERT INTO leagues (name, schedule, last_registration_date, venue, sports) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, league.getName());
            statement.setTimestamp(2, Timestamp.valueOf(league.getSchedule()));
            statement.setTimestamp(3, Timestamp.valueOf(league.getLastRegistrationDate()));
            statement.setString(4, league.getVenue());
            statement.setString(5, league.getSports());
            statement.executeUpdate();
        }
    }
}
