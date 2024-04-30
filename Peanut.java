import java.util.ArrayList;
import java.util.List;

public class Peanut implements Contract {

    private List<String> inventory = new ArrayList<>();

     
    public void startGame() {
        System.out.println("Welcome to Peanut's adventure!");
        System.out.println( "Your name is Peanut, you are a gerbil who has been living in the dorm room of a college student for a long four years.");
        System.out.println("Over the last few week, as your owner gears up for graduation, you have realized that you may never get the chance to see outside into the world of Smith College ever again.");
        System.out.println("Tired of the monotony of cage life, you hatch a plan to escape and explore the world beyond your cage.");
        System.out.println("Your objective is to break out of the cage and explore, solving puzzles, overcoming obstacles, and finding a way to freedom.");
        System.out.println("Get ready to navigate through various challenges and puzzles as you embarks on a daring adventure to explore Smith College");
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

    private Puzzle puzzle;

    public Peanut() {
        puzzle = new Puzzle();
    }

    public void explore() {
        // If the gerbil goes under the bed
        if (gerbilGoesUnderBed()) {
            System.out.println("You've entered the MAZE OF TUNNELS UNDER THE BED");
            System.out.println("You must navigate through a series of obstacles...");
            String solution = getPlayerInput(); // the player needs to input a specific command or sequence to solve the puzzle
            if (puzzle.isSolved("Under Bed", solution)) {
                System.out.println("Congratulations! You've successfully navigated the MAZE OF TUNNELS.");
                // Proceed with game progression
            } else {
                System.out.println("You failed to navigate the MAZE OF TUNNELS. Try again!");
            }
        }
    }

    private boolean gerbilGoesUnderBed() {
        // Logic to determine if the current room contains the Gerbil Gauntlet puzzle
        return true; // Placeholder logic
    }

    private String getPlayerInput() {
        // Example: Prompt the player to input a command or sequence to solve the puzzle
        return "Move the gerbil."; // Placeholder input
    }


    private boolean isWheelRotated = false;

    public void examineWheel() {
        System.out.println("You see a large wheel with various symbols engraved on it.");
        if (!isWheelRotated) {
            System.out.println("The wheel seems to be stuck.");
        } else {
            System.out.println("The symbols on the wheel are now aligned.");
        }
    }

    public void rotateWheel() {
        if (!isWheelRotated) {
            System.out.println("You give the wheel a strong push and it starts to rotate...");
            // Assume the player needs to perform some actions to rotate the wheel, e.g., entering commands
            String rotationSequence = getPlayerInput(); // Placeholder method to get player input
            if (rotationSequence.equals("Spin")) { // Check if the player input matches the solution
                System.out.println("The symbols on the wheel align perfectly!");
                isWheelRotated = true;
                // Trigger event, such as unlocking a door or revealing a hidden passage
                System.out.println("A hidden passage opens up!");
            } else {
                System.out.println("The symbols on the wheel do not align.");
            }
        } else {
            System.out.println("The wheel has already been rotated.");
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
