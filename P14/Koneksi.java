package P14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private Connection conn;
    private String url = "jdbc:mysql://localhost:3306/AplikasiPenjualan";
    private String user = "root";
    private String pass = "Kir4itsu";

    public Connection getConn() {
        return conn;
    }

    /**
     * Membuka koneksi ke database
     */
    public void openConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Menutup koneksi ke database
     */
    public void closeConn() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
