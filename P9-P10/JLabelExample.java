import java.awt.*;  // Correct the import statement
import javax.swing.*;  // Correct the import statement

public class JLabelExample extends JFrame {

    JLabel label1; // Initiate variable
    FlowLayout f1;

    public JLabelExample() {
        Container x = getContentPane(); // Get the content pane
        label1 = new JLabel("Graphical User Interface"); // Create and set label text
        x.add(label1); // Add label into current layout
        setLayout(new FlowLayout()); // Set layout
        setSize(300, 200); // Set layout size (increased for better visibility)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits on close
        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new JLabelExample(); // Create new object
    }
}
