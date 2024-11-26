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
