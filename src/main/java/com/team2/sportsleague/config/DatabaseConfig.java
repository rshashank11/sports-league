package com.team2.sportsleague.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/sports_league_db";
    private static final String USER = "root";
    private static final String PASSWORD = "comsc";

    // Base path for images stored in static folder
    private static final String IMAGE_BASE_PATH = "src/main/resources/static/images/";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to retrieve game image folder path (based on game name)
    public static String getGameImageFolderPath(String gameName) {
        return IMAGE_BASE_PATH + gameName + File.separator;
    }

    // Method to check if a game image folder exists
    public static boolean doesGameImageFolderExist(String gameName) {
        File gameFolder = new File(getGameImageFolderPath(gameName));
        return gameFolder.exists() && gameFolder.isDirectory();
    }
}
