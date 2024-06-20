package P14;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;
import java.util.Vector;

public class FormLogin extends JFrame {

    // MySQL Class
    public static class Mysql {
        public static String url = "jdbc:mysql://localhost/penjualan";
        public static String user = "root";
        public static String password = "root";

        public static Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        }

        public static void setUrl(String aUrl) {
            url = aUrl;
        }
    }

    // User Class
    public static class User {
        private String username;
        private String password;
        private String nama;
        private String passwordmd5;

        private Connection con;
        private Statement st;
        private int hasil;
        private String sql;
        private ResultSet rs;
        private String error;

        private Vector daftarUser;
        private Vector baris;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getPasswordMD5() {
            return passwordmd5;
        }

        public String getSql() {
            return sql;
        }

        public String getError() {
            return error;
        }

        public String getMD5(String passwd) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(passwd.getBytes());
                BigInteger number = new BigInteger(1, messageDigest);
                String hashtext = number.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public void kosongkan() {
            username = "";
            password = "";
            nama = "";
        }

        private Vector baca(String where, String order) {
            error = null;
            if (daftarUser == null) {
                daftarUser = new Vector();
            } else {
                daftarUser.clear();
            }
            try {
                con = Mysql.getConnection();
                st = con.createStatement();
                if (where.isEmpty()) {
                    sql = "SELECT username, nama FROM user ORDER BY ".concat(order);
                } else {
                    sql = "SELECT username, nama FROM user WHERE ".concat(where).concat(" ORDER BY ").concat(order);
                }
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    baris = new Vector();
                    baris.addElement(rs.getString("username"));
                    baris.addElement(rs.getString("nama"));
                    daftarUser.addElement(baris);
                }
                st.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                error = "gagal akses tabel user";
            }
            return daftarUser;
        }

        public Vector getSemua(String orderField) {
            return baca("", orderField);
        }

        public Vector getSemua(String where, String orderField) {
            return baca(where, orderField);
        }

        public boolean cari(String uname) {
            boolean ketemu = false;
            try {
                con = Mysql.getConnection();
                st = con.createStatement();
                sql = "SELECT * FROM user WHERE username = '" + uname + "'";
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    this.username = rs.getString("username");
                    this.passwordmd5 = rs.getString("password");
                    this.nama = rs.getString("nama");
                    ketemu = true;
                } else {
                    this.kosongkan();
                    ketemu = false;
                }
                st.close();
                con.close();
            } catch (Exception e) {}
            return ketemu;
        }

        private int ganti(String sqlGanti) {
            error = null;
            try {
                con = Mysql.getConnection();
                st = con.createStatement();
                hasil = st.executeUpdate(sqlGanti);
                st.close();
                con.close();
            } catch (Exception e) {
                error = "gagal akses tabel user";
            }
            return hasil;
        }

        public int tambah() {
            passwordmd5 = getMD5(password);
            sql = "INSERT INTO user " +
                  "SET username = '" + username +
                  "', password = '" + passwordmd5 +
                  "', nama = '" + nama + "'";
            return ganti(sql);
        }

        public int hapus() {
            sql = "DELETE FROM user WHERE username = '" + username + "'";
            return ganti(sql);
        }

        public int ubah() {
            passwordmd5 = getMD5(password);
            sql = "UPDATE user " +
                  "SET password = '" + passwordmd5 +
                  "', nama = '" + nama +
                  "' WHERE username = '" + username + "'";
            return ganti(sql);
        }
    }

    // DialogLogin Class
    public static class DialogLogin extends JDialog {

        private static User user;
        private boolean otentik;

        private JTextField tfUserName;
        private JPasswordField pfPassword;
        private JLabel labelPesan;

        public DialogLogin(JFrame parent, boolean modal, User user) {
            super(parent, modal);
            this.user = user;
            otentik = false;
            initComponents();
            getContentPane().setBackground(Color.LIGHT_GRAY);
            setPosisiTengah();
            setResizable(false);
        }

        public void setPosisiTengah() {
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

        private void initComponents() {
            setTitle("Login");
            setLayout(new GridLayout(4, 2));

            JLabel labelUsername = new JLabel("Username:");
            tfUserName = new JTextField();
            JLabel labelPassword = new JLabel("Password:");
            pfPassword = new JPasswordField();
            labelPesan = new JLabel();
            JButton btnLogin = new JButton("Login");

            btnLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnLoginActionPerformed(evt);
                }
            });

            add(labelUsername);
            add(tfUserName);
            add(labelPassword);
            add(pfPassword);
            add(new JLabel());
            add(labelPesan);
            add(new JLabel());
            add(btnLogin);

            pack();
        }

        private void btnLoginActionPerformed(ActionEvent evt) {
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

        public boolean isOtentik() {
            return otentik;
        }
    }

    private User user;
    private DialogLogin dialogLogin;
    private JMenu mnMaster;
    private JMenuItem mnLogin;
    private JMenuItem mnLogout;
    private JMenuItem mnExit;

    public FormLogin() {
        user = new User();
        setTitle("Form Login");
        setSize(400, 300);
        setPosisiTengah();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setmenu(false);
        setResizable(false);
        initMenu();
    }

    public void setPosisiTengah() {
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

    public void setmenu(boolean bool) {
        mnMaster.setEnabled(bool);
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        mnLogin = new JMenuItem("Login");
        mnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnLoginActionPerformed(evt);
            }
        });
        menuFile.add(mnLogin);

        mnLogout = new JMenuItem("Logout");
        mnLogout.setEnabled(false);
        mnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnLogoutActionPerformed(evt);
            }
        });
        menuFile.add(mnLogout);

        mnExit = new JMenuItem("Exit");
        mnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnExitActionPerformed(evt);
            }
        });
        menuFile.add(mnExit);

        mnMaster = new JMenu("Master");
        mnMaster.setEnabled(false);
        menuBar.add(mnMaster);
    }

    private void mnLoginActionPerformed(ActionEvent evt) {
        dialogLogin = new DialogLogin(this, true, user);
        dialogLogin.setVisible(true);
        if (dialogLogin.isOtentik()) {
            mnLogin.setEnabled(false);
            mnLogout.setEnabled(true);
            setmenu(true);
        }
    }

    private void mnLogoutActionPerformed(ActionEvent evt) {
        mnLogin.setEnabled(true);
        mnLogout.setEnabled(false);
        setmenu(false);
    }

    private void mnExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }
}
