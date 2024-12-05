package com.team2.sportsleague.DAO;

import com.team2.sportsleague.entity.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    private Connection connection;

    public GameDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Game game) throws SQLException {
        String sql = "INSERT INTO games (name, slug) VALUES (?, ?)"; // Updated table name
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, game.getName());
            statement.setString(2, game.getSlug());
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    game.setId(keys.getLong(1));
                }
            }
        }
    }

    public List<Game> findAll() throws SQLException {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM games"; // Updated table name
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Game game = new Game();
                game.setId(resultSet.getLong("id"));
                game.setName(resultSet.getString("name"));
                game.setSlug(resultSet.getString("slug"));
                games.add(game);
            }
        }
        return games;
    }
}
