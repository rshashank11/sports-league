-- Inserting users into the users table
-- passwords to enter: 1. shashankR@11, prateekK@1, ankitS@2, tahaA@34
INSERT INTO users (username, password, enabled) VALUES
                                                    ('rshashank@creditsafe.com', '$2a$10$Kesh6uBdTvkCaB2nELaVY.AxS9a35BXN./26HnfNTCe4xAqLnDNJ2', true),
                                                    ('kprateek@creditsafe.it', '$2a$10$x1Gg/P2LDEE3C.voMep3guPZX8X45LWPAEYUfDSBjUuQXG69IQ5Nq', true),
                                                    ('ankits@creditsafeuk.com', '$2a$10$burcuJ54mW83VQe/9TqdduP/4zTFn40G6sjcjnYMA1bXBvN5V.CH.', true),
                                                    ('ataha@creditsafe.co.in', '$2a$10$U/Cfh6ATHrCY/9HazJ0rYedUGmzKPx/1araJnWm2BSF7Qwz8mdcGi', true);
insert into roles(role_id, role_name)
values(1, 'user'),(2,'admin');

INSERT INTO users_roles (username, role_id) VALUES
                                                ('rshashank@creditsafe.com', 1),
                                                ('kprateek@creditsafe.it', 1),
                                                ('ankits@creditsafeuk.com', 1),
                                                ('ataha@creditsafe.co.in', 1);