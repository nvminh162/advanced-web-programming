-- 1. Drop database nếu tồn tại
DROP DATABASE IF EXISTS www_regular_spring_jpa;

-- 2. Tạo lại database
CREATE DATABASE www_regular_spring_jpa CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE www_regular_spring_jpa;

-- 3. Tạo bảng departments với UUID native (khớp với JPA entity)
CREATE TABLE departments (
    id UUID PRIMARY KEY DEFAULT (UUID()),
    name VARCHAR(100) NOT NULL
);

-- 4. Tạo bảng employees với UUID native + thêm trường age, email, status (khớp với JPA entity)
CREATE TABLE employees (
    id UUID PRIMARY KEY DEFAULT (UUID()),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    age INT NOT NULL,
    salary DECIMAL(15,2),
    status TINYINT(1) DEFAULT 1 COMMENT '1: Active, 0: Inactive',
    department_id UUID,
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES departments(id)
);

-- Khuyến nghị: index cho khóa ngoại để tối ưu JOIN/lookup
CREATE INDEX idx_employees_department_id ON employees(department_id);

-- 5. Insert dữ liệu mẫu cho departments (UUID tự động generate) - 5 phòng ban
INSERT INTO departments (name) VALUES
('Human Resources'),
('IT'),
('Finance'),
('Marketing'),
('Operations');

-- 6. Insert dữ liệu mẫu cho employees (~20 người, UUID tự động generate + map department ngẫu nhiên)
-- Sử dụng subquery để gán phòng ban ngẫu nhiên cho từng nhân viên

INSERT INTO employees (name, email, age, salary, status, department_id) VALUES
('Nguyen Van An',        'an.nguyen@company.com',        24, 1200.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Tran Thi Bich',        'bich.tran@company.com',        27, 1500.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Le Van Cuong',         'cuong.le@company.com',         31, 2200.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Pham Thi Dung',        'dung.pham@company.com',        29, 1800.00, 0, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Hoang Van Em',         'em.hoang@company.com',         26, 1300.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Do Thi Hoa',           'hoa.do@company.com',           33, 2400.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Bui Van Khang',        'khang.bui@company.com',        28, 1700.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Dang Thi Lan',         'lan.dang@company.com',         25, 1100.00, 0, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Vu Van Minh',          'minh.vu@company.com',          30, 2100.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Ngo Thi Nhung',        'nhung.ngo@company.com',        32, 2300.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Phan Van Quang',       'quang.phan@company.com',       35, 2600.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Huynh Thi Quyen',      'quyen.huynh@company.com',      27, 1600.00, 0, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Duong Van Son',        'son.duong@company.com',        34, 2500.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Cao Thi Trang',        'trang.cao@company.com',        23, 1000.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Truong Van Uyen',      'uyen.truong@company.com',      36, 2800.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Mai Van Viet',         'viet.mai@company.com',         29, 1750.00, 0, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Dinh Thi Xuan',        'xuan.dinh@company.com',        26, 1350.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Pham Van Hoa',         'hoa.pham@company.com',         41, 3200.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Nguyen Thi Yen',       'yen.nguyen@company.com',       24, 1150.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1)),
('Le Thi Giang',         'giang.le@company.com',         38, 3000.00, 1, (SELECT id FROM departments ORDER BY RAND() LIMIT 1));

-- (Tuỳ chọn) Kiểm tra nhanh phân bổ nhân viên theo phòng ban
-- SELECT d.name, COUNT(*) AS total
-- FROM departments d LEFT JOIN employees e ON e.department_id = d.id
-- GROUP BY d.id, d.name
-- ORDER BY d.name;