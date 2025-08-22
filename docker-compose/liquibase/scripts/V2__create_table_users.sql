create table users (
    username VARCHAR(30) PRIMARY KEY,
    password VARCHAR(200) NOT NULL,
    email VARCHAR(50),
    locked BOOLEAN,
    disabled BOOLEAN
);