import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CFDialog extends JFrame {
    JLabel label;

    CFDialog(String title) {
        super(title);
        label = new JLabel("Close the frame.");
        add(label, BorderLayout.CENTER);

        // Add a WindowListener using an anonymous inner class to handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Show a confirmation dialog
                int response = JOptionPane.showConfirmDialog(
                    CFDialog.this,
                    "Apa anda yakin ingin keluar dari tab ini?",
                    "Konfirmasi Keluar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );

                // Check the user's response
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
    }

    void launchFrame() {
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        CFDialog cf = new CFDialog("Close Window Example");
        cf.launchFrame();
    }
}
