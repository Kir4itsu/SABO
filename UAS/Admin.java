import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password, "Admin");
    }

    public void manageSystem() {
        System.out.println("Mengelola sistem...");
    
        // Create an instance of ChangeInfoGUI to modify information
        ChangeInfoGUI changeInfoGUI = new ChangeInfoGUI();
    
        // Add ActionListener to the save button in the GUI
        changeInfoGUI.addSaveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = changeInfoGUI.getUsername();
                String newPassword = changeInfoGUI.getPassword();
                String newRole = changeInfoGUI.getRole();
                int userIdToUpdate = changeInfoGUI.getUserId(); // Assume getUserId() gets the selected user ID
    
                // Update database with new information
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApp", "root", "Kir4itsu");
                    String sql = "UPDATE users SET username=?, password=?, role=? WHERE id=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, newUsername);
                    stmt.setString(2, newPassword);
                    stmt.setString(3, newRole);
                    stmt.setInt(4, userIdToUpdate); // Use the selected user ID here
    
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        setUsername(newUsername);
                        setPassword(newPassword);
                        setRole(newRole);
                        System.out.println("Informasi berhasil diubah.");
                    } else {
                        System.out.println("Gagal mengubah informasi.");
                    }
    
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    

    // Getter for ID - assuming it's defined in User or Admin
    @Override
    public int getId() {
        return super.getId(); // Assuming getId() is correctly implemented in User or Admin
    }

    // Setter methods as needed
    public void setUsername(String newUsername) {
        this.username = newUsername;
        System.out.println("Username berhasil diubah menjadi: " + newUsername);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password berhasil diubah.");
    }

    public void setRole(String newRole) {
        // Validate role if necessary
        if (newRole.equals("Admin") || newRole.equals("BankEmployee") || newRole.equals("Customer")) {
            this.role = newRole;
            System.out.println("Role berhasil diubah menjadi: " + newRole);
        } else {
            System.out.println("Role tidak valid.");
        }
    }
    
}
