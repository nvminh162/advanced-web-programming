-- MariaDB Script to create accounts table
-- Database: www_c03_ex02 (you can change this name as needed)

CREATE DATABASE IF NOT EXISTS www_c03_ex02;
USE www_c03_ex02;

-- Create accounts table with auto_increment ID
CREATE TABLE IF NOT EXISTS accounts (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FIRSTNAME VARCHAR(50) NOT NULL,
    LASTNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL UNIQUE,
    PASSWORD VARCHAR(50) NOT NULL,
    DATEOFBIRTH DATE
);

-- Optional: Insert some sample data
INSERT INTO accounts (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH) VALUES
('John', 'Doe', 'john.doe@example.com', 'password123', '1990-01-15'),
('Jane', 'Smith', 'jane.smith@example.com', 'securepass456', '1985-05-20'),
('Mike', 'Johnson', 'mike.johnson@example.com', 'mypassword789', '1992-12-10');

-- Show the created table structure
DESCRIBE accounts;

-- Show the inserted data
SELECT * FROM accounts;
