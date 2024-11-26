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
