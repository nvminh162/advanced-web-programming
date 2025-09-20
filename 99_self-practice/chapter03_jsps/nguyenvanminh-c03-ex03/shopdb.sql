-- MariaDB Script for www_c03_ex03 database
-- Database: www_c03_ex03
-- Table: products

CREATE
DATABASE IF NOT EXISTS www_c03_ex03;

USE
www_c03_ex03;

DROP TABLE IF EXISTS products;

CREATE TABLE products
(
    ID          INT AUTO_INCREMENT PRIMARY KEY,
    MODEL       VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(500),
    QUANTITY    INT DEFAULT 0,
    PRICE DOUBLE(10,2) DEFAULT 0.00,
    IMGURL      LONGTEXT
);

INSERT INTO products (MODEL, DESCRIPTION, QUANTITY, PRICE, IMGURL)
VALUES ('SamSung TV', 'Latest iPhone with advanced features', 50, 999.99, 'samsung.jpg'),
       ('Sony TV', 'Premium Android smartphone', 30, 899.99, 'sony.jpg'),
       ('iPhone 15', 'Professional laptop for developers', 20, 1999.99, 'iphone15.jpg'),
       ('iPhone 16', 'Ultrabook with excellent performance', 25, 1299.99, 'iphone16.jpg');

SELECT *
FROM products;
