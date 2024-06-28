package P14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame {
    private JButton btnLogin;
    private JButton btnInput;
    private JButton btnOutput;
    private JButton btnKeluar;
    private JLabel labelJudul;
    private User user;

    public Main() {
        user = new User();
        initComponents();
    }

    /**
     * Inisialisasi komponen GUI
     */
    private void initComponents() {
        setTitle("Aplikasi Penjualan");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setPosisiTengah();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        labelJudul = new JLabel("Aplikasi Penjualan");
        labelJudul.setBounds(130, 10, 150, 30);
        labelJudul.setForeground(Color.BLUE);
        panel.add(labelJudul);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 70, 100, 30);
        btnLogin.addActionListener(evt -> {
            DialogLogin dialogLogin = new DialogLogin(Main.this, true, user);
            dialogLogin.setVisible(true);
            if (dialogLogin.getOtentikasi()) {
                btnInput.setEnabled(true);
                btnOutput.setEnabled(true);
                btnLogin.setEnabled(false);
            }
        });
        panel.add(btnLogin);

        btnInput = new JButton("Input");
        btnInput.setBounds(150, 70, 100, 30);
        btnInput.setEnabled(false);
        panel.add(btnInput);

        btnOutput = new JButton("Output");
        btnOutput.setBounds(250, 70, 100, 30);
        btnOutput.setEnabled(false);
        panel.add(btnOutput);

        btnKeluar = new JButton("Keluar");
        btnKeluar.setBounds(150, 150, 100, 30);
        btnKeluar.addActionListener(evt -> System.exit(0));
        panel.add(btnKeluar);

        add(panel);
    }

    /**
     * Mengatur posisi frame ke tengah layar
     */
    private void setPosisiTengah() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        int width = getWidth();
        int height = getHeight();
        int w2 = (screenWidth - width) / 2;
        int h2 = (screenHeight - height) / 2;
        setLocation(w2, h2);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}

class DialogLogin extends JDialog {
    private static User user;
    private boolean otentik;
    private JTextField tfUserName;
    private JPasswordField pfPassword;
    private JLabel labelPesan;

    public DialogLogin(java.awt.Frame parent, boolean modal, User user) {
        super(parent, modal);
        initComponents();
        this.user = user;
        otentik = false;
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setPosisiTengah();
        setResizable(false);
    }

    /**
     * Mengatur posisi frame ke tengah layar
     */
    private void setPosisiTengah() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        int width = getWidth();
        int height = getHeight();
        int w2 = (screenWidth - width) / 2;
        int h2 = (screenHeight - height) / 2;
        setLocation(w2, h2);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        cekOtentikasi();
        if (otentik) {
            labelPesan.setText(null);
            dispose();
        } else {
            labelPesan.setText("Ulang lagi username/password masih salah");
            tfUserName.requestFocus();
        }
    }

    public void cekOtentikasi() {
        boolean pwdbenar;
        boolean ketemu;
        String password;
        String pwdmd5;
        ketemu = user.cari(tfUserName.getText());
        password = new String(pfPassword.getPassword());
        pwdmd5 = user.getMD5(password);
        if (ketemu) {
            pwdbenar = user.getPasswordMD5().equals(pwdmd5);
            if (pwdbenar) {
                otentik = true;
            } else {
                otentik = false;
            }
        } else {
            otentik = false;
        }
    }

    public boolean getOtentikasi() {
        return otentik;
    }

    private void initComponents() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel lblUserName = new JLabel("Username");
        lblUserName.setBounds(50, 30, 100, 30);
        lblUserName.setForeground(Color.BLUE);
        add(lblUserName);

        tfUserName = new JTextField();
        tfUserName.setBounds(150, 30, 100, 30);
        add(tfUserName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 70, 100, 30);
        lblPassword.setForeground(Color.BLUE);
        add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(150, 70, 100, 30);
        add(pfPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 110, 100, 30);
        btnLogin.addActionListener(evt -> btnLoginActionPerformed(evt));
        add(btnLogin);

        labelPesan = new JLabel();
        labelPesan.setBounds(50, 150, 200, 30);
        labelPesan.setForeground(Color.RED);
        add(labelPesan);
    }
}
