import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Peanut implements Contract {

    List<String> inventory = new ArrayList<>();

     
    public void startGame() {
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("Welcome to Peanut's Adventure!");
        System.out.println( "Your name is Peanut, you are a gerbil who has been living in the dorm room of a college student for a long four years.");
        System.out.println("Over the last few week, as your owner gears up for graduation, you have realized that you may never get the chance to see outside into the world of Smith College ever again.");
        System.out.println("Tired of the monotony of cage life, you hatch a plan to escape and explore the world beyond your cage.");
        System.out.println("Your objective is to break out of the cage and explore, solving puzzles, overcoming obstacles, and finding a way to freedom.");
        System.out.println("Get ready to navigate through various challenges and puzzles as you embarks on a daring adventure to explore Smith College!!");
    }

    public void grab (String item) {
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
        List<String> allowedItems = Arrays.asList("food", "bedding", "treats", "toy");
        if (allowedItems.contains(item.toLowerCase())) {
            System.out.println("You sniffed the " + item + ".");
        } else {
            System.out.println("You can't sniff that. It's not something a gerbil would sniff.");
        }
    }
    

     
    public void drink() {
        System.out.println("You took a sip of water.");
    }

     
    public boolean roll(int x, int y) {
        if (x == 10 && y == 10) {
            System.out.println("You stopped, dropped, and rolled to (" + x + ", " + y + ").");
            System.out.println("You've rolled directly in front of the puzzle!! What luck!");
            System.out.println("Would you like to solve the puzzle now? Enter 'yes' to solve or 'no' to continue exploring.");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Select 'solve' when it prompts you next!");
                scanner.close();
                return true;
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("You decide to continue exploring.");
                scanner.close();
                return true;
            } else {
                System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                scanner.close();
                return false;
            }
        } else if (x > 10 || y > 10) {
            System.out.println("Ouch! You hit a wall or cannot roll that far.");
            return false;
        } else {
            System.out.println("You stopped, dropped, and rolled to (" + x + ", " + y + ").");
            return true;
        }
    }
    
    

     
    public void climb() {
        System.out.println("You climb to the highest point that you can see.");
    }

     
    public void use(String item) {
        System.out.println("You used the " + item + ".");
    }
    

     
    public void eat() {
        System.out.println("Pause, please. You're getting hungry.");
        System.out.println("You find nut and have a tasty treat.");
    }

     
    public void poop() {
        System.out.println("Please pause...");
        System.out.println();
        System.out.println();
        System.out.println("You pooped.");
        System.out.println(" You may continue now.");
    }

     
    public void snooze() {
        System.out.println("You took a little snooze in your den.");
    }

     
    public void undo() {
        System.out.println("Undoing last action.");
    }

     
    public void unlockRoom() {
        System.out.println("You unlocked the room! Congratulations!!!");
    }

     
    public void quitGame() {
        System.out.println("Quitting the game. Goodbye!");
    }
}
