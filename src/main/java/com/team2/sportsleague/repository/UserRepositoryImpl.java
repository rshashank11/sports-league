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
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setDepartment(rs.getString("department"));
            user.setRole(rs.getString("role"));
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
        return jdbcTemplate.queryForList(sql, Integer.class, username).stream().findFirst();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.query(sql, userMapper, username).stream().findFirst();
    }

    @Override
    public void save(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, department = ?, role = ?, profile_image = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getDepartment(), user.getRole(), user.getProfileImage(), user.getUserId());
    }
}
