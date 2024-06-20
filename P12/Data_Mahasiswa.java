import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Data_Mahasiswa extends javax.swing.JFrame {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/K4";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Kir4itsu";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public Data_Mahasiswa() {
        initComponents();
        connect();
        load_table();
    }

    private void connect() {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void load_table() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Fakultas");
        model.addColumn("Jurusan");
        model.addColumn("Peminatan");
        model.addColumn("Alamat");
        model.addColumn("Phone");

        try {
            rs = stmt.executeQuery("SELECT * FROM table_mhs");
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("Nama"),
                    rs.getString("NIM"),
                    rs.getString("Fakultas"),
                    rs.getString("Jurusan"),
                    rs.getString("Peminatan"),
                    rs.getString("Alamat"),
                    rs.getString("Phone")
                });
            }
            jTable1.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void clear() {
        jTextFieldNama.setText("");
        jTextFieldNIM.setText("");
        jComboBoxFakultas.setSelectedIndex(0);
        jTextFieldJurusan.setSelectedIndex(0);
        jComboBoxPeminatan.setSelectedIndex(0);
        jTextFieldAlamat.setText("");
        jTextFieldPhone.setText("");
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldNIM = new javax.swing.JTextField();
        jTextFieldJurusan = new javax.swing.JComboBox<>();
        jTextFieldAlamat = new javax.swing.JTextField();
        jTextFieldPhone = new javax.swing.JTextField();
        jButtonTambah = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelFakultas = new javax.swing.JLabel();
        jLabelPeminatan = new javax.swing.JLabel();
        jComboBoxFakultas = new javax.swing.JComboBox<>();
        jComboBoxPeminatan = new javax.swing.JComboBox<>();

        jLabelFakultas.setText("Fakultas");
        jLabelPeminatan.setText("Peminatan");

        jComboBoxFakultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Fakultas Teknik", "Fakultas Ekonomi", "Fakultas Hukum" }));
        jComboBoxPeminatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Peminatan 1", "Peminatan 2", "Peminatan 3" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama");
        jLabel2.setText("NIM");
        jLabel3.setText("Jurusan");
        jLabel4.setText("Alamat");
        jLabel5.setText("No Handphone");

        jTextFieldJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Teknik Informatika", "Teknik Sipil", "Teknik Elektro", "Teknik Mesin" }));

        jButtonTambah.setText("Tambah");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabelFakultas)
                        .addComponent(jLabel3)
                        .addComponent(jLabelPeminatan)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldNama)
                        .addComponent(jTextFieldNIM)
                        .addComponent(jComboBoxFakultas)
                        .addComponent(jTextFieldJurusan)
                        .addComponent(jComboBoxPeminatan)
                        .addComponent(jTextFieldAlamat)
                        .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(30, Short.MAX_VALUE))
                .addComponent(jScrollPane1)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonTambah))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEdit))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelFakultas)
                        .addComponent(jComboBoxFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextFieldJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonHapus))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPeminatan)
                        .addComponent(jComboBoxPeminatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonClear))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBoxFakultas.getSelectedItem().equals("--") || jTextFieldJurusan.getSelectedItem().equals("--") || jComboBoxPeminatan.getSelectedItem().equals("--")) {
            JOptionPane.showMessageDialog(this, "Pilih Fakultas, Jurusan, dan Peminatan terlebih dahulu!");
        } else {
            try {
                String sql = "INSERT INTO table_mhs (Nama, NIM, Fakultas, Jurusan, Peminatan, Alamat, Phone) VALUES ('"
                        + jTextFieldNama.getText() + "','"
                        + jTextFieldNIM.getText() + "','"
                        + jComboBoxFakultas.getSelectedItem() + "','"
                        + jTextFieldJurusan.getSelectedItem() + "','"
                        + jComboBoxPeminatan.getSelectedItem() + "','"
                        + jTextFieldAlamat.getText() + "','"
                        + jTextFieldPhone.getText() + "')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                load_table();
                clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        jTextFieldNama.setText(jTable1.getModel().getValueAt(row, 1).toString());
        jTextFieldNIM.setText(jTable1.getModel().getValueAt(row, 2).toString());
        jComboBoxFakultas.setSelectedItem(jTable1.getModel().getValueAt(row, 3).toString());
        jTextFieldJurusan.setSelectedItem(jTable1.getModel().getValueAt(row, 4).toString());
        jComboBoxPeminatan.setSelectedItem(jTable1.getModel().getValueAt(row, 5).toString());
        jTextFieldAlamat.setText(jTable1.getModel().getValueAt(row, 6).toString());
        jTextFieldPhone.setText(jTable1.getModel().getValueAt(row, 7).toString());
    }

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String sql = "UPDATE table_mhs SET Nama='"
                    + jTextFieldNama.getText() + "', NIM='"
                    + jTextFieldNIM.getText() + "', Fakultas='"
                    + jComboBoxFakultas.getSelectedItem() + "', Jurusan='"
                    + jTextFieldJurusan.getSelectedItem() + "', Peminatan='"
                    + jComboBoxPeminatan.getSelectedItem() + "', Alamat='"
                    + jTextFieldAlamat.getText() + "', Phone='"
                    + jTextFieldPhone.getText() + "' WHERE NIM='"
                    + jTextFieldNIM.getText() + "'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
            load_table();
            clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nim = jTextFieldNIM.getText();
            if (nim.isEmpty()) {
                JOptionPane.showMessageDialog(this, "NIM tidak boleh kosong");
                return;
            }
            String sql = "DELETE FROM table_mhs WHERE NIM='" + nim + "'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            load_table();
            clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        clear();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Mahasiswa().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonTambah;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldNIM;
    private javax.swing.JComboBox<String> jTextFieldJurusan;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JLabel jLabelFakultas;
    private javax.swing.JLabel jLabelPeminatan;
    private javax.swing.JComboBox<String> jComboBoxFakultas;
    private javax.swing.JComboBox<String> jComboBoxPeminatan;
}
