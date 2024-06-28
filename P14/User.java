package P14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;

/**
 * Enkapsulasi tabel user
 */
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

    // Getter dan Setter
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

    /**
     * Mengkonversi input ke MD5
     * @param passwd
     * @return hasil MD5
     */
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

    /**
     * Mengosongkan properti username dan nama
     */
    public void kosongkan() {
        username = "";
        password = "";
        nama = "";
    }

    /**
     * Membaca data dari tabel user
     * @param where kondisi where
     * @param order kondisi order
     * @return daftarUser
     */
    private Vector baca(String where, String order) {
        error = null;
        if (daftarUser == null) {
            daftarUser = new Vector();
        } else {
            daftarUser.removeAllElements();
        }
        try {
            Koneksi k = new Koneksi();
            k.openConn();
            con = k.getConn();
            st = con.createStatement();
            sql = "SELECT username, nama, passwordmd5 FROM user";
            if (where != null) {
                sql += " WHERE " + where;
            }
            if (order != null) {
                sql += " ORDER BY " + order;
            }
            rs = st.executeQuery(sql);
            while (rs.next()) {
                baris = new Vector();
                baris.addElement(rs.getString("username"));
                baris.addElement(rs.getString("nama"));
                baris.addElement(rs.getString("passwordmd5"));
                daftarUser.addElement(baris);
            }
            k.closeConn();
        } catch (Exception e) {
            error = e.toString();
        }
        return daftarUser;
    }

    /**
     * Mencari user berdasarkan username
     * @param uName
     * @return true jika ditemukan, false jika tidak
     */
    public boolean cari(String uName) {
        boolean ketemu = false;
        baca("username = '" + uName + "'", null);
        if (!daftarUser.isEmpty()) {
            baris = (Vector) daftarUser.firstElement();
            username = (String) baris.firstElement();
            passwordmd5 = (String) baris.elementAt(2);
            ketemu = true;
        }
        return ketemu;
    }
}
