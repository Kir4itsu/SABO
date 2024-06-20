import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

public class FormulirPendaftaran {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulir Pendaftaran Mahasiswa Baru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0xFFEFE0)); // Set background color

        // Title label
        JLabel titleLabel = new JLabel("Formulir Pendaftaran Mahasiswa Baru");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(10, 10, 360, 30);
        frame.add(titleLabel);

        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(10, 50, 80, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(150, 50, 200, 25);
        frame.add(nameField);

        JLabel dobLabel = new JLabel("Tanggal Lahir:");
        dobLabel.setBounds(10, 80, 120, 25);
        frame.add(dobLabel);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(150, 80, 200, 25);
        frame.add(dateChooser);

        JLabel majorLabel = new JLabel("Jurusan:");
        majorLabel.setBounds(10, 110, 80, 25);
        frame.add(majorLabel);

        String[] majors = {"---", "Teknik Informatika", "Teknik Elektro", "Teknik Mesin"};
        JComboBox<String> majorComboBox = new JComboBox<>(majors);
        majorComboBox.setBounds(150, 110, 200, 25);
        frame.add(majorComboBox);

        JLabel yearLabel = new JLabel("Tahun Masuk:");
        yearLabel.setBounds(10, 140, 100, 25);
        frame.add(yearLabel);

        JYearChooser yearChooser = new JYearChooser();
        yearChooser.setBounds(150, 140, 200, 25);
        frame.add(yearChooser);

        JButton submitButton = new JButton("Daftar");
        submitButton.setBounds(10, 180, 340, 25);
        submitButton.setBackground(new Color(30, 144, 255)); // Set button background color
        submitButton.setForeground(Color.WHITE); // Set text color
        submitButton.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255))); // Set border color
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dob = dateFormat.format(dateChooser.getDate());
                String major = (String) majorComboBox.getSelectedItem();
                int year = yearChooser.getYear();

                if (name.isEmpty() || dob.isEmpty() || major.equals("---")) {
                    JOptionPane.showMessageDialog(frame, "Harap isi semua bidang dan pilih jurusan yang valid.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    showResult(name, dob, major, String.valueOf(year));
                }
            }
        });

        frame.setVisible(true);
    }

    public static void showResult(String name, String dob, String major, String year) {
        JFrame resultFrame = new JFrame("Hasil Pendaftaran");
        resultFrame.setSize(400, 200);
        resultFrame.setLayout(new GridLayout(5, 1));
        resultFrame.getContentPane().setBackground(new Color(240, 240, 240)); // Set background color

        JLabel resultLabel1 = new JLabel("Nama: " + name);
        JLabel resultLabel2 = new JLabel("Tanggal Lahir: " + dob);
        JLabel resultLabel3 = new JLabel("Jurusan: " + major);
        JLabel resultLabel4 = new JLabel("Tahun Masuk: " + year);

        resultLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel3.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel4.setFont(new Font("Arial", Font.PLAIN, 16));

        resultFrame.add(resultLabel1);
        resultFrame.add(resultLabel2);
        resultFrame.add(resultLabel3);
        resultFrame.add(resultLabel4);

        resultFrame.setVisible(true);
    }
}
