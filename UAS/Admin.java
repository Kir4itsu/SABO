public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, "Admin");
    }

    public void manageSystem() {
        // Implementasi manajemen sistem
        System.out.println("Mengelola sistem...");
    }
}
