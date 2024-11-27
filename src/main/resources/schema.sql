DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
                                     username VARCHAR(50) NOT NULL PRIMARY KEY,
                                     password VARCHAR(500) NOT NULL,
                                     enabled BOOLEAN NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS roles (
                                     role_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                     role_name VARCHAR(45) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS users_roles (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           username VARCHAR(50) NOT NULL,
                                           role_id INT(11) NOT NULL,
                                           FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE,
                                           FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE VIEW IF NOT EXISTS users_authorities AS
SELECT
    u.username AS username,
    CONCAT('role_', r.role_name) AS authority
FROM users u
         INNER JOIN users_roles ur ON u.username = ur.username
         INNER JOIN roles r ON ur.role_id = r.role_id;
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
