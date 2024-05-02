import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Peanut implements Contract {

    private List<String> inventory = new ArrayList<>();

     
    public void startGame() {
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("Welcome to Peanut's Adventure! \n");
        System.out.println( "Your name is Peanut, you are a gerbil who has been living in the dorm room of a college student for a long four years. \n");
        System.out.println("Over the last few week, as your owner gears up for graduation, you have realized that you may never get the chance to see outside into the world of Smith College ever again. \n");
        System.out.println("Tired of the monotony of cage life, you hatch a plan to escape and explore the world beyond your cage. \n");
        System.out.println("Your objective is to break out of the cage and explore, solving puzzles, overcoming obstacles, and finding a way to freedom.");
        System.out.println("Get ready to navigate through various challenges and puzzles as you embarks on a daring adventure to explore Smith College!! \n \n");
        System.out.println("If you need help at any point just say 'HELP'.");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------\n \n");
    }

    List<String> allowedItems = Arrays.asList("food", "bedding", "treats", "toy");

    public void grab(String item) {
        if (allowedItems.contains(item.toLowerCase())) {
            System.out.println("\nYour tiny paws grab the " + item + ".");
            inventory.add(item);
        } else {
            System.out.println("\nYou can't grab that. It's not something a gerbil would grab. Try grabbing 'food', 'bedding', 'treats' or 'toy'. \n");
        }
    }

    public String drop(String item) {
        if (inventory.contains(item) && allowedItems.contains(item.toLowerCase())) {
            inventory.remove(item);
            return("\nYou dropped the " + item + ".");
        } else {
            return("\nYou don't have " + item + " in your inventory.");
        }
    }

     
    public void sniff(String item) {
        List<String> allowedItems = Arrays.asList("food", "bedding", "treats", "toy");
        if (allowedItems.contains(item.toLowerCase())) {
            System.out.println("\nYou sniffed the " + item + ". \n");
        } else {
            System.out.println("\nYou can't sniff that. It's not something a gerbil would sniff. Try sniffing 'food', 'bedding', 'treats' or 'toy'. \n");
        }
    }
    

     
    public void drink() {
        System.out.println("\nYou took a sip of water. \n");
    }

     
    public boolean roll(int x, int y) {
        if (x == 10 && y == 10) {
            System.out.println("\nYou stopped, dropped, and rolled to (" + x + ", " + y + "). \n");
            System.out.println("\nYou've rolled directly in front of the puzzle!! What luck! \n");
            System.out.println("\nWould you like to solve the puzzle now? Enter 'yes' to solve or 'no' to continue exploring. \n");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("\nSelect 'solve' when it prompts you next! \n");
                scanner.close();
                return true;
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("\nYou decide to continue exploring.");
                scanner.close();
                return true;
            } else {
                System.out.println("\nInvalid choice. Please enter 'yes' or 'no'.");
                scanner.close();
                return false;
            }
        } else if (x > 10 || y > 10) {
            System.out.println("\nOuch! You hit a wall or cannot roll that far.\n");
            return false;
        } else {
            System.out.println("\nYou stopped, dropped, and rolled to (" + x + ", " + y + ").");
            return true;
        }
    }
    
    

     
    public void climb() {
        System.out.println("\nYou climb to the highest point that you can see.\n");
    }

     
    public void use(String item) {
        System.out.println("\nYou used the " + item + ".");
    }
    

     
    public void eat() {
        System.out.println("\nPause, please. You're getting hungry.\n \n \n \n");
        System.out.println("\nYou find nut and have a tasty treat.");
    }

     
    public void poop() {
        System.out.println("\nPlease pause... \n \n \n \n");
        System.out.println("\nYou pooped.");
        System.out.println("\nYou may continue now.");
    }

     
    public void snooze() {
        System.out.println("\nYou took a little snooze in your den.");
    }

     
    public void undo() {
        System.out.println("\nUndoing last action.");
    }

     
    public void unlockRoom() {
        System.out.println("\nYou unlocked the room! Congratulations!!!");
    }

    public void HELP(){
        System.out.println("\nPossible commands Peanut can use: \ngrab \ndrop \nsniff \ndrink \nroll \nclimb \nuse \nsnooze \nundo \n");
    }

     
    public void quitGame() {
        System.out.println("\nQuitting the game. Goodbye!");
    }
}
