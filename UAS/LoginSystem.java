import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSystem {
    private Connection connect() {
        // MySQL connection string
        String url = "jdbc:mysql://localhost:3306/BankApp";
        String user = "root";
        String password = "Kir4itsu";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public User login(String username, String password) {
        String sql = "SELECT username, password, role, balance FROM Users WHERE username = ? AND password = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String role = rs.getString("role");
                if (role.equals("Admin")) {
                    return new Admin(username, password);
                } else if (role.equals("BankEmployee")) {
                    return new BankEmployee(username, password);
                } else if (role.equals("Customer")) {
                    double balance = rs.getDouble("balance");
                    return new Customer(username, password, balance);
                }
            } else {
                // Jika pengguna tidak ditemukan, tambahkan sebagai Nasabah baru
                return registerNewCustomer(username, password);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private User registerNewCustomer(String username, String password) {
        String sql = "INSERT INTO Users (username, password, role, balance) VALUES (?, ?, 'Customer', 0.0)";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                return new Customer(username, password, 0.0);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
