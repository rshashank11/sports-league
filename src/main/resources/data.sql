
INSERT INTO roles (role_name)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');


-- Insert users
INSERT INTO users (username, name, password, email, department, role, profile_image, enabled)
VALUES
    ('shashankr1@creditsafe.com', 'Shashank Ramesha', '$2a$10$kcPWazDCSLJOiC6y3ib/ZO5R9Q3srwF5dgkVZ7GCnbWwEM6oZ3s/C', 'shashank@example.com', 'IT', 'Admin', 'profile1.jpg', true),
    ('prateekk2@creditsafe.it', 'Prateek Kesarwani', '$2a$10$GOVHQ8FzG9qmbQGw7bUezemFCG4FfwQzbFne5YfYLhiVAQ4LcrqMS', 'prateek@example.com', 'IT', 'User', 'profile2.jpg', true),
    ('ankits34@creditsafeuk.com', 'Ankit Srivastava', '$2a$10$Nqk3UHGNuQj4oqXiCwhQ.umIgbGTuv8PBZlmN2HuFXx3IeG4YdOaC', 'ankit@example.com', 'Finance', 'User', 'profile3.jpg', true),
    ('tahaa4@creditsafe.co.in', 'Taha Ali', '$2a$10$tAN4gGkjiE69gq6D.wbr4ubznQoPOuwOLiUZfFGGqcOmBVFpT2jR.', 'taha@example.com', 'Marketing', 'User', 'profile4.jpg', true),
    ('johndoe5@creditsafe.com', 'John Doe', '$2a$10$5RIjywVx5G2uV0PSPHV9Iemw1NBTWiw0/gG2F7kzBE/yTSOk79Ku2', 'johndoe5@creditsafe.com', 'IT', 'Admin', 'profile1.jpg', true),
    ('jane.smith@companycheck.co.uk', 'Jane Smith', '$2a$10$8vMoxJvzkTKREoHGG79r6Yyjc63L9r6XMfEx3iLF67L5MZSA4tdKe', 'jane.smith@companycheck.co.uk', 'IT', 'Admin', 'profile1.jpg', true),
    ('alex.brown@creditsafe.be', 'Alex Brown', '$2a$10$XaywUs9ACRMb1QFkgzPb.Erl6h0.t3I1JxbO9v/r0Z41WAWO.bVKa', 'alex.brown@creditsafe.be', 'IT', 'Admin', 'profile1.jpg', true),
    ('emily.davis@creditsafe.co.in', 'Emily Davis', '$2a$10$5jjz.rDnaG6Q.g0sfn9jz64pkxZfPyWo4JXew63fU6B03xeYN.kq2', 'emily.davis@creditsafe.co.in', 'IT', 'Admin', 'profile1.jpg', true),
    ('hiroshi.tanaka@creditsafe.co.jp', 'Hiroshi Tanaka', '$2a$10$OqD2h6Amz5tvHdbDW8fs8Gbn2AMgBQ8npzHzznt3KbRk7dQPYQk5O', 'hiroshi.tanaka@creditsafe.co.jp', 'IT', 'Admin', 'profile1.jpg', true),
    ('mads.olsen@creditsafe.dk', 'Mads Olsen', '$2a$10$QXBhBpghOkNOjyAmOIgMZ1wh4zAVKbNkzN63MdzUMFSyvs9yOF2BW', 'mads.olsen@creditsafe.dk', 'IT', 'Admin', 'profile1.jpg', true),
    ('liisa.virtanen@creditsafe.fi', 'Liisa Virtanen', '$2a$10$1o7pRzg9Ic7Y3VoAqagK1.FMwZZxUb5cfFxj80QgpITfCq.yuOYxC', 'liisa.virtanen@creditsafe.fi', 'IT', 'Admin', 'profile1.jpg', true),
    ('julien.martin@creditsafe.fr', 'Julien Martin', '$2a$10$PTVtYWtC3Prc7TR2UO/7iAWrrw4Nd0zpRpqwn.yJWgsSlyN8goF9', 'julien.martin@creditsafe.fr', 'IT', 'Admin', 'profile1.jpg', true),
    ('geza.kovacs@creditsafe.hu', 'Geza Kovacs', '$2a$10$VbCbgfUquN5F39ZPObCSzV.aeT5iXeFYoHw6X.Vk4wHiFEA7aqV1G', 'geza.kovacs@creditsafe.hu', 'IT', 'Admin', 'profile1.jpg', true),
    ('liam.oconnor@creditsafe.ie', 'Liam O\'Connor', '$2a$10$8FdtKNKQFhK1fi3gpRPnIKhd6ffw7MwVkb17l5Vhn3gVVkmVQ7FlW', 'liam.oconnor@creditsafe.ie', 'IT', 'Admin', 'profile1.jpg', true),
    ('marco.rossi@creditsafe.it', 'Marco Rossi', '$2a$10$3nldS.T9HkwJfaFFh9iS3XUK9fxLyknoUGzxDbOlzT2J62wPzE3N2', 'marco.rossi@creditsafe.it', 'IT', 'Admin', 'profile1.jpg', true),
    ('anna.schmitz@creditsafe.lu', 'Anna Schmitz', '$2a$10$2cIcplDQrxF3zqXYjJ8PMuAZc84byL5HajrkqtrzFX1mVFV5D8hA2', 'anna.schmitz@creditsafe.lu', 'IT', 'Admin', 'profile1.jpg', true),
    ('daan.janssen@creditsafe.nl', 'Daan Janssen', '$2a$10$u3cVAKEXrW7a.G4PZsnU8wOGJAlBlnl46n6g4U.Qe8FkzVUMyd7fG', 'daan.janssen@creditsafe.nl', 'IT', 'Admin', 'profile1.jpg', true),
    ('olav.hansen@creditsafe.no', 'Olav Hansen', '$2a$10$X0yNUvm0b5Un.2ljVGisOlrXDCUQdflgNc0Vuay9wUqRk91bS6k9u', 'olav.hansen@creditsafe.no', 'IT', 'Admin', 'profile1.jpg', true),
    ('eva.karlsson@creditsafe.se', 'Eva Karlsson', '$2a$10$zq.9XJ59a8tbxtYeBAlOnHzkhHgk1wr6oFJ4VeL9RYTnKM3Alu9zC', 'eva.karlsson@creditsafe.se', 'IT', 'Admin', 'profile1.jpg', true),
    ('thomas.schmidt@creditsafede.com', 'Thomas Schmidt', '$2a$10$wv7HZm4P4MjLO2V96tyhfnJzM5dG2r5cbB7g2e.sQ8Guv40r5uC2G', 'thomas.schmidt@creditsafede.com', 'IT', 'Admin', 'profile1.jpg', true);

-- Assign roles to users
INSERT INTO users_roles (username, role_id)
VALUES
    ('shashankr1@creditsafe.com', (SELECT role_id FROM roles WHERE role_name = 'ROLE_USER')),
    ('prateekk2@creditsafe.it', (SELECT role_id FROM roles WHERE role_name = 'ROLE_ADMIN')),
    ('ankits34@creditsafeuk.com', (SELECT role_id FROM roles WHERE role_name = 'ROLE_ADMIN')),
    ('tahaa4@creditsafe.co.in', (SELECT role_id FROM roles WHERE role_name = 'ROLE_USER'));
INSERT INTO rankings (user_id, wins, losses, points)
VALUES
    ((SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 10, 2, 100), -- Shashank Ramesha
    ((SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'), 8, 4, 80),     -- Prateek Kesarwani
    ((SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'), 12, 1, 120), -- Ankit Srivastava
    ((SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'), 15, 0, 150),   -- Taha Ali
    ((SELECT user_id FROM users WHERE username = 'johndoe5@creditsafe.com'), 9, 3, 90),     -- John Doe
    ((SELECT user_id FROM users WHERE username = 'jane.smith@companycheck.co.uk'), 7, 5, 70), -- Jane Smith
    ((SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be'), 11, 2, 110),  -- Alex Brown
    ((SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'), 12, 1, 120), -- Emily Davis
    ((SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp'), 15, 0, 150), -- Hiroshi Tanaka
    ((SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk'), 8, 4, 80),    -- Mads Olsen
    ((SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi'), 10, 2, 100), -- Liisa Virtanen
    ((SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr'), 13, 1, 130), -- Julien Martin
    ((SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu'), 9, 3, 90),    -- Geza Kovacs
    ((SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie'), 6, 6, 60),   -- Liam O'Connor
    ((SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it'), 14, 1, 140),  -- Marco Rossi
    ((SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu'), 7, 5, 70),   -- Anna Schmitz
    ((SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl'), 11, 2, 110), -- Daan Janssen
    ((SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no'), 8, 4, 80),    -- Olav Hansen
    ((SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se'), 10, 2, 100), -- Eva Karlsson
    ((SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com'), 9, 3, 90); -- Thomas Schmidt

INSERT INTO leagues (name, schedule, last_registration_date, venue, sports)
VALUES
    ('Winter Pool League', '2024-12-15 10:00:00', '2024-12-10 23:59:59', 'Sports Club A', 'Pool'),
    ('Spring Darts League', '2024-12-20 14:00:00', '2024-03-15 23:59:59', 'Community Hall B','Darts' ),
    ('Autumn Table Tennis League', '2024-12-11 09:00:00', '2024-09-25 23:59:59', 'Downtown Sports Center','Table Tennis'),
    ('Summer Darts League', '2025-06-10 16:00:00', '2024-06-05 23:59:59', 'Olympic Arena','Darts'),
    ('National Pool Championship', '2025-08-20 12:00:00', '2024-08-10 23:59:59', 'Grand Plaza','Pool');

INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number)
VALUES
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com'),
     'Eva Karlsson', 'Thomas Schmidt', 0, 0,
     null, 1),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'),

     'Ankit Srivastava', 'Taha Ali', 0, 0,
     null, 1),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'johndoe5@creditsafe.com'),
     (SELECT user_id FROM users WHERE username = 'jane.smith@companycheck.co.uk'),
     'John Doe', 'Jane Smith', 0, 0,
     null, 1),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be'),
     (SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'),
     'Alex Brown', 'Emily Davis', 0, 0,
     null, 1);

INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number)
VALUES
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp'),
     (SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk'),
     'Hiroshi Tanaka', 'Mads Olsen', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi'),
     (SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr'),
     'Liisa Virtanen', 'Julien Martin', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu'),
     (SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie'),
     'Geza Kovacs', 'Liam O\'Connor', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it'),
     (SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu'),
     'Marco Rossi', 'Anna Schmitz', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl'),
     (SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no'),
     'Daan Janssen', 'Olav Hansen', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com'),
     'Eva Karlsson', 'Thomas Schmidt', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'),
     'Alex Brown', 'Prateek Kesarwani', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'),
     'Ankit Srivastava', 'Taha Ali', 0, 0, null, 1),

    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp'),
     (SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk'),
     'Hiroshi Tanaka', 'Mads Olsen', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi'),
     (SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr'),
     'Liisa Virtanen', 'Julien Martin', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu'),
     (SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie'),
     'Geza Kovacs', 'Liam O\'Connor', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it'),
     (SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu'),
     'Marco Rossi', 'Anna Schmitz', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl'),
     (SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no'),
     'Daan Janssen', 'Olav Hansen', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com'),
     'Eva Karlsson', 'Thomas Schmidt', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'),
     'Shashank Ramesha', 'Prateek Kesarwani', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'),
     'Ankit Srivastava', 'Taha Ali', 0, 0, null, 1),

    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp'),
     (SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk'),
     'Hiroshi Tanaka', 'Mads Olsen', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi'),
     (SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr'),
     'Liisa Virtanen', 'Julien Martin', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu'),
     (SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie'),
     'Geza Kovacs', 'Liam O\'Connor', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it'),
     (SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu'),
     'Marco Rossi', 'Anna Schmitz', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl'),
     (SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no'),
     'Daan Janssen', 'Olav Hansen', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com'),
     'Eva Karlsson', 'Thomas Schmidt', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'),
     'Shashank Ramesha', 'Prateek Kesarwani', 0, 0, null, 1),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'),
     'Ankit Srivastava', 'Taha Ali', 0, 0, null, 1);


-- Registrations for 'Winter Pool League'
INSERT INTO league_registrations (league_id, user_id)
VALUES
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se')),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com')),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com')),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in')),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'johndoe5@creditsafe.com')),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'jane.smith@companycheck.co.uk')),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be')),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'));

-- Registrations for 'Spring Darts League'
INSERT INTO league_registrations (league_id, user_id)
VALUES
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com')),
    ((SELECT id FROM leagues WHERE name = 'Spring Darts League'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'));

-- Registrations for 'Autumn Table Tennis League'
INSERT INTO league_registrations (league_id, user_id)
VALUES
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com')),
    ((SELECT id FROM leagues WHERE name = 'Autumn Table Tennis League'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'));

-- Registrations for 'Summer Darts League'
INSERT INTO league_registrations (league_id, user_id)
VALUES
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'hiroshi.tanaka@creditsafe.co.jp')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'mads.olsen@creditsafe.dk')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'liisa.virtanen@creditsafe.fi')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'julien.martin@creditsafe.fr')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'geza.kovacs@creditsafe.hu')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'liam.oconnor@creditsafe.ie')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'marco.rossi@creditsafe.it')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'anna.schmitz@creditsafe.lu')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'daan.janssen@creditsafe.nl')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'olav.hansen@creditsafe.no')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'eva.karlsson@creditsafe.se')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'thomas.schmidt@creditsafede.com')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com')),
    ((SELECT id FROM leagues WHERE name = 'Summer Darts League'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'));

