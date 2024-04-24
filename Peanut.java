import java.util.ArrayList;
import java.util.List;

public class Peanut implements Contract {

    private List<String> inventory = new ArrayList<>();

     
    public void startGame() {
        System.out.println("Welcome to Peanut's adventure!");
    }

     
    public void inventory() {
        System.out.println("Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty! Oh no!");
        } else {
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
    }

     
    public void grab(String item) {
        System.out.println("Your tiny paws grabbed the " + item + ".");
        inventory.add(item);
    }

     
    public String drop(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            return item;
        } else {
            return null;
        }
    }

     
    public void sniff(String item) {
        System.out.println("You sniffed the " + item + ".");
    }

     
    public void drink() {
        System.out.println("You took a sip of water.");
    }

     
    public boolean roll(int x, int y) {
        System.out.println("You stopped, dropped, and rolled to (" + x + ", " + y + ").");
        return true;
    }

     
    public void climb(String item) {
        System.out.println("You climbed on top of the " + item + ".");
    }

     
    public void bite(String item) {
        System.out.println("You bit into the " + item + ".");
    }

     
    public void attack(String item) {
        System.out.println("You attacked " + item + "! You're so strong!");
    }

     
    public void use(String item) {
        System.out.println("You used the " + item + ".");
    }

     
    public boolean scurry(String direction) {
        System.out.println("You scurried " + direction + ".");
        return true;
    }

     
    public boolean jump(int x, int y) {
        System.out.println("You jumped to (" + x + ", " + y + ").");
        return true;
    }

     
    public Number eat() {
        System.out.println("You ate a tasty treat.");
        return 1; // Placeholder return
    }

     
    public Number poop() {
        System.out.println("You pooped.");
        return 1; // Placeholder return
    }

     
    public void snooze() {
        System.out.println("You took a little snooze in your den.");
    }

     
    public void undo() {
        System.out.println("Undoing last action.");
    }

     
    public void solvePuzzle(String puzzleName, String solution) {
        System.out.println("You solved the " + puzzleName + " puzzle with " + solution + "! Great job!");
    }

     
    public void unlockRoom() {
        System.out.println("You unlocked the room! Congratulations!!!");
    }

     
    public void quitGame() {
        System.out.println("Quitting the game. Goodbye!");
    }
}
