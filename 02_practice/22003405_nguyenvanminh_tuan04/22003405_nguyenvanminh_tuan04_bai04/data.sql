CREATE
DATABASE IF NOT EXISTS www_practice_week04 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE
www_practice_week04;

CREATE TABLE books
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255)   NOT NULL,
    author   VARCHAR(255)   NOT NULL,
    image    VARCHAR(500),
    price    DECIMAL(10, 2) NOT NULL,
    quantity INT            NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO books (name, author, image, price, quantity)
VALUES ('Lập trình Java cơ bản', 'Nguyễn Văn A', 'java-core.png', 250000.00, 50),
       ('Spring Boot thực hành', 'Trần Thị B', 'spring-boot.jpg', 350000.00, 30),
       ('Cơ sở dữ liệu MySQL', 'Lê Văn C', 'mysql.webp', 280000.00, 25),
       ('Thiết kế Web với HTML/CSS', 'Phạm Thị D', 'html-css.webp', 200000.00, 40),
       ('JavaScript nâng cao', 'Hoàng Văn E', 'js-advance.jpg', 320000.00, 35),
       ('Python cho người mới bắt đầu', 'Võ Thị F', 'python.jpg', 270000.00, 45);