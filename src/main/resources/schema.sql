-- Drop the tables if they exist
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS rankings;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

-- Create the users table
CREATE TABLE users (
                       user_id INT(11) NOT NULL AUTO_INCREMENT,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       enabled BOOLEAN DEFAULT true,
                       PRIMARY KEY (user_id)
) ENGINE=InnoDB;

-- Create the roles table
CREATE TABLE roles (
                       role_id INT(11) NOT NULL AUTO_INCREMENT,
                       role_name VARCHAR(50) NOT NULL UNIQUE,
                       PRIMARY KEY (role_id)
) ENGINE=InnoDB;

-- Create the users_roles table for mapping users to roles
CREATE TABLE users_roles (
                             username VARCHAR(255) NOT NULL,
                             role_id INT(11) NOT NULL,
                             FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE ON UPDATE CASCADE,
                             FOREIGN KEY (role_id) REFERENCES roles (role_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Create the rankings table (without sport_id, as it is no longer needed)
CREATE TABLE rankings (
                          ranking_id INT(11) NOT NULL AUTO_INCREMENT,
                          user_id INT(11) NOT NULL,
                          wins INT(11) DEFAULT 0,
                          losses INT(11) DEFAULT 0,
                          points INT(11) DEFAULT 0,
                          rank INT(11) DEFAULT 0,
                          PRIMARY KEY (ranking_id) USING BTREE,
                          FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;
DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS leagues;

CREATE TABLE leagues (
                         league_id INT AUTO_INCREMENT PRIMARY KEY,   -- Unique ID for each league
                         league_name VARCHAR(255) NOT NULL,           -- Name of the league (e.g., "Premier League")
                         number_of_players INT,                      -- Number of players in the league
                         start_date DATE,                             -- Start date of the league
                         end_date DATE,                               -- End date of the league
                         status VARCHAR(50)                           -- Status of the league (e.g., active, completed)
)engine= InnoDB;


CREATE TABLE matches (
                         league_id INT,
                         match_id INT AUTO_INCREMENT PRIMARY KEY,
                         player1_id INT NOT NULL,
                         player2_id INT NOT NULL,
                         player1_name VARCHAR(128) NOT NULL,
                         player2_name VARCHAR(128) NOT NULL,
                         score_player1 INT NULL,
                         score_player2 INT NULL,
                         winner_id INT NULL,
                         round_number INT NOT NULL,
                         FOREIGN KEY (league_id) REFERENCES leagues(league_id)
)engine=InnoDB;
