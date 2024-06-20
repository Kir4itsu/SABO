import javax.swing.*;
import java.awt.*;

public class Text extends JFrame {

    private JTextField usl;
    private JPasswordField passi;
    private JTextArea usAl;

    public Text() {
        Container y = getContentPane(); // Create new container
        setLayout(new FlowLayout()); // Set flow layout

        usl = new JTextField(20); // Create textfield object
        y.add(usl); // Add textfield to container

        passi = new JPasswordField(20); // Create password field object
        y.add(passi); // Add password field to container

        usAl = new JTextArea(6, 30); // Create textarea object
        y.add(usAl); // Add textarea to container

        setSize(320, 150); // Set container size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits on close
        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new Text(); // Create object from class Text
    }
}
