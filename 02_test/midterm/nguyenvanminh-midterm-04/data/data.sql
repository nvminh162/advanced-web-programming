-- MariaDB SQL Script for Bank Account System
-- Drop database if exists and create new one

DROP DATABASE IF EXISTS www_midterm_04;
CREATE DATABASE www_midterm_04;
USE www_midterm_04;

-- Create bank_account table based on Account entity
CREATE TABLE bank_account (
    account_number INT AUTO_INCREMENT PRIMARY KEY,
    owner_name VARCHAR(255) NOT NULL,
    card_number INT NOT NULL,
    owner_address VARCHAR(500),
    amount DOUBLE DEFAULT 0.0
);

-- Insert sample data
INSERT INTO bank_account (owner_name, card_number, owner_address, amount) VALUES
('Nguyen Van A', 123456789, '123 Le Loi Street, District 1, Ho Chi Minh City', 1500000.00),
('Tran Thi B', 987654321, '456 Nguyen Hue Boulevard, District 1, Ho Chi Minh City', 2750000.50),
('Le Van C', 456789123, '789 Dong Khoi Street, District 1, Ho Chi Minh City', 950000.25),
('Pham Thi D', 321654987, '101 Vo Van Tan Street, District 3, Ho Chi Minh City', 3200000.00),
('Hoang Van E', 147258369, '202 Tran Hung Dao Street, District 5, Ho Chi Minh City', 500000.75),
('Vo Thi F', 963852741, '303 Cach Mang Thang Tam Street, District 10, Ho Chi Minh City', 1800000.00),
('Do Van G', 258741369, '404 Nguyen Thi Minh Khai Street, District 3, Ho Chi Minh City', 4100000.50),
('Bui Thi H', 741852963, '505 Pasteur Street, District 1, Ho Chi Minh City', 675000.25),
('Ngo Van I', 852963741, '606 Hai Ba Trung Street, District 1, Ho Chi Minh City', 2300000.00),
('Dang Thi J', 159357486, '707 Nam Ky Khoi Nghia Street, District 1, Ho Chi Minh City', 1250000.75);

-- Display inserted data
SELECT * FROM bank_account;
