package com.team2.sportsleague.model;

import java.util.List;

public class User {

    private int userId;
    private String username;
    private String name;
    private String email;
    private String department;
    private String role;
    private List<String> games;

    // Default constructor
    public User() {}

    // Parameterized constructor
    public User(String name, String email, String employeeId, String department, String role, List<String> games) {
        this.name = name;
        this.email = email;
        this.userId = Integer.parseInt(employeeId);  // Assuming employeeId is the same as userId
        this.department = department;
        this.role = role;
        this.games = games;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getGames() {
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }
}
