DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

create table if not exists users (
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null
) engine=InnoDB;

create table if not exists roles (
    role_id int(11) not null auto_increment primary key,
    role_name varchar(45) not null
) engine=InnoDB;

create table if not exists users_roles
(
    id       bigint auto_increment primary key,
    username varchar(50) not null,
    role_id  int(11)     not null
) engine=InnoDB;

create view if not exists users_authorities as
    select
        u.username as username,
        CONCAT('role_',r.role_name) as authority
from users u
inner join users_roles ur on u.username = ur.username
inner join roles r on ur.role_id = r.role_id;
