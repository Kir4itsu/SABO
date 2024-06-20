import javax.swing.*;
import java.awt.*;

public class BorderLayoutManager extends JFrame {

    private JButton[] buttons; // Initiate components.
    private String[] names = {"North", "South", "East", "West", "Center"};
    private BorderLayout layout;

    public BorderLayoutManager() {
        super("Example of BorderLayout"); // Set frame title.

        Container container = getContentPane(); // Create container.
        layout = new BorderLayout(); // Using BorderLayout.

        container.setLayout(layout);

        buttons = new JButton[names.length];

        for (int i = 0; i < names.length; i++) {
            buttons[i] = new JButton(names[i]);
        }

        container.add(buttons[0], BorderLayout.NORTH);
        container.add(buttons[1], BorderLayout.SOUTH);
        container.add(buttons[2], BorderLayout.EAST);
        container.add(buttons[3], BorderLayout.WEST);
        container.add(buttons[4], BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BorderLayoutManager layout = new BorderLayoutManager();
    }
}
