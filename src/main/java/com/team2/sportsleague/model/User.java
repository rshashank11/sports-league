package com.team2.sportsleague.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private Integer userId;
    private String name;
    private String username;
    private String department;
    private Integer userRole;
    private List<String> games;
    private String password;
    private boolean enabled;

    public User() {

    }
}
