import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer extends User {
    private double balance;

    public Customer(String username, String password, double balance) {
        super(username, password, "Customer");
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        updateBalanceInDatabase();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            updateBalanceInDatabase();
        } else {
            System.out.println("Saldo tidak mencukupi.");
        }
    }

    private void updateBalanceInDatabase() {
        String sql = "UPDATE Users SET balance = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApp", "root", "Kir4itsu");  // Ganti dengan username dan password MySQL Anda
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, balance);
            pstmt.setString(2, this.getUsername());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
