CREATE DATABASE IF NOT EXISTS SportsLeague;

USE SportsLeague;

CREATE TABLE games (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       slug VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE photos (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        game_id INT NOT NULL,
                        src VARCHAR(255) NOT NULL,
                        metadata VARCHAR(255),
                        FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);

INSERT INTO games (name, slug) VALUES
                                   ('Dart', 'dart'),
                                   ('Table Tennis', 'table-tennis'),
                                   ('Pool', 'pool');

INSERT INTO photos (game_id, src, metadata) VALUES
                                                (1, '/DART/Background.jpg', 'Background of Dart Game'),
                                                (1, '/DART/dart.jpg', 'Dart game action shot'),
                                                (1, '/DART/demo.jpg', 'Dart demonstration'),
                                                (2, '/TT/sport.jpg', 'Kids playing table tennis'),
                                                (3, '/POOL/game.png', 'World Cup details for Pool');
