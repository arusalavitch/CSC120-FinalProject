import java.util.Scanner;

/**
 * Represents a cage room in the game.
 * Players can interact with various objects and solve puzzles.
 */
public class CageRoom extends Room {
    private boolean puzzleCageSolved;
    static Puzzle puzzleCage = new Puzzle();
    Peanut peanut = new Peanut();

    /**
     * Constructs a CageRoom object.
     * Initializes the puzzle status.
     */
    public CageRoom() {
        super("CAGE", true, puzzleCage);
        this.puzzleCageSolved = false;
    }

    /**
     * Enters the cage room and initiates interactions.
     *
     * @param sc_cage The scanner object for cage room interactions.
     */
    public void enterRoom(Scanner sc_cage) {
        System.out.println(getDescription());
        System.out.println(isLocked());

        System.out.println("\nWhat would you like to do first?");
        String responseCage = sc_cage.nextLine();

        while (!puzzleCageSolved) {
            switch (responseCage.toLowerCase()) {
                case "grab":
                    System.out.println("\nWhat do you want to grab?");
                    String itemToGrab = sc_cage.nextLine();
                    peanut.grab(itemToGrab);
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "drop":
                    System.out.println("\nWhat do you want to drop from your inventory?");
                    String itemToDrop = sc_cage.nextLine();
                    System.out.println(peanut.drop(itemToDrop));
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "sniff":
                    System.out.println("\nWhat do you want to sniff?");
                    String itemToSniff = sc_cage.nextLine();
                    peanut.sniff(itemToSniff);
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "drink":
                    peanut.drink();
                    System.out.println("In the reflection of the water, you notice that there is something connected to the lock on the cage.\n");
                    System.out.println("Is it... your wheel?\nIn order to open the cage, you must solve the puzzle.");
                    System.out.println("\nWould you like to solve the puzzle now or keep exploring the cage? Please enter 'Puzzle' or 'Cage' to indicate what you would like to do next.");
                    String drinkresponse = sc_cage.nextLine();
                    if (drinkresponse.equalsIgnoreCase("Puzzle")) {
                        System.out.println("Attempting to solve the puzzle...");
                        peanut.poop();
                        puzzleCage.wheel();
                        setLocked(false);
                        puzzleCageSolved = true;
                        System.out.println("You solved the puzzle and unlocked the cage!\n");
                    } else if (drinkresponse.equalsIgnoreCase("Cage")) {
                        System.out.println("You decide to explore more of the cage.");
                    } else {
                        System.out.println("Invalid response. Please enter 'Puzzle' or 'Cage'.");
                    }
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "roll":
                    System.out.println("Enter x coordinate: ");
                    int xCoord = sc_cage.nextInt();
                    System.out.println("Enter y coordinate: ");
                    int yCoord = sc_cage.nextInt();
                    peanut.roll(xCoord, yCoord);
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "climb":
                    peanut.climb();
                    System.out.println("In the distance, you see the puzzle you must solve...\n");
                    System.out.println("The lock on your cage has somehow been connected to your wheel.\nIn order to open the cage, you must solve the puzzle.");
                    System.out.println("\nIt's your chance to escape!");
                    System.out.println("Attempting to solve the puzzle...");
                    peanut.poop();
                    puzzleCage.wheel();
                    puzzleCageSolved = true;
                    break;
                case "use":
                    System.out.println("\nWhat would you like to use?");
                    String itemToUse = sc_cage.nextLine();
                    peanut.use(itemToUse);
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "snooze":
                    peanut.snooze();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "undo":
                    peanut.undo();
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "help":
                    peanut.HELP();
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                case "eat":
                    peanut.eat();
                    System.out.println("Now you're thirsty. Please go get a drink.");
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
                    break;
                default:
                    System.out.println("\nPlease check your spelling and capitalization. " + responseCage + " isn't something that you know how to do.\n");
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCage = sc_cage.nextLine();
            }
        }

        setLocked(false);
        System.out.println(isLocked());
        System.out.println("You've successfully solved the puzzle and unlocked the cage!");

    }
}
