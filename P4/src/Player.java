package src;

public class Player {
    public String name;       // public
    protected int health;     // protected
    private int exp;          // private

    // Constructor
    public Player(String name, int health, int exp) {
        this.name = name;
        this.health = health;
        this.exp = exp;
    }

    // Method to display player information
    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Health: " + this.health);
        System.out.println("Experience: " + this.exp);
    }

    // Method to change the player's name
    public void changeName(String newName) {
        this.name = newName;
    }

    // Protected method to increase health
    protected void increaseHealth(int amount) {
        this.health += amount;
    }

    // Private method to add experience
    private void addExp(int amount) {
        this.exp += amount;
    }

    // Public method to level up the player
    public void levelUp() {
        increaseHealth(10);
        addExp(20);
        System.out.println("Player has leveled up!");
    }
}
