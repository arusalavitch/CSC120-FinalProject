import java.util.Scanner;

/**
 * Represents a room in the campus where the player navigates to find their way to the graduation quad.
 * Players need to climb on top of various objects to progress and solve puzzles.
 */
public class CampusRoom extends Room {
    private boolean puzzleCampusSolved;
    static Puzzle puzzleCampus = new Puzzle();
    Peanut peanut = new Peanut();

    /**
     * Constructs a CampusRoom object.
     * Initializes the puzzle status.
     */
    public CampusRoom() {
        super("SMITH COLLEGE CAMPUS", true, puzzleCampus);
        this.puzzleCampusSolved = false;
    }

    /**
     * Enters the campus room and initiates interactions.
     *
     * @param sc The scanner object for campus room interactions.
     */
    public void enterRoom(Scanner sc) {
        System.out.println("You've entered SMITH COLLEGE CAMPUS. Now to find your way to the quad for graduation! \nYour goal is to climb on top of as many things as possible until you can find your way there!");
        System.out.println(getDescription());
        System.out.println(isLocked());

        System.out.println("What's next?");
        String responseCampus = sc.nextLine();

        while (!puzzleCampusSolved) {
            switch (responseCampus.toLowerCase()) {
                case "grab":
                    System.out.println("\nWhat do you want to grab?");
                    String itemToGrab = sc.nextLine();
                    peanut.grab(itemToGrab);
                    System.out.println(itemToGrab + " has been added to your inventory!");
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "drop":
                    System.out.println("\nWhat do you want to drop from your inventory?");
                    String itemToDrop = sc.nextLine();
                    String droppedItem = peanut.drop(itemToDrop);
                    peanut.eat();
                    if (droppedItem != null) {
                        System.out.println(droppedItem + " has been dropped from your inventory.");
                    } else {
                        System.out.println("You don't have " + itemToDrop + " in your inventory.");
                        peanut.poop();
                    }
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "eat":
                    peanut.eat();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "sniff":
                    System.out.println("\nWhat do you want to sniff?");
                    String itemToSniff = sc.nextLine();
                    peanut.sniff(itemToSniff);
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "drink":
                    peanut.drink();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "roll":
                    System.out.println("Enter x coordinate: ");
                    int xCoord = sc.nextInt();
                    System.out.println("Enter y coordinate: ");
                    int yCoord = sc.nextInt();
                    sc.nextLine();
                    peanut.roll(xCoord, yCoord);
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "climb":
                    System.out.println("What would you like to climb? \nYou can say things like 'building', 'tree'");
                    String toClimb = sc.nextLine();
                    if (toClimb.equalsIgnoreCase("tree")) {
                        System.out.println("You start climbing the nearest tree...");
                        System.out.println("Suddenly, you encounter a squirrel!");
                        System.out.println("Do you want to fight the squirrel? (yes/no)");
                        String fightChoice = sc.nextLine();
                        if (fightChoice.equalsIgnoreCase("yes")) {
                            System.out.println("You engage in a fierce battle with the squirrel!");
                            System.out.println("Unfortunately, the squirrel overwhelms you and you lose the fight...");
                            System.out.println("GAME OVER");
                            peanut.quitGame();
                            return;
                        } else if (fightChoice.equalsIgnoreCase("no")) {
                            System.out.println("You wisely decide to retreat away from the squirrel.");
                            System.out.println("What would you like to do next?");
                        } else {
                            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                        }
                    } else if (toClimb.equalsIgnoreCase("building")) {
                        System.out.println("Which building would you like to climb? You can choose from: Campus Center, Seeleye, Nielson, Sabin Reed, Bass");

                        String buildingChoice = sc.nextLine();
                        switch (buildingChoice.toLowerCase()) {
                            case "campus center":
                                System.out.println("You climb to the top of the Campus Center and get a panoramic view of the campus.");
                                System.out.println("You spot something unusual behind the Campus Center. Investigate? (yes/no)");
                                String investigateChoice = sc.nextLine();
                                if (investigateChoice.equalsIgnoreCase("yes")) {
                                    System.out.println("You investigate behind the Campus Center and discover hidden tunnels!");
                                    System.out.println("These tunnels lead directly to the quad. You've found your way to graduation!");
                                    puzzleCampusSolved = true;
                                    peanut.poop();
                                    peanut.quitGame();
                                } else if (investigateChoice.equalsIgnoreCase("no")) {
                                    System.out.println("You decide not to investigate and continue exploring.");
                                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                                    responseCampus = sc.nextLine();
                                } else {
                                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                                }
                                break;
                            case "seeleye":
                                System.out.println("You climb to the top of Seeleye and have a bird's eye view of the entire campus.");
                                System.out.println("You notice something glinting in the distance. Investigate? (yes/no)");
                                String investigateSeeleyeChoice = sc.nextLine();
                                if (investigateSeeleyeChoice.equalsIgnoreCase("yes")) {
                                    System.out.println("You investigate and find a map hidden under a loose floorboard!");
                                    System.out.println("The map reveals secret tunnels that lead directly to the quad. You've found your way to graduation!");
                                    System.out.println("Attempting to solve the puzzle...");
                                    puzzleCampus.navigateTunnels();
                                    if (puzzleCampus.isSolved) {
                                        System.out.println("Congratulations! You've navigated through the tunnels and escaped from the campus!");
                                        puzzleCampusSolved = true;
                                        peanut.eat();
                                    } else {
                                        System.out.println("You failed to navigate through the tunnels. Try again!");
                                    }
                                    break;
                                } else if (investigateSeeleyeChoice.equalsIgnoreCase("no")) {
                                    System.out.println("You decide not to investigate and continue exploring.");
                                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                                    responseCampus = sc.nextLine();
                                } else {
                                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                                }
                                break;
                            case "nielson":
                            case "sabin reed":
                            case "bass":
                                System.out.println("You climb to the top of the " + buildingChoice + " and enjoy the view.");
                                System.out.println("However, you don't find anything particularly interesting.");
                                System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                                responseCampus = sc.nextLine();
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose one of the available buildings.");
                                break;
                        }
                    } else {
                        System.out.println("Invalid choice. Please choose 'building' or 'tree'.");
                    }
                    break;
                case "undo":
                    peanut.undo();
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "HELP":
                    peanut.HELP();
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                case "help":
                    peanut.HELP();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
                    break;
                default:
                    System.out.println("\nPlease check your spelling and capitalization. " + responseCampus + " isn't something that you know how to do.\n");
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseCampus = sc.nextLine();
            }
        }
    }
}
