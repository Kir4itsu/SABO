import javax.swing.*;
import java.awt.*;

public class Button extends JFrame {

    private JButton button1;
    private JButton button2;

    public Button() {
        Container z = getContentPane(); // Create new container called "z"
        
        button1 = new JButton("Order"); // Create new "order" button
        z.add(button1); // Add button to container

        button2 = new JButton("Back"); // Create new "back" button
        z.add(button2); // Add button to container

        setLayout(new FlowLayout()); // Set layout using Flow Layout
        setSize(300, 100); // Set size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits on close
        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        Button z = new Button(); // Create new object called "z"
    }
}
