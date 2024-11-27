-- Inserting users into the users table with hashed passwords
INSERT INTO users (username, password, enabled) VALUES
                                                    ('shashankr1@creditsafe.com', '$2a$10$SiZBkjrJhn19Bpn5EomAAevx0HprUAJKPps4wJbT8FO3kE5Ar1Nme', true), #shashankR@1
                                                    ('prateekk2@creditsafe.it', '$2a$10$/mifxplYOJ726OyJ9JVT5OnX9W3WWPf32nVrJelTLO/EcRCjrYt4.', true), #prateekK@2
                                                    ('ankits34@creditsafeuk.com', '$2a$10$Nqk3UHGNuQj4oqXiCwhQ.umIgbGTuv8PBZlmN2HuFXx3IeG4YdOaC', true), #ankitS@34
                                                    ('tahaa4@creditsafe.co.in', '$2a$10$tAN4gGkjiE69gq6D.wbr4ubznQoPOuwOLiUZfFGGqcOmBVFpT2jR.', true); #tahaA@4

-- Inserting roles (user and admin)
INSERT INTO roles(role_id, role_name)
VALUES (1, 'user'), (2, 'admin');

-- Assigning roles to users
-- Assigning 'user' role to all users, and 'admin' role to a specific user
INSERT INTO users_roles (username, role_id) VALUES
                                                ('shashankr1@creditsafe.com', 1),  -- User role for Shashank
                                                ('prateekk2@creditsafe.it', 1),    -- User role for Prateek
                                                ('ankits34@creditsafeuk.com', 1),   -- User role for Ankit
                                                ('tahaa4@creditsafe.co.in', 2);    -- Admin role for Taha
INSERT INTO leagues (league_name, number_of_players, start_date, end_date, status)
VALUES
    ('Table Tennis', 8, '2024-01-01', '2024-12-31', 'active');

-- Quarter-Final Matches (Round 1)
INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number)
VALUES
    (1, 1, 2, 'Alice', 'Bob', 21, 18, 1, 1),
    (1, 3, 4, 'Charlie', 'David', 15, 21, 4, 1),
    (1, 5, 6, 'Emma', 'Frank', 22, 20, 5, 1),
    (1, 7, 8, 'Grace', 'Henry', 19, 21, 8, 1);
