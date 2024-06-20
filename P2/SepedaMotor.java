// public class SepedaMotor {
//     private String merk;
//     private long harga;

//     public void setMerk(String merkMotor) {
//         merk = merkMotor;
//     }

//     public String getMerk(){
//         return merk;
//     }

//     public long Harga (long hargaMotor) {
//         return harga = hargaMotor;
//     }
// }

public class SepedaMotor {
    private String merk;
    private long harga;

    public void setMerk(String merkMotor) {
        merk = merkMotor;
    }

    public String getMerk() {
        return merk;
    }

    public void setHarga(long hargaMotor) {
        harga = hargaMotor;
    }

    public long getHarga() {
        return harga;
    }

    public static void main(String[] args) {
        SepedaMotor motor = new SepedaMotor(); // Membuat objek SepedaMotor
        motor.setMerk("Honda"); // Mengatur merk motor
        motor.setHarga(15000000); // Mengatur harga motor
        
        // Menampilkan merk dan harga motor
        System.out.println("Merk Motor: " + motor.getMerk());
        System.out.println("Harga Motor: " + motor.getHarga());
    }
}
