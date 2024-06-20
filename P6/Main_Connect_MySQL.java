import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_Connect_MySQL {

    public static void main(String[] args) {

        System.out.println("====== Contoh Koneksi JDBC dengan MySQL =======");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
        } catch (ClassNotFoundException ex) {
            System.out.println("MySQL JDBC Driver tidak ditemukan!");
            ex.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Berhasil didaftarkan");
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Kir4itsu");
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Gagal Memuat Koneksi.");
            ex.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Selamat, Anda telah berhasil memuat Koneksi ke DataBase MySQL");
        } else {
            System.out.println("Maaf, Anda Gagal Memuat koneksi");
        }
    }
}