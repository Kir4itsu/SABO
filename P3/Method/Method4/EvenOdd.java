import java.util.Scanner;
public class EvenOdd{

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan Nomor: ");
        int num = scan.nextInt();

        findEvenOdd(num);
    }

    public static void findEvenOdd(int num) {

        if (num% 2 == 0) {
        System.out.println(num + " Tidak ada sisa setelah dibagi");
        } else {
            System.out.println(num + " Ada sisa setelah dibagi");
        }
    }
}