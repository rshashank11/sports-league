-- Drop existing tables
DROP TABLE IF EXISTS user_updates;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS rankings;
DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS leagues;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

-- Create users table
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       department VARCHAR(255),
                       role VARCHAR(255),
                       profile_image VARCHAR(255),
                       enabled BOOLEAN DEFAULT TRUE,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Create roles table
CREATE TABLE roles (
                       role_id INT AUTO_INCREMENT PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- Create users_roles table
CREATE TABLE users_roles (
                             username VARCHAR(255) NOT NULL,
                             role_id INT NOT NULL,
                             FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE,
                             FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Create rankings table
CREATE TABLE rankings (
                          ranking_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          wins INT DEFAULT 0,
                          losses INT DEFAULT 0,
                          points INT DEFAULT 0,
                          FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Create leagues table
CREATE TABLE leagues (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         schedule DATETIME NOT NULL,
                         last_registration_date DATETIME NOT NULL,
                         venue VARCHAR(255),
                         sports VARCHAR(100),
                         description TEXT
) ENGINE=InnoDB;

-- Create matches table
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
                         match_time DATETIME NOT NULL,
                         FOREIGN KEY (league_id) REFERENCES leagues(id),
                         FOREIGN KEY (player1_id) REFERENCES users(user_id),
                         FOREIGN KEY (player2_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

-- Create user_updates table
CREATE TABLE user_updates (
                              update_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              updated_fields TEXT NOT NULL,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
