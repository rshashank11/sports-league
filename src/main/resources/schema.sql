-- Drop existing tables to avoid conflicts
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS rankings;
DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS leagues;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

-- Create the users table
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       enabled BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB;

-- Create the roles table
CREATE TABLE roles (
                       role_id INT AUTO_INCREMENT PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- Create the users_roles mapping table
CREATE TABLE users_roles (
                             username VARCHAR(255) NOT NULL,
                             role_id INT NOT NULL,
                             FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE,
                             FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Create the rankings table
CREATE TABLE rankings (
                          ranking_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          wins INT DEFAULT 0,
                          losses INT DEFAULT 0,
                          points INT DEFAULT 0,
                          FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Create the leagues table
CREATE TABLE leagues (
                         league_id INT AUTO_INCREMENT PRIMARY KEY,
                         league_name VARCHAR(255) NOT NULL,
                         number_of_players INT,
                         start_date DATE,
                         end_date DATE,
                         status VARCHAR(50)
) ENGINE=InnoDB;

-- Create the matches table
CREATE TABLE matches (
                         match_id INT AUTO_INCREMENT PRIMARY KEY,
                         league_id INT NOT NULL,
                         player1_id INT NOT NULL,
                         player2_id INT NOT NULL,
                         player1_name VARCHAR(255) NOT NULL,
                         player2_name VARCHAR(255) NOT NULL,
                         score_player1 INT,
                         score_player2 INT,
                         winner_id INT,
                         round_number INT NOT NULL,
                         FOREIGN KEY (league_id) REFERENCES leagues(league_id)
) ENGINE=InnoDB;