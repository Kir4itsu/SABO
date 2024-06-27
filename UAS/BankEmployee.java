public class BankEmployee extends User {
    public BankEmployee(String username, String password) {
        super(username, password, "BankEmployee");
    }

    public void handleTransactions() {
        // Implementasi transaksi
        System.out.println("Melayani transaksi...");
    }
}
