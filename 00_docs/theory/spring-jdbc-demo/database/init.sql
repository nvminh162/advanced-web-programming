-- Tạo database
CREATE DATABASE IF NOT EXISTS www_spring_jdbc_demo;
USE www_spring_jdbc_demo;

-- Tạo bảng employees
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

-- Xóa dữ liệu cũ (nếu có)
DELETE FROM employees;

-- Thêm dữ liệu mẫu
INSERT INTO employees (name, role) VALUES 
('Nguyễn Văn A', 'Developer'),
('Trần Thị B', 'Manager'),
('Lê Văn C', 'Designer'),
('Phạm Thị D', 'Tester'),
('Hoàng Văn E', 'DevOps');