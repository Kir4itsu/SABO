package P14.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    public static String url = "jdbc:mysql://localhost/penjualan";
    public static String user = "root";
    public static String password = "Kir4itsu";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public static void setUrl(String aUrl) {
        url = aUrl;
    }
}
