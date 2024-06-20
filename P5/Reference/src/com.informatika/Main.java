

public class Main {

    static class Buku{
        String judul;
            String penulis;

            Buku(String judul, String penulis){
                this.judul = judul;
                this.penulis = penulis;
            }

            void display(){
                System.out.println("\nJudul\t: " + this.judul);
                System.out.println("Penulis\t: " + this.penulis);
            }
    }

    public static void main(String[] args) {
        Buku buku1 = new Buku("Pengantar Teknik Informatika", "Eka Eki Eko");
        buku1.display();
        int addressBuku1 = System.identityHashCode(buku1);
        System.out.println(Integer.toHexString(addressBuku1));
        
        Buku buku2 = new Buku("Pengantar Teknik Informatika", "Eka Eki Eko");
        buku1.display();
        int addressBuku2 = System.identityHashCode(buku2);
        System.out.println(Integer.toHexString(addressBuku2));

        fungsi(buku2);
        buku1.display();
        buku2.display();

    }

    static void fungsi(Buku dataBuku){
        String addressDataBuku = Integer.toHexString(System.identityHashCode(dataBuku));
        System.out.println("address dalam fungsi " + addressDataBuku);
        dataBuku.penulis = "Eka Wijaya";
    }

}