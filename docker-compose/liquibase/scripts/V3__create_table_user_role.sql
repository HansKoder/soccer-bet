create table user_roles (
    username VARCHAR(30),
    role_name VARCHAR(20),
    granted_date  DATE,
    PRIMARY KEY (username, role_name),
    FOREIGN KEY (username) REFERENCES users
);