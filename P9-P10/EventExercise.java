import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventExercise extends JFrame implements ActionListener {

    private JLabel output;

    public EventExercise() {
        setSize(300, 100);
        setVisible(true);

        setLayout(new FlowLayout()); // Menggunakan FlowLayout agar komponen-komponen berada dalam satu baris.

        JButton button = new JButton("Klik Disini");
        button.addActionListener(this); // Menambahkan ActionListener ke tombol.
        add(button); // Menambahkan tombol ke frame.

        output = new JLabel(); // Membuat label untuk output.
        add(output); // Menambahkan label ke frame.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        output.setText("Hello World"); // Mengubah teks pada label output.
    }

    public static void main(String[] args) {
        EventExercise show = new EventExercise();
    }
}
