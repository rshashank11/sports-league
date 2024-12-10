package com.team2.sportsleague.service;

import com.team2.sportsleague.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Photo photo) {
        String sql = "INSERT INTO photos (game_id, src, metadata) VALUES (?, ?, ?)";  // Adjusted query
        jdbcTemplate.update(sql, photo.getGameId(), photo.getSrc(), photo.getMetadata());  // Adjusted method calls
    }
}
