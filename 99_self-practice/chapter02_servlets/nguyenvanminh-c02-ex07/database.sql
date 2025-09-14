-- Create database
CREATE DATABASE IF NOT EXISTS www_c02_ex07;
USE www_c02_ex07;

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FIRSTNAME VARCHAR(50) NOT NULL,
    LASTNAME VARCHAR(50) NOT NULL,
    PICFILE VARCHAR(50) NOT NULL
);

-- Insert sample data (optional)
-- INSERT INTO users (FIRSTNAME, LASTNAME, PICFILE) VALUES ('John', 'Doe', 'sample.jpg');
