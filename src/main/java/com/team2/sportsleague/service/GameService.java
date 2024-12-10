package com.team2.sportsleague.service;

import com.team2.sportsleague.config.DatabaseConfig;
import com.team2.sportsleague.entity.Game;
import com.team2.sportsleague.entity.Photo;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    /**
     * Retrieves all games with their associated photos.
     *
     * @return List of games, each containing its associated photos.
     */
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String gameQuery = "SELECT * FROM games";
        String photoQuery = "SELECT * FROM photos WHERE game_id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             Statement gameStatement = connection.createStatement();
             ResultSet gameResultSet = gameStatement.executeQuery(gameQuery)) {

            // Loop through all games
            while (gameResultSet.next()) {
                Game game = new Game();
                game.setId(gameResultSet.getLong("id"));
                game.setName(gameResultSet.getString("name"));
                game.setSlug(gameResultSet.getString("slug"));

                // Retrieve photos for the current game
                List<Photo> photos = new ArrayList<>();
                try (PreparedStatement photoStatement = connection.prepareStatement(photoQuery)) {
                    photoStatement.setLong(1, game.getId());
                    try (ResultSet photoResultSet = photoStatement.executeQuery()) {
                        while (photoResultSet.next()) {
                            Photo photo = new Photo();
                            photo.setId(photoResultSet.getLong("id"));
                            photo.setSrc(photoResultSet.getString("src"));
                            photo.setMetadata(photoResultSet.getString("metadata"));
                            photos.add(photo);
                        }
                    }
                }

                game.setPhotos(photos);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    /**
     * Retrieves the gameId by slug.
     *
     * @param gameSlug The slug of the game.
     * @return The gameId corresponding to the provided slug.
     */
    public Long getGameIdBySlug(String gameSlug) {
        String query = "SELECT id FROM games WHERE slug = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, gameSlug);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getLong("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if no game found with the given slug
    }
}
