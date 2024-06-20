package P14.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class DialogLogin extends javax.swing.JDialog {

    private static User user;
    private boolean otentik;

    public DialogLogin(java.awt.Frame parent, boolean modal, User user) {
        super(parent, modal);
        initComponents();
        this.user = user;
        otentik = false;
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

    public boolean isOtentik() {
        return otentik;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelPesan;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration
}
