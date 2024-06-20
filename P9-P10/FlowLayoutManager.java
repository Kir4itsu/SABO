import javax.swing.*;
import java.awt.*;

public class FlowLayoutManager extends JFrame {

    public FlowLayoutManager() {
        super("Contoh Flow Layout");

        FlowLayout layout = new FlowLayout(); // Create new flow layout.
        layout.setAlignment(FlowLayout.RIGHT); // Set alignment.
        layout.setVgap(15); // Set vertical gap between components.
        layout.setHgap(25); // Set horizontal gap between components.

        Container container = getContentPane();
        container.setLayout(layout); // Set container's layout.

        JButton button1 = new JButton("Tombol 1"); // Create buttons.
        JButton button2 = new JButton("Tombol 2");
        JButton button3 = new JButton("Tombol 3");
        JButton button4 = new JButton("Tombol 4");
        JButton button5 = new JButton("Tombol 5");
        JButton button6 = new JButton("Tombol 6");

        container.add(button1); // Add buttons into container.
        container.add(button2);
        container.add(button3);
        container.add(button4);
        container.add(button5);
        container.add(button6);

        setSize(300, 200); // Set frame size.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation.
        setVisible(true); // Make frame visible.
    }

    public static void main(String[] args) {
        FlowLayoutManager layout = new FlowLayoutManager();
    }
}
