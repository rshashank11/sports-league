package com.team2.sportsleague.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/sports_league_db";
    private static final String USER = "root";
    private static final String PASSWORD = "comsc";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
