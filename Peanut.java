import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Represents Peanut, the main character in the game.
 * Peanut can perform various actions and interact with the environment.
 */
public class Peanut {

    // Fields
    private List<String> inventory = new ArrayList<>();

    /**
     * Displays the introduction to the game.
     */
    public void startGame() {
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("Welcome to Peanut's Adventure! \n");
        System.out.println( "Your name is Peanut, you are a gerbil who has been living in the dorm room of a college student for a long four years. \n");
        System.out.println("Over the last few weeks, as your owner gears up for graduation, you have realized that you may never get the chance to see outside into the world of Smith College ever again. \n");
        System.out.println("Tired of the monotony of cage life, you hatch a plan to escape and explore the world beyond your cage. \n");
        System.out.println("Your objective is to break out of the cage and explore, solving puzzles, overcoming obstacles, and finding a way to freedom.");
        System.out.println("Get ready to navigate through various challenges and puzzles as you embark on a daring adventure to explore Smith College!! \n \n");
        System.out.println("If you need help at any point just say 'HELP'.");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------\n \n");
    }

    // List of allowed items Peanut can grab
    private List<String> allowedItems = Arrays.asList("food", "bedding", "toy");

    /**
     * Allows Peanut to grab items and add them to the inventory.
     *
     * @param item The item to grab.
     */
    public void grab(String item) {
        if (!inventory.contains(item)) {
            if (allowedItems.contains(item.toLowerCase())) {
                System.out.println("\nYour tiny paws grab the " + item + ".");
                inventory.add(item);
            }else{
                System.out.println("\nYou can't grab that. \nIt's not something a gerbil would grab. Try grabbing 'food', 'bedding' or 'toy'. \n");
            }
        } else {
            System.out.println("\nYou can't grab that. \nIt's already in your inventory. \n");
        }
    }

    /**
     * Allows Peanut to drop an item from the inventory.
     *
     * @param item The item to drop.
     * @return A message indicating the result of the action.
     */
    public String drop(String item) {
        if (inventory.contains(item) && allowedItems.contains(item.toLowerCase())) {
            inventory.remove(item);
            return("\nYou dropped the " + item + ".");
        } else {
            return("\nYou don't have " + item + " in your inventory.");
        }
    }

    /**
     * Allows Peanut to sniff items in the environment.
     *
     * @param item The item to sniff.
     */
    public void sniff(String item) {
        List<String> allowedItems = Arrays.asList("food", "bedding", "toy");
        if (allowedItems.contains(item.toLowerCase())) {
            System.out.println("\nYou sniffed the " + item + ". \n");
        } else {
            System.out.println("\nYou can't sniff that. It's not something a gerbil would sniff. Try sniffing 'food', 'bedding' or 'toy'. \n");
        }
    }

    /**
     * Allows Peanut to drink water.
     */
    public void drink() {
        System.out.println("\nYou took a sip of water. \n");
    }

    /**
     * Allows Peanut to roll to a specific position.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @return True if the roll was successful, false otherwise.
     */
    public boolean roll(int x, int y) {
        if (x > 10 || y > 10) {
            System.out.println("\nOuch! You hit a wall or cannot roll that far.\n");
            return false;
        } else {
            System.out.println("\nYou stopped, dropped, and rolled to (" + x + ", " + y + ").");
            return true;
        }
    }

    /**
     * Allows Peanut to climb to a high point.
     */
    public void climb() {
        System.out.println("\nYou climb to the highest point that you can see.\n");
    }

    /**
     * Allows Peanut to use an item.
     *
     * @param item The item to use.
     */
    public void use(String item) {
        System.out.println("\nYou used the " + item + ".");
    }

    /**
     * Allows Peanut to eat food.
     */
    public void eat(){
        if (inventory.contains("food")) {
            System.out.println("\nYou look in your cheek for something to eat...");
            System.out.println("\nYou find a seed and have a tasty treat.");
        } else {
                System.out.println("You don't have any food in your inventory to eat.");
        }
    }

    /**
     * Allows Peanut to poop.
     */
    public void poop() {
        System.out.println("\nPlease pause... \n \n \n \n");
        System.out.println("\nYou pooped.");
        System.out.println("\nYou may continue now.");
    }

    /**
     * Allows Peanut to snooze if bedding is available.
     */
    public void snooze() {
        if (inventory.contains("bedding")){
            System.out.println("You take a little snooze in your den.");
        } else {
            System.out.println("You need bedding in your inventory to snooze.");
        }
    }

    /**
     * Allows Peanut to undo the last action.
     */
    public void undo() {
        System.out.println("\nUndoing last action.");
    }

    /**
     * Allows Peanut to unlock a room.
     */
    public void unlockRoom() {
        System.out.println("\nYou unlocked the room! Congratulations!!!");
    }

    /**
     * Displays help information.
     */
    public void HELP(){
        System.out.println("\nPossible commands Peanut can use: \ngrab \ndrop \nsniff \ndrink \nroll \nclimb \nuse \nsnooze \nundo \n");
    }

    /**
     * Simulates Peanut's attack on enemies.
     *
     * @param enemy The type of enemy encountered.
     */
    public void attack(String enemy) {
        switch (enemy.toLowerCase()) {
            case "mouse":
                System.out.println("\nYou encounter a mouse!");
                System.out.println("Do you want to attack the mouse? (yes/no)");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine().toLowerCase();
                if (choice.equals("yes")) {
                    System.out.println("You bravely attack the mouse and scare it away!");
                } else {
                    System.out.println("You choose not to attack the mouse and cautiously retreat.");
                }
                break;
            case "squirrel":
                System.out.println("\nYou encounter a squirrel!");
                System.out.println("Do you want to attack the squirrel? (yes/no)");
                Scanner squirrelScanner = new Scanner(System.in);
                String squirrelChoice = squirrelScanner.nextLine().toLowerCase();
                if (squirrelChoice.equals("yes")) {
                    System.out.println("You engage in a fierce battle with the squirrel!");
                    System.out.println("Unfortunately, the squirrel is too powerful and you are defeated...");
                    System.out.println("Game over. Better luck next time!");
                    quitGame();
                } else {
                    System.out.println("You choose not to attack the squirrel and cautiously retreat.");
                }
                break;
            default:
                System.out.println("\nYou encounter an unknown enemy!");
                System.out.println("You cautiously observe the enemy but choose not to engage.");
                break;
        }
    }

    /**
     * Quits the game.
     */
    public void quitGame() {
        System.out.println("\nQuitting the game. Goodbye!");
        System.exit(0);
    }
    
}
