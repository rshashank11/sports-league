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
//        String query = "SELECT * FROM games";
//
//        try (Connection connection = DatabaseConfig.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
//
//            while (resultSet.next()) {
//                Game game = new Game();
//                game.setId(resultSet.getLong("id")); // Ensure 'id' is long in Game class
//                game.setName(resultSet.getString("name"));
//                game.setSlug(resultSet.getString("slug"));
//                games.add(game);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return games;
//    }
//
//    public Game getGameBySlug(String slug) {
//        Game game = null;
//        String query = "SELECT * FROM games WHERE slug = ?";
//        String photoQuery = "SELECT * FROM photos WHERE game_id = ?";
//
//        try (Connection connection = DatabaseConfig.getConnection();
//             PreparedStatement gameStatement = connection.prepareStatement(query)) {
//
//            gameStatement.setString(1, slug);
//            ResultSet gameResultSet = gameStatement.executeQuery();
//
//            if (gameResultSet.next()) {
//                game = new Game();
//                game.setId(gameResultSet.getLong("id")); // Ensure 'id' is long in Game class
//                game.setName(gameResultSet.getString("name"));
//                game.setSlug(gameResultSet.getString("slug"));
//
//                List<Photo> photos = new ArrayList<>();
//                try (PreparedStatement photoStatement = connection.prepareStatement(photoQuery)) {
//                    photoStatement.setLong(1, game.getId()); // Ensure 'id' is long in Game class
//                    ResultSet photoResultSet = photoStatement.executeQuery();
//
//                    while (photoResultSet.next()) {
//                        Photo photo = new Photo();
//                        photo.setId(photoResultSet.getLong("id")); // Ensure Photo's id is also long
//                        photo.setSrc(photoResultSet.getString("src"));
//                        photo.setMetadata(photoResultSet.getString("metadata"));
//                        photos.add(photo);
//                    }
//                }
//
//                game.setPhotos(photos); // Ensure Game has 'setPhotos()'
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return game;
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

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String gameQuery = "SELECT * FROM games";
        String photoQuery = "SELECT * FROM photos WHERE game_id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             Statement gameStatement = connection.createStatement();
             ResultSet gameResultSet = gameStatement.executeQuery(gameQuery)) {

            while (gameResultSet.next()) {
                Game game = new Game();
                game.setId(gameResultSet.getLong("id"));
                game.setName(gameResultSet.getString("name"));
                game.setSlug(gameResultSet.getString("slug"));

                List<Photo> photos = new ArrayList<>();
                try (PreparedStatement photoStatement = connection.prepareStatement(photoQuery)) {
                    photoStatement.setLong(1, game.getId());
                    ResultSet photoResultSet = photoStatement.executeQuery();

                    while (photoResultSet.next()) {
                        Photo photo = new Photo();
                        photo.setId(photoResultSet.getLong("id"));
                        photo.setSrc(photoResultSet.getString("src"));
                        photo.setMetadata(photoResultSet.getString("metadata"));
                        photos.add(photo);
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
}