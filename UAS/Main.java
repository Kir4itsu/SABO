import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static LoginSystem loginSystem;

    public static void main(String[] args) {
        loginSystem = new LoginSystem();
        JFrame frame = new JFrame("Aplikasi Perbankan");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                User user = loginSystem.login(username, password);

                if (user != null) {
                    JOptionPane.showMessageDialog(panel, "Login berhasil sebagai " + user.getRole());
                    openUserInterface(user);
                } else {
                    JOptionPane.showMessageDialog(panel, "Login gagal");
                }
            }
        });
    }

    private static void openUserInterface(User user) {
        JFrame frame = new JFrame(user.getRole() + " Interface");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeUserComponents(panel, user);

        frame.setVisible(true);
    }

    private static void placeUserComponents(JPanel panel, User user) {
        panel.setLayout(null);

        if (user instanceof Admin) {
            JButton manageButton = new JButton("Manage System");
            manageButton.setBounds(10, 20, 160, 25);
            panel.add(manageButton);

            manageButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ((Admin) user).manageSystem();
                }
            });
        } else if (user instanceof BankEmployee) {
            JButton handleButton = new JButton("Handle Transactions");
            handleButton.setBounds(10, 20, 160, 25);
            panel.add(handleButton);

            handleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ((BankEmployee) user).handleTransactions();
                }
            });
        } else if (user instanceof Customer) {
            JLabel balanceLabel = new JLabel("Balance: " + ((Customer) user).getBalance());
            balanceLabel.setBounds(10, 20, 160, 25);
            panel.add(balanceLabel);

            JButton depositButton = new JButton("Deposit");
            depositButton.setBounds(10, 50, 160, 25);
            panel.add(depositButton);

            JButton withdrawButton = new JButton("Withdraw");
            withdrawButton.setBounds(10, 80, 160, 25);
            panel.add(withdrawButton);

            depositButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                    double amount = Double.parseDouble(amountStr);
                    ((Customer) user).deposit(amount);
                    balanceLabel.setText("Balance: " + ((Customer) user).getBalance());
                }
            });

            withdrawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                    double amount = Double.parseDouble(amountStr);
                    ((Customer) user).withdraw(amount);
                    balanceLabel.setText("Balance: " + ((Customer) user).getBalance());
                }
            });
        }
    }
}
