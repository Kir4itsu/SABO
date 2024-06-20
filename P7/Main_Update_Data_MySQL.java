import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main_Update_Data_MySQL {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/Mahasiswa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin";

    public static void main(String[] args) {

        try {
            updateRecord();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void updateRecord() throws SQLException {

        Connection connection = null;
        Statement statement = null;
        int recordCount = 0;

        String updateTableQuery = "update mahasiswa" + " set nama_mhs = 'Andreas Cyclone' " + " where id_mhs = 1";

        try {
            connection = getDatabaseConnection();
            statement = connection.createStatement();
            System.out.println(updateTableQuery);
            statement.execute(updateTableQuery);
            recordCount = statement.getUpdateCount();
            System.out.println(recordCount + " Record Berhasil di-Update di Tabel mahasiswa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }


    public static Connection getDatabaseConnection() {

        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}