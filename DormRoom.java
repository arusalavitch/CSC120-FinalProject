import java.util.Scanner;

/**
 * Represents a dorm room in the game.
 * Players can interact with various objects and solve puzzles.
 */
public class DormRoom extends Room {
    private boolean puzzleDormRoomSolved;
    static Puzzle puzzleDormRoom = new Puzzle();
    Peanut peanut = new Peanut();

    /**
     * Constructs a DormRoom object.
     * Initializes the puzzle status.
     */
    public DormRoom() {
        super("DORM ROOM", true, puzzleDormRoom);
        this.puzzleDormRoomSolved = false;
    }

    /**
     * Enters the dorm room and initiates interactions.
     *
     * @param sc_dorm The scanner object for dorm room interactions.
     */
    public void enterRoom(Scanner sc_dorm) {
        System.out.println(getDescription());
        System.out.println(isLocked());

        while (!puzzleDormRoomSolved) {
            System.out.println("\nWhat would you like to do next?");
            String responseDorm = sc_dorm.nextLine();

            switch (responseDorm.toLowerCase()) {
                case "grab":
                    System.out.println("\nWhat do you want to grab?");
                    String itemToGrab = sc_dorm.nextLine();
                    peanut.grab(itemToGrab);
                    System.out.println(itemToGrab + " has been added to your inventory!");
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "drop":
                    System.out.println("\nWhat do you want to drop from your inventory?");
                    String itemToDrop = sc_dorm.nextLine();
                    String droppedItem = peanut.drop(itemToDrop);
                    peanut.eat();
                    if (droppedItem != null) {
                        System.out.println(droppedItem + " has been dropped from your inventory.");
                    } else {
                        System.out.println("You don't have " + itemToDrop + " in your inventory.");
                    }
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "sniff":
                    System.out.println("\nWhat do you want to sniff?");
                    String itemToSniff = sc_dorm.nextLine();
                    peanut.sniff(itemToSniff);
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "drink":
                    peanut.drink();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "roll":
                    System.out.println("You roll and roll and roll right into a maze!");
                    System.out.println("\nWould you like to enter the maze now or keep moving around the dorm? Please enter 'Maze' or 'Dorm' to indicate what you would like to do next.");
                    String response4 = sc_dorm.nextLine();
                    if (response4.equalsIgnoreCase("Maze")) {
                        peanut.poop();
                        System.out.println("Attempting to solve the puzzle...");
                        puzzleDormRoom.maze();
                        setLocked(false);
                        puzzleDormRoomSolved = true;
                    } else if (response4.equalsIgnoreCase("Dorm")) {
                        System.out.println("You decide to explore more of the dorm room.");
                        peanut.poop();
                    } else {
                        System.out.println("Invalid response. Please enter 'Puzzle' or 'Dorm'.");
                    }
                    break;
                case "climb":
                    System.out.println("You cannot climb in the dorm room.");
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "use":
                    System.out.println("\nWhat would you like to use?");
                    String itemToUse = sc_dorm.nextLine();
                    peanut.use(itemToUse);
                    peanut.eat();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "snooze":
                    peanut.snooze();
                    peanut.eat();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "undo":
                    peanut.undo();
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "help":
                    peanut.HELP();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                case "eat":
                    peanut.eat();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    break;
                default:
                    System.out.println("\nPlease check your spelling and capitalization. " + responseDorm + " isn't something that you know how to do.\n");
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
            }
        }
        setLocked(false);
        System.out.println(isLocked());
        System.out.println("You've escaped from the dorm room!");

    }
}
