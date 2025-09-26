DROP
DATABASE IF EXISTS www_midterm_02;
CREATE
DATABASE www_midterm_02 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE
www_midterm_02;

CREATE TABLE books
(
    id       CHAR(36) PRIMARY KEY DEFAULT (UUID()),
    name     VARCHAR(255) NOT NULL,
    author   VARCHAR(255),
    image    VARCHAR(255),
    quantity INT          NOT NULL,
    price DOUBLE NOT NULL
);

CREATE TABLE orders
(
    id      CHAR(36) PRIMARY KEY DEFAULT (UUID()),
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    payment_method ENUM('PAYPAL', 'ATM', 'VISA'),
    total DOUBLE NOT NULL
);

INSERT INTO books (name, author, image, quantity, price)
VALUES ('Java Programming', 'James Gosling', 'java.webp', 10, 150000),
       ('Spring Boot in Action', 'Craig Walls', 'springboot.webp', 5, 180000),
       ('Clean Code', 'Robert C. Martin', 'cleancode.webp', 7, 120000),
       ('Effective Java', 'Joshua Bloch', 'effectivejava.webp', 3, 200000);

INSERT INTO orders (name, address, payment_method, total)
VALUES ('Nguyen Van Minh', 'HCMC', 'PAYPAL', 190000),
       ('Paul Dev', 'Hanoi', 'ATM', 130000),
       ('Alice', 'Da Nang', 'VISA', 170000);
