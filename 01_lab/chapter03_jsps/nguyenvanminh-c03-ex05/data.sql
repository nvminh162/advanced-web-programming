-- Set charset
SET NAMES utf8mb4;
SET
CHARACTER SET utf8mb4;

-- Drop database if exists
DROP
DATABASE IF EXISTS www_c03_ex05;

-- Create database with UTF8MB4
CREATE
DATABASE www_c03_ex05 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE
www_c03_ex05;

-- Create Department table
CREATE TABLE departments
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Create Employee table
CREATE TABLE employees
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(255) NOT NULL,
    salary DOUBLE NOT NULL,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES departments (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert department data
INSERT INTO departments (id, name)
VALUES (1, 'Giam Doc'),
       (2, 'Ke Toan'),
       (3, 'Phat trien'),
       (4, 'Ke hoach Vat tu'),
       (5, 'Phong Quan Tri');

-- Insert employee data
INSERT INTO employees (name, salary, department_id)
VALUES ('Nguyen Van An', 25000000, 1),
       ('Tran Thi Binh', 18000000, 2),
       ('Le Van Cuong', 22000000, 3),
       ('Pham Thi Dung', 19000000, 2),
       ('Hoang Van Em', 24000000, 3),
       ('Ngo Thi Phuong', 16000000, 4),
       ('Dang Van Giang', 30000000, 1),
       ('Vu Thi Hoa', 20000000, 4),
       ('Bui Van Inh', 26000000, 3),
       ('Cao Thi Kim', 17000000, 5);