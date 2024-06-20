import javax.swing.*;
import java.awt.*;

public class ComboBox extends JFrame {

    private JLabel txtkelas;
    private JComboBox<String> chKelas;

    public ComboBox() {
        Container a = getContentPane();
        String[] classes = {"---","514101", "514102", "514103", "514104"};
        chKelas = new JComboBox<>(classes);
        txtkelas = new JLabel("Class");

        a.setLayout(new FlowLayout());
        a.add(txtkelas);
        a.add(chKelas);
        a.add(new JScrollPane(chKelas));

        setSize(300, 190);
        setVisible(true);
    }

    public static void main(String[] args) {
        ComboBox display = new ComboBox();
    }
}
