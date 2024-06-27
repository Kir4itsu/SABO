CREATE DATABASE IF NOT EXISTS BankApp;

USE BankApp;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role ENUM('Admin', 'BankEmployee', 'Customer') NOT NULL,
    balance DOUBLE DEFAULT 0,
    CONSTRAINT check_balance CHECK (balance >= 0) -- Biar saldo gak bisa minus
);

INSERT INTO users (username, password, role, balance) VALUES ('Kir4itsu', 'Kir4itsu', 'Admin', 0);
