import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class StokBarangApp extends JFrame {
    private JTable jbarang;
    private JTextField tbarang, tnama, tstok, tharga, tcari;
    private JButton bsimpan, bubah, bhapus, bcari, bclear;
    private DefaultTableModel model;

    public StokBarangApp() {
        initComponents();
        model = new DefaultTableModel();
        jbarang.setModel(model);
        model.addColumn("id_Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Stok_Barang");
        model.addColumn("Harga/pcs");
        ambil_data();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Aplikasi Stok Barang");
        setSize(600, 400);
        setLayout(null);

        JLabel lid = new JLabel("ID Barang:");
        lid.setBounds(20, 20, 80, 25);
        add(lid);

        tbarang = new JTextField();
        tbarang.setBounds(100, 20, 165, 25);
        add(tbarang);

        JLabel lnama = new JLabel("Nama Barang:");
        lnama.setBounds(20, 50, 80, 25);
        add(lnama);

        tnama = new JTextField();
        tnama.setBounds(100, 50, 165, 25);
        add(tnama);

        JLabel lstok = new JLabel("Stok:");
        lstok.setBounds(20, 80, 80, 25);
        add(lstok);

        tstok = new JTextField();
        tstok.setBounds(100, 80, 165, 25);
        add(tstok);

        JLabel lharga = new JLabel("Harga:");
        lharga.setBounds(20, 110, 80, 25);
        add(lharga);

        tharga = new JTextField();
        tharga.setBounds(100, 110, 165, 25);
        add(tharga);

        bsimpan = new JButton("Simpan");
        bsimpan.setBounds(20, 140, 80, 25);
        add(bsimpan);

        bubah = new JButton("Ubah");
        bubah.setBounds(110, 140, 80, 25);
        add(bubah);

        bhapus = new JButton("Hapus");
        bhapus.setBounds(200, 140, 80, 25);
        add(bhapus);

        bclear = new JButton("Clear");
        bclear.setBounds(290, 140, 80, 25);
        add(bclear);

        JLabel lcari = new JLabel("Cari:");
        lcari.setBounds(20, 170, 80, 25);
        add(lcari);

        tcari = new JTextField();
        tcari.setBounds(100, 170, 165, 25);
        add(tcari);

        bcari = new JButton("Cari");
        bcari.setBounds(270, 170, 80, 25);
        add(bcari);

        jbarang = new JTable();
        JScrollPane scrollPane = new JScrollPane(jbarang);
        scrollPane.setBounds(20, 200, 550, 150);
        add(scrollPane);

        bsimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bsimpanActionPerformed(e);
            }
        });

        bubah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bubahActionPerformed(e);
            }
        });

        bhapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bhapusActionPerformed(e);
            }
        });

        bcari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bcariActionPerformed(e);
            }
        });

        bclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bclearActionPerformed(e);
            }
        });

        jbarang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jbarangMouseClicked(evt);
            }
        });
    }

    private Connection getKoneksi() {
        Connection koneksi = null;
        String url = "jdbc:mysql://localhost/stok_barang";
        String user = "root";
        String password = "Kir4itsu";
        try {
            koneksi = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return koneksi;
    }

    private void ambil_data() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_stok";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[4];
                o[0] = r.getString("id_barang");
                o[1] = r.getString("Nama_barang");
                o[2] = r.getString("stok_barang");
                o[3] = r.getString("Harga");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan");
        }
    }

    private void bsimpanActionPerformed(ActionEvent evt) {
        String id_barang = tbarang.getText();
        String Nama_barang = tnama.getText();
        String stok_barang = tstok.getText();
        String Harga = tharga.getText();
        
        try {
            Connection c = getKoneksi();
            String sql = "INSERT INTO tbl_stok VALUES (?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id_barang);
            p.setString(2, Nama_barang);
            p.setString(3, stok_barang);
            p.setString(4, Harga);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            ambil_data();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan");
        }
        kosongkanForm();
    }

    private void bubahActionPerformed(ActionEvent evt) {
        String id_barang = tbarang.getText();
        String Nama_barang = tnama.getText();
        String stok_barang = tstok.getText();
        String Harga = tharga.getText();
        
        try {
            Connection c = getKoneksi();
            String sql = "UPDATE tbl_stok SET Nama_barang = ?, stok_barang = ?, Harga = ? WHERE id_barang = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, Nama_barang);
            p.setString(2, stok_barang);
            p.setString(3, Harga);
            p.setString(4, id_barang);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            ambil_data();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan");
        }
        kosongkanForm();
    }

    private void bhapusActionPerformed(ActionEvent evt) {
        int baris = jbarang.getSelectedRow();
        if (baris != -1) {
            String id_barang = jbarang.getValueAt(baris, 0).toString();
            try {
                Connection c = getKoneksi();
                String sql = "DELETE FROM tbl_stok WHERE id_barang = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id_barang);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                ambil_data();
            } catch (SQLException e) {
                System.out.println("Terjadi kesalahan");
            }
            kosongkanForm();
        }
    }

    private void bcariActionPerformed(ActionEvent evt) {
        String cari = tcari.getText();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_stok WHERE id_barang LIKE '%" + cari + "%' OR Nama_barang LIKE '%" + cari + "%'";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[4];
                o[0] = r.getString("id_barang");
                o[1] = r.getString("Nama_barang");
                o[2] = r.getString("stok_barang");
                o[3] = r.getString("Harga");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan");
        }
    }

    private void jbarangMouseClicked(MouseEvent evt) {
        int baris = jbarang.getSelectedRow();
        if (baris != -1) {
            tbarang.setText(jbarang.getValueAt(baris, 0).toString());
            tnama.setText(jbarang.getValueAt(baris, 1).toString());
            tstok.setText(jbarang.getValueAt(baris, 2).toString());
            tharga.setText(jbarang.getValueAt(baris, 3).toString());
        }
    }

    private void bclearActionPerformed(ActionEvent evt) {
        kosongkanForm();
    }

    private void kosongkanForm() {
        tbarang.setText("");
        tnama.setText("");
        tstok.setText("");
        tharga.setText("");
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StokBarangApp().setVisible(true);
            }
        });
    }
}