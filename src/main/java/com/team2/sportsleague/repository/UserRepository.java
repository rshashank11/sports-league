package com.team2.sportsleague.repository;

import com.team2.sportsleague.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Repository
@SuppressWarnings("deprecation")
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) ->
                    new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getBoolean("enabled"),
                            rs.getInt("user_role")
                    )
            );
            assert user != null;
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void save(User user) {
        String sql_signup = "INSERT INTO users (username, name, password, enabled) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql_signup, user.getUsername(), user.getName(), user.getPassword(), user.isEnabled());

        String sql_userrole = "INSERT INTO users_roles (username, role_id) VALUES (?, ?)";
        jdbcTemplate.update(sql_userrole, user.getUsername(), user.getUser_role());

    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) ->
                    new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getBoolean("enabled"),
                            rs.getInt("user_role")
                    )
            );
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
