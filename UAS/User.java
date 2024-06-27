public class User {
    protected String username;
    protected String password;
    protected String role;
    private int id;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        // Implement according to your application's logic
        return this.id; // Assuming 'id' is a field in your User class
    }
}
