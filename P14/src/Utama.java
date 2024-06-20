package P14.src;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Utama extends javax.swing.JFrame {

    private User user;
    private DialogLogin dialogLogin;

    public Utama() {
        initComponents();
        user = new User();
        setPosisiTengah();
        setmenu(false);
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

    public void setmenu(boolean bool) {
        mnMaster.setEnabled(bool);
    }

    private void mnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        dialogLogin = new DialogLogin(this, true, user);
        dialogLogin.setVisible(true);
        if (dialogLogin.isOtentik()) {
            mnLogin.setEnabled(false);
            mnLogout.setEnabled(true);
            setmenu(true);
        }
    }

    private void mnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        mnLogin.setEnabled(true);
        mnLogout.setEnabled(false);
        setmenu(false);
    }

    private void mnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    // Variables declaration - do not modify
    private javax.swing.JMenu mnMaster;
    private javax.swing.JMenuItem mnLogin;
    private javax.swing.JMenuItem mnLogout;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration
}
