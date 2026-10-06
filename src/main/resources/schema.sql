DROP TABLE IF EXISTS todo;
CREATE TABLE user (
                      id  VARCHAR(55) PRIMARY KEY,
                      username VARCHAR(55) NOT NULL,
                      password VARCHAR(55) NOT NULL
);