-- Create database www_c2_ex07
CREATE
DATABASE IF NOT EXISTS www_c2_ex07;
USE
www_c2_ex07;

-- Create table with the structure from your image
CREATE TABLE users
(
    ID        INT(10) NOT NULL AUTO_INCREMENT,
    FIRSTNAME VARCHAR(50) NULL DEFAULT NULL,
    LASTNAME  VARCHAR(50) NULL DEFAULT NULL,
    PICFILE   VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Optional: Insert some sample data for testing
INSERT INTO users (FIRSTNAME, LASTNAME, PICFILE)
VALUES ('John', 'Doe', 'john_doe.jpg'),
       ('Jane', 'Smith', 'jane_smith.png'),
       ('Mike', 'Johnson', 'mike_johnson.gif');

-- Display table structure to verify
DESCRIBE users;

-- Display sample data
SELECT *
FROM users;