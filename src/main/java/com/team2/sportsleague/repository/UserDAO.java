package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setDepartment(rs.getString("department"));
            user.setRole(rs.getString("role"));
            user.setProfileImage(rs.getString("profile_image"));
            return user;
        });
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, department = ?, role = ?, profile_image = ? WHERE username = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getDepartment(), user.getRole(), user.getProfileImage(), user.getUsername());
    }
}
