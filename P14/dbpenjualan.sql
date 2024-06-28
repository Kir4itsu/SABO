-- Langkah 1: Membuat database
CREATE DATABASE AplikasiPenjualan;

-- Langkah 2: Menggunakan database yang baru dibuat
USE AplikasiPenjualan;

-- Langkah 3: Membuat tabel user
CREATE TABLE user (
    username VARCHAR(50) PRIMARY KEY,
    nama VARCHAR(100),
    passwordmd5 VARCHAR(32)
);

-- Langkah 4: Mengisi data awal ke tabel user (opsional untuk testing)
-- Password "admin123" dikonversi ke MD5 menjadi "0192023a7bbd73250516f069df18b500"
INSERT INTO user (username, nama, passwordmd5) VALUES
('admin', 'Administrator', '0192023a7bbd73250516f069df18b500');


SELECT MD5('admin123');
-- Output: 0192023a7bbd73250516f069df18b500
