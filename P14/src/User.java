package P14.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String username;
    private String password;
    private String nama;
    private String passwordmd5;

    private Connection con;
    private Statement st;
    private int hasil;
    private String sql;
    private ResultSet rs;
    private String error;

    private Vector daftarUser;
    private Vector baris;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPasswordMD5() {
        return passwordmd5;
    }

    public String getSql() {
        return sql;
    }

    public String getError() {
        return error;
    }

    public String getMD5(String passwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(passwd.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void kosongkan() {
        username = "";
        password = "";
        nama = "";
    }

    private Vector baca(String where, String order) {
        error = null;
        if (daftarUser == null) {
            daftarUser = new Vector();
        } else {
            daftarUser.clear();
        }
        try {
            con = Mysql.getConnection();
            st = con.createStatement();
            if (where.isEmpty()) {
                sql = "SELECT username, nama FROM user ORDER BY ".concat(order);
            } else {
                sql = "SELECT username, nama FROM user WHERE ".concat(where).concat(" ORDER BY ").concat(order);
            }
            rs = st.executeQuery(sql);
            while (rs.next()) {
                baris = new Vector();
                baris.addElement(rs.getString("username"));
                baris.addElement(rs.getString("nama"));
                daftarUser.addElement(baris);
            }
            st.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            error = "gagal akses tabel user";
        }
        return daftarUser;
    }

    public Vector getSemua(String orderField) {
        return baca("", orderField);
    }

    public Vector getSemua(String where, String orderField) {
        return baca(where, orderField);
    }

    public boolean cari(String uname) {
        boolean ketemu = false;
        try {
            con = Mysql.getConnection();
            st = con.createStatement();
            sql = "SELECT * FROM user WHERE username = '" + uname + "'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                this.username = rs.getString("username");
                this.passwordmd5 = rs.getString("password");
                this.nama = rs.getString("nama");
                ketemu = true;
            } else {
                this.kosongkan();
                ketemu = false;
            }
            st.close();
            con.close();
        } catch (Exception e) {}
        return ketemu;
    }

    private int ganti(String sqlGanti) {
        error = null;
        try {
            con = Mysql.getConnection();
            st = con.createStatement();
            hasil = st.executeUpdate(sqlGanti);
            st.close();
            con.close();
        } catch (Exception e) {
            error = "gagal akses tabel user";
        }
        return hasil;
    }

    public int tambah() {
        passwordmd5 = getMD5(password);
        sql = "INSERT INTO user " +
              "SET username = '" + username +
              "', password = '" + passwordmd5 +
              "', nama = '" + nama + "'";
        return ganti(sql);
    }

    public int hapus() {
        sql = "DELETE FROM user WHERE username = '" + username + "'";
        return ganti(sql);
    }

    public int ubah() {
        passwordmd5 = getMD5(password);
        sql = "UPDATE user " +
              "SET password = '" + passwordmd5 +
              "', nama = '" + nama +
              "' WHERE username = '" + username + "'";
        return ganti(sql);
    }
}
