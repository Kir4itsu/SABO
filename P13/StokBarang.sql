CREATE DATABASE stok_barang;

USE stok_barang;

CREATE TABLE tbl_stok (
    id_barang VARCHAR(15) PRIMARY KEY,
    Nama_barang VARCHAR(100),
    stok_barang INT,
    Harga DECIMAL(10, 2)
);
