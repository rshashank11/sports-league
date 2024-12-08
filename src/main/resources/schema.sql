/* Drop existing tables */
DROP TABLE IF EXISTS user_updates;
DROP TABLE IF EXISTS photos;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS rankings;
DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS league_registrations;
DROP TABLE IF EXISTS leagues;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

/* Create the games table */
CREATE TABLE IF NOT EXISTS games (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     slug VARCHAR(255) NOT NULL
);

/* Create the photos table */
CREATE TABLE IF NOT EXISTS photos (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      game_id INT NOT NULL,
                                      src VARCHAR(255) NOT NULL,
                                      metadata VARCHAR(255),
                                      FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);

/* Insert sample data into the games table */
INSERT INTO games (name, slug) VALUES
                                   ('Dart', 'dartleague'),
                                   ('Table Tennis', 'table-tennisleague'),
                                   ('Pool', 'poolleague');

/* Insert sample data into the photos table */
INSERT INTO photos (game_id, src, metadata) VALUES
                                                (1, '/images/dart/photos3.jpg', 'Background of Dart Game'),
                                                (1, '/images/dart/photos2.jpg', 'Dart game action shot'),
                                                (1, '/images/dart/photos5.jpg', 'Dart demonstration'),
                                                (1, '/images/dart/photos1.jpg', 'Dart demonstration'),
                                                (1, '/images/dart/photos4.jpg', 'Dart demonstration'),
                                                (1, '/images/dart/photos6.jpg', 'Dart demonstration'),
                                                (2, '/images/tabletennis/photos4.jpg', 'Kids playing table tennis'),
                                                (2, '/images/tabletennis/photos4.jpg', 'Kids playing table tennis'),
                                                (2, '/images/tabletennis/photos4.jpg', 'Kids playing table tennis'),
                                                (2, '/images/tabletennis/photos4.jpg', 'Kids playing table tennis'),
                                                (2, '/images/tabletennis/photos4.jpg', 'Kids playing table tennis'),
                                                (2, '/images/tabletennis/photos4.jpg', 'Kids playing table tennis'),
                                                (3, '/images/pool/photos2.jpg', 'World Cup details for Pool'),
                                                (3, '/images/pool/photos2.jpg', 'World Cup details for Pool'),
                                                (3, '/images/pool/photos2.jpg', 'World Cup details for Pool'),
                                                (3, '/images/pool/photos2.jpg', 'World Cup details for Pool'),
                                                (3, '/images/pool/photos2.jpg', 'World Cup details for Pool');

/* Create the users table */
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) DEFAULT NULL, /* Made email nullable */
                       department VARCHAR(255),
                       role VARCHAR(255),
                       profile_image VARCHAR(255) DEFAULT 'default.jpg',
                       enabled BOOLEAN DEFAULT TRUE,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

/* Create roles table */
CREATE TABLE roles (
                       role_id INT AUTO_INCREMENT PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

/* Create users_roles table */
CREATE TABLE users_roles (
                             username VARCHAR(255) NOT NULL,
                             role_id INT NOT NULL,
                             FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE,
                             FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

/* Create rankings table */
CREATE TABLE rankings (
                          ranking_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          wins INT DEFAULT 0,
                          losses INT DEFAULT 0,
                          points INT DEFAULT 0,
                          FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;


/* Create leagues table */
CREATE TABLE leagues (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         schedule DATETIME NOT NULL,
                         last_registration_date DATETIME NOT NULL,
                         venue VARCHAR(255),
                         sports VARCHAR(100)
) ENGINE=InnoDB;

/* Create matches table */
CREATE TABLE matches (
                         match_id INT AUTO_INCREMENT PRIMARY KEY,
                         league_id INT NOT NULL,
                         player1_id INT,
                         player2_id INT,
                         player1_name VARCHAR(255),
                         player2_name VARCHAR(255),
                         score_player1 INT NOT NULL,
                         score_player2 INT NOT NULL,
                         winner_id INT,
                         round_number INT NOT NULL,
                         FOREIGN KEY (league_id) REFERENCES leagues(id),
                         FOREIGN KEY (player1_id) REFERENCES users(user_id),
                         FOREIGN KEY (player2_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

CREATE TABLE league_registrations (
                                      registration_id INT AUTO_INCREMENT PRIMARY KEY,
                                      league_id INT NOT NULL,
                                      user_id INT NOT NULL,
                                      registration_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                                      FOREIGN KEY (league_id) REFERENCES leagues(id) ON DELETE CASCADE ON UPDATE CASCADE,
                                      FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
                                      CONSTRAINT unique_registration UNIQUE (league_id, user_id)
) ENGINE=InnoDB;

