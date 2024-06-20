import javax.swing.*;
import java.awt.*;

public class RadioButton {

    private JRadioButton Rblaki, Rbperempuan; // Initialize components
    private ButtonGroup grupradio;
    private JFrame bingkai;
    private JLabel Gender;

    public RadioButton() {
        bingkai = new JFrame("Radio Button Example"); // Create frame
        bingkai.setLayout(new GridLayout(3, 1)); // Set frame layout
        
        Gender = new JLabel("Gender", SwingConstants.CENTER); // Create label for gender
        
        Rblaki = new JRadioButton("Pria"); // Create male radio button
        Rbperempuan = new JRadioButton("Wanita"); // Create female radio button
        
        grupradio = new ButtonGroup(); // Create button group
        grupradio.add(Rblaki); // Add male radio button to group
        grupradio.add(Rbperempuan); // Add female radio button to group
        
        JPanel genderPanel = new JPanel(new FlowLayout()); // Create panel for gender
        genderPanel.add(Gender); // Add gender label to panel
        genderPanel.add(Rblaki); // Add male radio button to panel
        genderPanel.add(Rbperempuan); // Add female radio button to panel
        
        bingkai.add(genderPanel); // Add gender panel to frame
        
        bingkai.setSize(300, 150); // Set frame size
        bingkai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        bingkai.setVisible(true); // Set frame visibility
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RadioButton(); // Create instance of RadioButton
            }
        });
    }
}
