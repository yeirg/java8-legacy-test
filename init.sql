CREATE DATABASE IF NOT EXISTS goods_db;

USE goods_db;

CREATE TABLE goods (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       price INT NOT NULL
);

INSERT INTO goods (name, price) VALUES
                                    ('example A', 150),
                                    ('example B', 300);