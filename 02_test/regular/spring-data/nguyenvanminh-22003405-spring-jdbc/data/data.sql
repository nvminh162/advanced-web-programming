-- 1. Drop database nếu tồn tại
DROP DATABASE IF EXISTS www_regular_spring_jdbc;

-- 2. Tạo lại database
CREATE DATABASE www_regular_spring_jdbc CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE www_regular_spring_jdbc;

-- 3. Tạo bảng Departments với UUID (CHAR 36)
CREATE TABLE Departments (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- 4. Tạo bảng Employees với UUID (CHAR 36) + thêm trường age
CREATE TABLE Employees (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    salary DECIMAL(15,2),
    department_id CHAR(36),
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES Departments(id)
);

-- 5. Insert dữ liệu mẫu cho Departments (UUID random)
INSERT INTO Departments (id, name) VALUES
(UUID(), 'Human Resources'),
(UUID(), 'IT'),
(UUID(), 'Finance');

-- 6. Insert dữ liệu mẫu cho Employees (UUID random + map department + có age)
INSERT INTO Employees (id, name, age, salary, department_id) VALUES
(UUID(), 'Nguyen Van A', 25, 1000.00, (SELECT id FROM Departments WHERE name = 'Human Resources')),
(UUID(), 'Tran Thi B', 28, 1200.00, (SELECT id FROM Departments WHERE name = 'IT')),
(UUID(), 'Le Van C', 30, 1500.00, (SELECT id FROM Departments WHERE name = 'IT')),
(UUID(), 'Pham Thi D', 35, 2000.00, (SELECT id FROM Departments WHERE name = 'Finance'));
