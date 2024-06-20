package src;

public class Main {
    public static void main(String[] args) {
        // Creating an object of Player class
        Player player1 = new Player("Alice", 100, 50);
        System.out.println("Player 1 Info:");
        player1.displayInfo();

        System.out.println("\nPlayer 1 Levels Up:");
        player1.levelUp();
        player1.displayInfo();

        System.out.println("\n==============================\n");

        // Creating an object of Warrior class (subclass of Player)
        Warrior warrior1 = new Warrior("Bob", 150, 70, 20);
        System.out.println("Warrior 1 Info:");
        warrior1.displayInfo();

        System.out.println("\nWarrior 1 Trains:");
        warrior1.train();
        warrior1.displayInfo();
    }
}
