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

-- 4. Tạo bảng Employees với UUID (CHAR 36) + thêm trường age, email, status
CREATE TABLE Employees (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    age INT NOT NULL,
    salary DECIMAL(15,2),
    status TINYINT(1) DEFAULT 1 COMMENT '1: Active, 0: Inactive',
    department_id CHAR(36),
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES Departments(id)
);

-- Khuyến nghị: index cho khóa ngoại để tối ưu JOIN/lookup
CREATE INDEX idx_employees_department_id ON Employees(department_id);

-- 5. Insert dữ liệu mẫu cho Departments (UUID random) - 5 phòng ban
INSERT INTO Departments (id, name) VALUES
(UUID(), 'Human Resources'),
(UUID(), 'IT'),
(UUID(), 'Finance'),
(UUID(), 'Marketing'),
(UUID(), 'Operations');

-- 6. Insert dữ liệu mẫu cho Employees (~20 người, UUID random + map department ngẫu nhiên + có age)
-- Sử dụng subquery (SELECT id FROM Departments ORDER BY RAND() LIMIT 1) để gán phòng ban ngẫu nhiên cho từng nhân viên

INSERT INTO Employees (id, name, email, age, salary, status, department_id) VALUES
(UUID(), 'Nguyen Van An',        'an.nguyen@company.com',        24, 1200.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Tran Thi Bich',        'bich.tran@company.com',        27, 1500.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Le Van Cuong',         'cuong.le@company.com',         31, 2200.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Pham Thi Dung',        'dung.pham@company.com',        29, 1800.00, 0, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Hoang Van Em',         'em.hoang@company.com',         26, 1300.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Do Thi Hoa',           'hoa.do@company.com',           33, 2400.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Bui Van Khang',        'khang.bui@company.com',        28, 1700.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Dang Thi Lan',         'lan.dang@company.com',         25, 1100.00, 0, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Vu Van Minh',          'minh.vu@company.com',          30, 2100.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Ngo Thi Nhung',        'nhung.ngo@company.com',        32, 2300.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Phan Van Quang',       'quang.phan@company.com',       35, 2600.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Huynh Thi Quyen',      'quyen.huynh@company.com',      27, 1600.00, 0, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Duong Van Son',        'son.duong@company.com',        34, 2500.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Cao Thi Trang',        'trang.cao@company.com',        23, 1000.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Truong Van Uyen',      'uyen.truong@company.com',      36, 2800.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Mai Van Viet',         'viet.mai@company.com',         29, 1750.00, 0, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Dinh Thi Xuan',        'xuan.dinh@company.com',        26, 1350.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Pham Van Hoa',         'hoa.pham@company.com',         41, 3200.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Nguyen Thi Yen',       'yen.nguyen@company.com',       24, 1150.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1)),
(UUID(), 'Le Thi Giang',         'giang.le@company.com',         38, 3000.00, 1, (SELECT id FROM Departments ORDER BY RAND() LIMIT 1));

-- (Tuỳ chọn) Kiểm tra nhanh phân bổ nhân viên theo phòng ban
-- SELECT d.name, COUNT(*) AS total
-- FROM Departments d LEFT JOIN Employees e ON e.department_id = d.id
-- GROUP BY d.id, d.name
-- ORDER BY d.name;
