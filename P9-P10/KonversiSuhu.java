import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KonversiSuhu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konversi Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Konversi Suhu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(10, 10, 270, 30);
        frame.add(titleLabel);

        JLabel label1 = new JLabel("Celcius");
        label1.setBounds(10, 50, 80, 25);
        frame.add(label1);

        JTextField celciusField = new JTextField(20);
        celciusField.setBounds(100, 50, 165, 25);
        frame.add(celciusField);

        JLabel label2 = new JLabel("Ubah Ke");
        label2.setBounds(10, 80, 80, 25);
        frame.add(label2);

        String[] choices = {"Fahrenheit"};
        JComboBox<String> comboBox = new JComboBox<>(choices);
        comboBox.setBounds(100, 80, 165, 25);
        frame.add(comboBox);

        JButton convertButton = new JButton("Konversi");
        convertButton.setBounds(10, 120, 255, 25);
        frame.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(celciusField.getText());
                    if (comboBox.getSelectedItem().equals("Fahrenheit")) {
                        double fahrenheit = (celcius * 9/5) + 32;
                        showResult(fahrenheit, "F");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void showResult(double value, String unit) {
        JFrame resultFrame = new JFrame();
        resultFrame.setSize(200, 200);
        resultFrame.setLayout(new GridBagLayout());
        
        JLabel resultLabel = new JLabel(String.format("%.1f %s", value, unit));
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        resultFrame.add(resultLabel);

        resultFrame.setVisible(true);
    }
}
