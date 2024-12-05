//package com.team2.sportsleague.service;
//
//import com.team2.sportsleague.config.DatabaseConfig;
//import com.team2.sportsleague.entity.Game;
//import com.team2.sportsleague.entity.Photo;
//import org.springframework.stereotype.Service;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class GameService {
//
//    public List<Game> getAllGames() {
//        List<Game> games = new ArrayList<>();
//        String gameQuery = "SELECT * FROM games";
//        String photoQuery = "SELECT * FROM photos WHERE game_id = ?";
//
//        try (Connection connection = DatabaseConfig.getConnection();
//             Statement gameStatement = connection.createStatement();
//             ResultSet gameResultSet = gameStatement.executeQuery(gameQuery)) {
//
//            while (gameResultSet.next()) {
//                Game game = new Game();
//                game.setId(gameResultSet.getLong("id"));
//                game.setName(gameResultSet.getString("name"));
//                game.setSlug(gameResultSet.getString("slug"));
//
//                List<Photo> photos = new ArrayList<>();
//                try (PreparedStatement photoStatement = connection.prepareStatement(photoQuery)) {
//                    photoStatement.setLong(1, game.getId());
//                    ResultSet photoResultSet = photoStatement.executeQuery();
//
//                    while (photoResultSet.next()) {
//                        Photo photo = new Photo();
//                        photo.setId(photoResultSet.getLong("id"));
//                        photo.setSrc(photoResultSet.getString("src"));
//                        photo.setMetadata(photoResultSet.getString("metadata"));
//                        photos.add(photo);
//                    }
//                }
//
//                game.setPhotos(photos);
//                games.add(game);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return games;
//    }
//}

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
                game.setId(gameResultSet.getLong("id"));  // 'id' matches the schema column
                game.setName(gameResultSet.getString("name"));  // 'name' matches the schema column
                game.setSlug(gameResultSet.getString("slug"));  // 'slug' matches the schema column

                // Retrieve photos for the current game
                List<Photo> photos = new ArrayList<>();
                try (PreparedStatement photoStatement = connection.prepareStatement(photoQuery)) {
                    photoStatement.setLong(1, game.getId());  // Use game ID for filtering
                    try (ResultSet photoResultSet = photoStatement.executeQuery()) {
                        while (photoResultSet.next()) {
                            Photo photo = new Photo();
                            photo.setId(photoResultSet.getLong("id"));  // 'id' matches the schema column
                            photo.setSrc(photoResultSet.getString("src"));  // 'src' matches the schema column
                            photo.setMetadata(photoResultSet.getString("metadata"));  // 'metadata' matches the schema column
                            photos.add(photo);
                        }
                    }
                }

                game.setPhotos(photos);  // Associate photos with the game
                games.add(game);  // Add the game to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally log or rethrow a custom exception
        }

        return games;
    }
}

