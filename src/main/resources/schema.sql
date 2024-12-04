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
CREATE TABLE `leagues` (
                           `id` INT(11) NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(255) NOT NULL COLLATE 'latin1_swedish_ci',
                           `schedule` DATETIME NOT NULL,
                           `last_registration_date` DATETIME NOT NULL,
                           `venue` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                           `sports` VARCHAR(100) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                           PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='latin1_swedish_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=54
;
-- Create the matches table
CREATE TABLE matches (
                         match_id INT AUTO_INCREMENT PRIMARY KEY,
                         league_id INT NOT NULL,         -- Changed from 'id' to 'league_id'
                         player1_id INT NOT NULL,
                         player2_id INT NOT NULL,
                         player1_name VARCHAR(255) NOT NULL,
                         player2_name VARCHAR(255) NOT NULL,
                         score_player1 INT NOT NULL,
                         score_player2 INT NOT NULL,
                         winner_id INT,
                         round_number INT NOT NULL,
                         FOREIGN KEY (league_id) REFERENCES leagues(id),  -- Updated to match 'league_id'
                         FOREIGN KEY (player1_id) REFERENCES users(user_id),
                         FOREIGN KEY (player2_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

