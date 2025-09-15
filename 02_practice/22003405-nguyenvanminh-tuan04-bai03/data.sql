CREATE
    DATABASE IF NOT EXISTS nguyenvanminh22003405_ex03;

USE nguyenvanminh22003405_ex03;

DROP TABLE IF EXISTS products;

CREATE TABLE products
(
    ID          INT AUTO_INCREMENT PRIMARY KEY,
    NAME        VARCHAR(255) NOT NULL,
    MODEL       VARCHAR(255),
    DESCRIPTION VARCHAR(255),
    QUANTITY    INT    DEFAULT 0,
    PRICE       DOUBLE DEFAULT 0.00,
    IMGURL      LONGTEXT
);

INSERT INTO products (NAME, MODEL, DESCRIPTION, QUANTITY, PRICE, IMGURL)
VALUES ('Laptop', 'ThinkPad X1', 'Business laptop with 14-inch display', 25, 1299.99, 'iphone17.webp'),
       ('Smartphone', 'Galaxy S23', 'Latest Android smartphone', 50, 899.99, 'iphone17.webp'),
       ('Headphones', 'WH-1000XM4', 'Noise-cancelling wireless headphones', 30, 349.99,
        'iphone17.webp'),
       ('Monitor', 'UltraWide 34"', '34-inch curved gaming monitor', 15, 599.99, 'iphone17.webp'),
       ('Keyboard', 'MX Keys', 'Wireless mechanical keyboard', 40, 129.99, 'iphone17.webp');