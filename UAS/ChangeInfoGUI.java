import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeInfoGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JTextField userIdField; // Field for user ID

    private ActionListener saveListener; // Declaration of saveListener

    public ChangeInfoGUI() {
        initialize();
    }
    private void initialize() {
        // Initialize JFrame and components
        setTitle("Change User Information");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel lblUsername = new JLabel("Username:");
        usernameField = new JTextField();
        panel.add(lblUsername);
        panel.add(usernameField);

        JLabel lblPassword = new JLabel("Password:");
        passwordField = new JPasswordField();
        panel.add(lblPassword);
        panel.add(passwordField);

        JLabel lblRole = new JLabel("Role:");
        String[] roles = {"Admin", "BankEmployee", "Customer"};
        roleComboBox = new JComboBox<>(roles);
        panel.add(lblRole);
        panel.add(roleComboBox);

        JLabel lblUserId = new JLabel("User ID:"); // Label for user ID
        userIdField = new JTextField(); // Text field for user ID
        panel.add(lblUserId);
        panel.add(userIdField);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from fields
                String newUsername = getUsername();
                String newPassword = getPassword();
                String newRole = getRole();
                int userId = getUserId();

                // Perform save action (e.g., update database)
                if (saveListener != null) {
                    saveListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Save"));
                }
            }
        });
        panel.add(btnSave);

        add(panel);
        setVisible(true);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getRole() {
        return roleComboBox.getSelectedItem().toString();
    }

    public int getUserId() {
        try {
            return Integer.parseInt(userIdField.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1; // Return -1 or handle error accordingly
        }
    }

    public void addSaveListener(ActionListener listener) {
        this.saveListener = listener;
    }
}
