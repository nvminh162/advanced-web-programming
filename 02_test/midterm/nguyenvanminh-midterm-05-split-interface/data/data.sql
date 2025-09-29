-- Drop database if exists and create new one
DROP DATABASE IF EXISTS www_midterm_05;
CREATE DATABASE www_midterm_05;
USE www_midterm_05;

-- Create LOAITHUOC table
CREATE TABLE LOAITHUOC (
    MALOAI BIGINT AUTO_INCREMENT PRIMARY KEY,
    TENLOAI VARCHAR(255) NOT NULL
);

-- Create THUOC table
CREATE TABLE THUOC (
    MATHUOC BIGINT AUTO_INCREMENT PRIMARY KEY,
    TENTHUOC VARCHAR(255) NOT NULL,
    GIA DOUBLE NOT NULL,
    NAMSX INT NOT NULL,
    MALOAI BIGINT,
    FOREIGN KEY (MALOAI) REFERENCES LOAITHUOC(MALOAI)
);

-- Insert data into LOAITHUOC table
INSERT INTO LOAITHUOC (TENLOAI) VALUES
('Thuốc kháng sinh'),
('Thuốc giảm đau'),
('Thuốc hạ sốt'),
('Thuốc tim mạch'),
('Thuốc tiêu hóa'),
('Thuốc bổ'),
('Thuốc dị ứng');

-- Insert data into THUOC table
INSERT INTO THUOC (TENTHUOC, GIA, NAMSX, MALOAI) VALUES
('Amoxicillin 500mg', 25000, 2023, 1),
('Cephalexin 250mg', 35000, 2023, 1),
('Paracetamol 500mg', 15000, 2024, 2),
('Ibuprofen 400mg', 22000, 2023, 2),
('Aspirin 100mg', 18000, 2024, 3),
('Panadol Extra', 28000, 2023, 3),
('Digoxin 0.25mg', 45000, 2022, 4),
('Propranolol 40mg', 38000, 2023, 4),
('Omeprazole 20mg', 32000, 2024, 5),
('Simethicone 40mg', 19000, 2023, 5),
('Vitamin B Complex', 42000, 2024, 6),
('Calcium + D3', 35000, 2023, 6),
('Cetirizine 10mg', 26000, 2024, 7),
('Loratadine 10mg', 29000, 2023, 7),
('Azithromycin 500mg', 55000, 2022, 1),
('Diclofenac 50mg', 24000, 2023, 2),
('Metformin 500mg', 21000, 2024, 4),
('Domperidone 10mg', 17000, 2023, 5),
('Iron Folic Acid', 33000, 2024, 6),
('Chlorpheniramine 4mg', 16000, 2023, 7);