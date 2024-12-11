package com.team2.sportsleague.DAO;

import com.team2.sportsleague.entity.Photo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhotoDAO {

    private Connection connection;

    public PhotoDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Photo photo) throws SQLException {
        String sql = "INSERT INTO photos (src, metadata, game_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, photo.getSrc());
            statement.setString(2, photo.getMetadata());
            statement.setLong(3, photo.getGameId());
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    photo.setId(keys.getLong(1));
                }
            }
        }
    }

    public List<Photo> findByGameId(long gameId) throws SQLException {
        List<Photo> photos = new ArrayList<>();
        String sql = "SELECT * FROM photos WHERE game_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, gameId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Photo photo = new Photo();
                    photo.setId(resultSet.getLong("id"));
                    photo.setSrc(resultSet.getString("src"));
                    photo.setMetadata(resultSet.getString("metadata"));
                    photo.setGameId(resultSet.getLong("game_id"));
                    photos.add(photo);
                }
            }
        }
        return photos;
    }
}
