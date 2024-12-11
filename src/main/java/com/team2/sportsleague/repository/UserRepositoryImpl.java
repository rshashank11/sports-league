
package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> userMapper;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = (rs, rowNum) -> {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("name"));
            user.setDepartment(rs.getString("department"));
            user.setUserRole(rs.getInt("role"));
            user.setPassword(rs.getString("password"));
            user.setEnabled(rs.getBoolean("enabled"));
            return user;
    };

    }

    @Override
    public Optional<User> findUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return jdbcTemplate.query(sql, userMapper, userId).stream().findFirst();
    }

    @Override
    public Optional<Integer> findUserIdByUsername(String username) {
        String sql = "SELECT user_id FROM users WHERE username = ?";
        try {
            Integer userId = jdbcTemplate.queryForObject(sql, Integer.class, username);
            return Optional.ofNullable(userId);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(User user) {
        String sqlInsertUser = "INSERT INTO users (username, name, email, password, enabled) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsertUser, user.getUsername(), user.getName(), user.getUsername(), user.getPassword(), user.isEnabled());

        String sqlInsertRole = "INSERT INTO users_roles (username, role_id) VALUES (?, ?)";
        jdbcTemplate.update(sqlInsertRole, user.getUsername(), user.getUserRole());
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, department = ? WHERE username = ?";
        jdbcTemplate.update(sql, user.getName(), user.getUsername(), user.getDepartment(), user.getUsername());
    }


    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, userMapper, username));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, userMapper, email));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
