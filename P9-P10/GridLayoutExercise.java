import javax.swing.*;
import java.awt.*;

public class GridLayoutExercise extends JFrame {

    private JButton tombol; // Initiate Components.
    private Container container;
    private GridLayout gridlayout;

    public GridLayoutExercise() {
        super("GridLayout Exercise");

        gridlayout = new GridLayout(2,2); // Create new gridlayout.
        container = getContentPane();
        container.setLayout(gridlayout); // Set container's layout.

        container.add(new JButton("FR")); // Add button into components.
        container.add(new JButton("FIK"));
        container.add(new JButton("FIF"));
        container.add(new JButton("FKB"));

        setSize(300, 300); // Set container sizes.
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GridLayoutExercise GL = new GridLayoutExercise();
    }
}
