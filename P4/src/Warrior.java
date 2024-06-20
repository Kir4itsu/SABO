package src;

public class Warrior extends Player {
    public int strength;    // public

    // Constructor
    public Warrior(String name, int health, int exp, int strength) {
        super(name, health, exp);
        this.strength = strength;
    }

    // Override method to display warrior information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Strength: " + this.strength);
    }

    // Method to train the warrior and increase health
    public void train() {
        increaseHealth(5);  // accessing protected method from parent class
        System.out.println("Warrior has trained and increased health!");
    }
}
