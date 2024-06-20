import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class BeratBadan extends javax.swing.JFrame {

    public BeratBadan() {
        initComponents();
        setSize(300, 300); // Mengatur ukuran window menjadi 600x400 piksel
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tinggi Badan");
        jPanel1.add(jLabel1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel1.add(jTextField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Berat Badan");
        jPanel1.add(jLabel2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        jPanel1.add(jTextField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jenis Kelamin");
        jPanel1.add(jLabel3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita" }));
        jPanel1.add(jComboBox1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Berat Badan Ideal :");
        jPanel1.add(jLabel4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        jPanel1.add(jLabel5, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Berat Badan Kamu");
        jPanel1.add(jLabel6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        jPanel1.add(new javax.swing.JLabel(), gbc);

        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int tinggi = Integer.parseInt(jTextField1.getText());
        int berat = Integer.parseInt(jTextField2.getText());
        String jenisKelamin = (String) jComboBox1.getSelectedItem();
        int total;

        if (jenisKelamin.equals("Pria")) {
            total = (int) (tinggi - 100 - ((tinggi - 100) * 0.10));
        } else {
            total = (int) (tinggi - 100 - ((tinggi - 100) * 0.15));
        }

        jLabel4.setText("Berat Badan Ideal : " + total + " Kg");

        int beban;
        if (total == berat) {
            jLabel6.setText("Berat Badan Kamu Sudah Ideal");
        } else if (total < berat) {
            beban = berat - total;
            jLabel6.setText("Berat Badan Kamu Lebih " + beban + " Kg");
        } else {
            beban = total - berat;
            jLabel6.setText("Berat Badan Kamu Kurang " + beban + " Kg");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BeratBadan().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}