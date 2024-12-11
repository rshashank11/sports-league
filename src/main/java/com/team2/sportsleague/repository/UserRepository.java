package com.team2.sportsleague.repository;

import com.team2.sportsleague.model.User;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

    void save(User user);

    public void updateUser(User user);

    Optional<User> findUserById(int userId);

    Optional<Integer> findUserIdByUsername(String username);

    Optional<User> findByEmail(String email);
}