import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckboxDemo extends JFrame {

    private JPanel panel;
    private JLabel label;
    private Checkbox colour, bold, italic;

    public CheckboxDemo() {
        Font font = new Font("Tahoma", Font.PLAIN, 20); // Set font

        label = new JLabel("Enterprise Application Development", JLabel.CENTER); // Create label
        label.setFont(font); // Set font into label
        label.setBackground(Color.WHITE); // Set label background color
        label.setOpaque(true); // Make background color visible

        getContentPane().add(label, BorderLayout.CENTER); // Add label to container

        colour = new Checkbox("Blue"); // Create new checkbox
        colour.setBackground(Color.YELLOW); // Set background color

        bold = new Checkbox("Bold"); // Create new checkbox
        bold.setBackground(Color.YELLOW); // Set background color

        italic = new Checkbox("Italic"); // Create new checkbox
        italic.setBackground(Color.YELLOW); // Set background color

        panel = new JPanel(); // Create new panel
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Set panel's layout
        panel.setBackground(Color.YELLOW); // Set panel background color

        panel.add(colour); // Add components to panel
        panel.add(bold);
        panel.add(italic);

        getContentPane().add(panel, BorderLayout.PAGE_END); // Add panel to container

        ItemEventHandler handler = new ItemEventHandler(); // Add event handler
        colour.addItemListener(handler);
        bold.addItemListener(handler);
        italic.addItemListener(handler);

        setSize(400, 200); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits on close
        setTitle("Checkbox Demo"); // Set frame title
        setVisible(true); // Make the frame visible
    }

    private class ItemEventHandler implements ItemListener {
        private Color colorValue = Color.BLACK; // Initiate value for each component
        private int boldValue = Font.PLAIN;
        private int italicValue = Font.PLAIN;

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == colour) {
                colorValue = colour.getState() ? Color.BLUE : Color.BLACK;
            }

            if (e.getSource() == bold) {
                boldValue = bold.getState() ? Font.BOLD : Font.PLAIN;
            }

            if (e.getSource() == italic) {
                italicValue = italic.getState() ? Font.ITALIC : Font.PLAIN;
            }

            label.setFont(new Font("Tahoma", boldValue | italicValue, 20));
            label.setForeground(colorValue);
        }
    }

    public static void main(String[] args) {
        CheckboxDemo frame = new CheckboxDemo(); // Show by creating the objects.
        frame.setTitle("Checkbox Demo Classes"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
