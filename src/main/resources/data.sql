-- Insert users into the users table
INSERT INTO users (username, name, password, enabled) VALUES
                                                          ('shashankr1@creditsafe.com', 'Shashank Ramesha', '$2a$10$SiZBkjrJhn19Bpn5EomAAevx0HprUAJKPps4wJbT8FO3kE5Ar1Nme', true),  -- Password: shashankR@1
                                                          ('prateekk2@creditsafe.it', 'Prateek Kesarwani', '$2a$10$/mifxplYOJ726OyJ9JVT5OnX9W3WWPf32nVrJelTLO/EcRCjrYt4.', true),  -- Password: prateekK@2
                                                          ('ankits34@creditsafeuk.com', 'Ankit Srivastava', '$2a$10$Nqk3UHGNuQj4oqXiCwhQ.umIgbGTuv8PBZlmN2HuFXx3IeG4YdOaC', true),  -- Password: ankitS@34
                                                          ('tahaa4@creditsafe.co.in', 'Taha Ali', '$2a$10$tAN4gGkjiE69gq6D.wbr4ubznQoPOuwOLiUZfFGGqcOmBVFpT2jR.', true),  -- Password: tahaA@4
                                                          ('john.doe@creditsafe.com', 'John Doe', '$2a$10$HLOoYt2jqKxs.V7w1VtyKNO7fyaNNBRFjkaCEYhG9h4I4.K9hI0y2', true),  -- Password: johnD@oe
                                                          ('jane.smith@companycheck.co.uk', 'Jane Smith', '$2a$10$8vMoxJvzkTKREoHGG79r6Yyjc63L9r6XMfEx3iLF67L5MZSA4tdKe', true),  -- Password: janeS@123
                                                          ('alex.brown@creditsafe.be', 'Alex Brown', '$2a$10$XaywUs9ACRMb1QFkgzPb.Erl6h0.t3I1JxbO9v/r0Z41WAWO.bVKa', true),  -- Password: alexB@rown
                                                          ('emily.davis@creditsafe.co.in', 'Emily Davis', '$2a$10$5jjz.rDnaG6Q.g0sfn9jz64pkxZfPyWo4JXew63fU6B03xeYN.kq2', true),  -- Password: emilyD@vis
                                                          ('hiroshi.tanaka@creditsafe.co.jp', 'Hiroshi Tanaka', '$2a$10$OqD2h6Amz5tvHdbDW8fs8Gbn2AMgBQ8npzHzznt3KbRk7dQPYQk5O', true),  -- Password: hiroshiT@na
                                                          ('mads.olsen@creditsafe.dk', 'Mads Olsen', '$2a$10$QXBhBpghOkNOjyAmOIgMZ1wh4zAVKbNkzN63MdzUMFSyvs9yOF2BW', true),  -- Password: madsO@lsen
                                                          ('liisa.virtanen@creditsafe.fi', 'Liisa Virtanen', '$2a$10$1o7pRzg9Ic7Y3VoAqagK1.FMwZZxUb5cfFxj80QgpITfCq.yuOYxC', true),  -- Password: liisaV@rtanen
                                                          ('julien.martin@creditsafe.fr', 'Julien Martin', '$2a$10$PTVtYWtC3Prc7TR2UO/7iAWrrw4Nd0zpRpqwn.yJWgsSlyN8goF9', true),  -- Password: julienM@rtin
                                                          ('geza.kovacs@creditsafe.hu', 'Geza Kovacs', '$2a$10$VbCbgfUquN5F39ZPObCSzV.aeT5iXeFYoHw6X.Vk4wHiFEA7aqV1G', true),  -- Password: gezaK@vacs
                                                          ('liam.oconnor@creditsafe.ie', 'Liam O\'Connor', '$2a$10$8FdtKNKQFhK1fi3gpRPnIKhd6ffw7MwVkb17l5Vhn3gVVkmVQ7FlW', true),  -- Password: liamO@connor
                                                          ('marco.rossi@creditsafe.it', 'Marco Rossi', '$2a$10$3nldS.T9HkwJfaFFh9iS3XUK9fxLyknoUGzxDbOlzT2J62wPzE3N2', true),  -- Password: marcoR@ssi
                                                          ('anna.schmitz@creditsafe.lu', 'Anna Schmitz', '$2a$10$2cIcplDQrxF3zqXYjJ8PMuAZc84byL5HajrkqtrzFX1mVFV5D8hA2', true),  -- Password: annaS@chmitz
                                                          ('daan.janssen@creditsafe.nl', 'Daan Janssen', '$2a$10$u3cVAKEXrW7a.G4PZsnU8wOGJAlBlnl46n6g4U.Qe8FkzVUMyd7fG', true),  -- Password: daanJ@nsse
                                                          ('olav.hansen@creditsafe.no', 'Olav Hansen', '$2a$10$X0yNUvm0b5Un.2ljVGisOlrXDCUQdflgNc0Vuay9wUqRk91bS6k9u', true),  -- Password: olavH@nsen
                                                          ('eva.karlsson@creditsafe.se', 'Eva Karlsson', '$2a$10$zq.9XJ59a8tbxtYeBAlOnHzkhHgk1wr6oFJ4VeL9RYTnKM3Alu9zC', true),  -- Password: evaK@rlsson
                                                          ('thomas.schmidt@creditsafede.com', 'Thomas Schmidt', '$2a$10$wv7HZm4P4MjLO2V96tyhfnJzM5dG2r5cbB7g2e.sQ8Guv40r5uC2G', true);  -- Password: thomasS@chmidt

-- Insert roles into the roles table
INSERT INTO roles (role_id, role_name)
VALUES
    (1, 'user'),
    (2, 'admin');

-- Assign roles to users in the users_roles table
INSERT INTO users_roles (username, role_id) VALUES
                                                ('shashankr1@creditsafe.com', 1),  -- User role for Shashank
                                                ('prateekk2@creditsafe.it', 1),    -- User role for Prateek
                                                ('ankits34@creditsafeuk.com', 1), -- User role for Ankit
                                                ('tahaa4@creditsafe.co.in', 2);   -- Admin role for Taha

-- Insert data into rankings table (with example values for wins, losses, points, rank, no longer associated with any sport)
-- Now, users' rankings are tracked across all sports
INSERT INTO rankings (user_id, wins, losses, points) VALUES
                                                               ((SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 10, 2, 100),  -- Shashank Ramesha
                                                               ((SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'), 8, 4, 80),     -- Prateek Kesarwani
                                                               ((SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'), 12, 1, 120),  -- Ankit Srivastava
                                                               ((SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'), 15, 0, 150);   -- Taha Ali

INSERT INTO rankings (user_id, wins, losses, points) VALUES
                                                         ((SELECT user_id FROM users WHERE username = 'john.doe@creditsafe.com'), 9, 3, 90),  -- John Doe
                                                         ((SELECT user_id FROM users WHERE username = 'jane.smith@companycheck.co.uk'), 7, 5, 70),  -- Jane Smith
                                                         ((SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be'), 11, 2, 110),  -- Alex Brown
                                                         ((SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'), 12, 1, 120),  -- Emily Davis
                                                         ((SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp'), 15, 0, 150),  -- Hiroshi Tanaka
                                                         ((SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk'), 8, 4, 80),  -- Mads Olsen
                                                         ((SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi'), 10, 2, 100),  -- Liisa Virtanen
                                                         ((SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr'), 13, 1, 130),  -- Julien Martin
                                                         ((SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu'), 9, 3, 90),  -- Geza Kovacs
                                                         ((SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie'), 6, 6, 60),  -- Liam O'Connor
                                                         ((SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it'), 14, 1, 140),  -- Marco Rossi
                                                         ((SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu'), 7, 5, 70),  -- Anna Schmitz
                                                         ((SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl'), 11, 2, 110),  -- Daan Janssen
                                                         ((SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no'), 8, 4, 80),  -- Olav Hansen
                                                         ((SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se'), 10, 2, 100),  -- Eva Karlsson
                                                         ((SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com'), 9, 3, 90);  -- Thomas Schmidt

-- Insert into leagues
INSERT INTO leagues (league_name, number_of_players, start_date, end_date, status)
VALUES
    ('Table Tennis', 8, '2024-01-01', '2024-12-31', 'active');

-- Quarter-Final Matches (Round 1)
-- Insert Quarter-Final Matches (Round 1) into the matches table
INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number)
VALUES
    (1,
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'),
     'Shashank Ramesha', 'Prateek Kesarwani', 21, 18,
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 1),

    (1,
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'),
     'Ankit Srivastava', 'Taha Ali', 15, 21,
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'), 1),

    (1,
     (SELECT user_id FROM users WHERE username = 'john.doe@creditsafe.com'),
     (SELECT user_id FROM users WHERE username = 'jane.smith@companycheck.co.uk'),
     'John Doe', 'Jane Smith', 22, 20,
     (SELECT user_id FROM users WHERE username = 'john.doe@creditsafe.com'), 1),

    (1,
     (SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be'),
     (SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'),
     'Alex Brown', 'Emily Davis', 19, 21,
     (SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'), 1);
