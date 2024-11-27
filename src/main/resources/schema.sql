-- Drop the users_roles table if it exists
DROP TABLE IF EXISTS users_roles;

-- Drop the users table if it exists
DROP TABLE IF EXISTS users;

-- Drop the roles table if it exists
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


