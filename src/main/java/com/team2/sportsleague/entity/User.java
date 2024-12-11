package com.team2.sportsleague.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int userId;
    private String username;
    private String name;
    private String password;
    private boolean enabled;
    private int user_role;

    public User() {}

    public User(int userId, String username, String name, String password, boolean enabled, int user_role) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", user_role=" + user_role +
                '}';
    }
}
