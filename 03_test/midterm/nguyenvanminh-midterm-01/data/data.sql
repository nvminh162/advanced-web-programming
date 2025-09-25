-- Drop database if exists and create new one
DROP
DATABASE IF EXISTS www_midterm_01;
CREATE
DATABASE www_midterm_01;
USE
www_midterm_01;

-- Create departments table
CREATE TABLE departments
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

-- Create employees table
CREATE TABLE employees
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(100) NOT NULL,
    salary        DECIMAL(10, 2),
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES departments (id) ON DELETE SET NULL
);

-- Insert departments data
INSERT INTO departments (name)
VALUES ('Phòng Nhân sự'),
       ('Phòng Kỹ thuật'),
       ('Phòng Marketing'),
       ('Phòng Kế toán'),
       ('Phòng Kinh doanh');

-- Insert employees data
INSERT INTO employees (name, salary, department_id)
VALUES ('Nguyễn Văn An', 15000000, 1),
       ('Trần Thị Bình', 18000000, 2),
       ('Lê Văn Cường', 12000000, 3),
       ('Phạm Thị Dung', 16000000, 1),
       ('Hoàng Văn Em', 22000000, 2),
       ('Vũ Thị Hoa', 14000000, 4),
       ('Đỗ Văn Giang', 17000000, 2),
       ('Bùi Thị Hương', 13000000, 3),
       ('Mai Văn Khoa', 19000000, 5),
       ('Phan Thị Lan', 15500000, 4),
       ('Tô Văn Minh', 20000000, 2),
       ('Đinh Thị Nga', 11000000, 1),
       ('Lý Văn Phong', 16500000, 5),
       ('Chu Thị Quỳnh', 14500000, 3),
       ('Võ Văn Sơn', 21000000, 2);