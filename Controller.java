import java.util.Scanner;
import java.util.ArrayList;

public class Controller {
    static Peanut peanut = new Peanut();
    static Puzzle puzzleCage = new Puzzle();
    static Puzzle puzzleDormRoom = new Puzzle();
    static Puzzle puzzleCampus = new Puzzle();
    static Room cage = new Room("Cage", true, puzzleCage);
    static Room dormRoom = new Room("Dorm Room", true, puzzleDormRoom);
    static Room campus = new Room("Smith College Campus", true, puzzleCampus);
    static boolean puzzleCageSolved = false;
    static boolean puzzleDormRoomSolved = false;
    static boolean puzzleCampusSolved = false;
    static ArrayList<String> commands = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        peanut.startGame();

        //cageSection(sc);

        //dormSection(sc);

        campusSection(sc);

        System.out.println("You've successfully escaped from the campus!");
        peanut.quitGame();
        sc.close();
    }

    private static void cageSection(Scanner sc) {
        System.out.println(cage.getDescription());
        System.out.println(cage.isLocked());

        System.out.println("\nWhat would you like to do first?");
        String responseCage = sc.nextLine();

        commands.add("grab");
        commands.add("drop");
        commands.add("sniff");
        commands.add("drink");
        commands.add("roll");
        commands.add("climb");
        commands.add("use");
        commands.add("snooze");
        commands.add("undo");
        commands.add("HELP");

        while (puzzleCageSolved !=true) {
            switch (responseCage) {
                    case "grab":
                        System.out.println( "\nWhat do you want to grab?");
                        String itemToGrab = sc.nextLine();
                        peanut.grab(itemToGrab);
                        System.out.println(itemToGrab + " has been added to your inventory!");
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "drop":
                        System.out.println("\nWhat do you want to drop from your inventory?");
                        String itemToDrop = sc.nextLine();
                        String droppedItem = peanut.drop(itemToDrop);
                        peanut.eatAnnoy();
                        if (droppedItem != null) {
                            System.out.println(droppedItem + " has been dropped from your inventory.");
                        } else {
                            System.out.println("You don't have " + itemToDrop + " in your inventory.");
                        }
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "sniff":
                        System.out.println( "\nWhat do you want to sniff?");
                        String itemToSniff = sc.nextLine();
                        peanut.sniff(itemToSniff);
                        peanut.poop();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "drink":
                        peanut.drink();
                        peanut.eatAnnoy();
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "roll":
                        System.out.println("Enter x coordinate: ");
                        int xCoord = sc.nextInt();
                        System.out.println("Enter y coordinate: ");
                        int yCoord = sc.nextInt();
                        peanut.roll(xCoord, yCoord);
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "climb":
                        peanut.climb();
                        System.out.println("In the distance, you see the puzzle you must solve...\n");
                        System.out.println("The lock on your cage has somehow been connected to your wheel.\nIn order to open the cage, you must solve the puzzle.");
                        System.out.println("\nWould you like to solve the puzzle now or keep moving around the cage? Please enter 'Puzzle' or 'Cage' to indicate what you would like to do next.");
                        String response4 = sc.nextLine();
                        if (response4.equalsIgnoreCase("Puzzle")) {
                            System.out.println("Attempting to solve the puzzle...");
                            peanut.poop();
                            puzzleCage.wheel();
                            cage.setLocked(false);
                            puzzleCageSolved = true;
                            peanut.eatAnnoy();
                            System.out.println("Congratulations! You solved the puzzle and unlocked the cage!\n");
                        } else if (response4.equalsIgnoreCase("Cage")) {
                            System.out.println("You decide to explore more of the cage.");
                        } else {
                            System.out.println("Invalid response. Please enter 'Puzzle' or 'Cage'.");
                        }
                        break;
                    case "use":
                        System.out.println( "\nWhat would you like to use?");
                        String itemToUse = sc.nextLine();
                        peanut.use(itemToUse);
                        peanut.eatAnnoy();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "snooze":
                        peanut.snooze();
                        peanut.eatAnnoy();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "undo":
                        peanut.undo();
                        peanut.poop();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "HELP":
                        peanut.HELP();
                        peanut.poop();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "help":
                        peanut.HELP();
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "eat":
                        peanut.eat();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    default:
                        System.out.println("\nPlease check your spelling and capitalization. "+responseCage+" isn't something that you know how to do.\n");
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                }
            
            
        }

        System.out.println("You've escaped the cage!");
        System.out.println(cage.getDescription());
        System.out.println(cage.isLocked());
    }

    private static void dormSection(Scanner sc) {
        System.out.println(dormRoom.getDescription());
        System.out.println(dormRoom.isLocked());

        commands.add("grab");
        commands.add("drop");
        commands.add("sniff");
        commands.add("drink");
        commands.add("roll");
        commands.add("climb");
        commands.add("use");
        commands.add("snooze");
        commands.add("undo");
        commands.add("HELP");

        System.out.println("What's next?");
        if (sc.hasNextLine()) {
            String responseDorm = sc.nextLine();
            while (puzzleDormRoomSolved !=true){
                switch (responseDorm) {
                    case "grab":
                        System.out.println( "\nWhat do you want to grab?");
                        String itemToGrab = sc.nextLine();
                        peanut.grab(itemToGrab);
                        System.out.println(itemToGrab + " has been added to your inventory!");
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "drop":
                        System.out.println("\nWhat do you want to drop from your inventory?");
                        String itemToDrop = sc.nextLine();
                        String droppedItem = peanut.drop(itemToDrop);
                        peanut.eatAnnoy();
                        if (droppedItem != null) {
                            System.out.println(droppedItem + " has been dropped from your inventory.");
                        } else {
                            System.out.println("You don't have " + itemToDrop + " in your inventory.");
                        }
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "sniff":
                        System.out.println( "\nWhat do you want to sniff?");
                        String itemToSniff = sc.nextLine();
                        peanut.sniff(itemToSniff);
                        peanut.poop();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "drink":
                        peanut.drink();
                        peanut.eatAnnoy();
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "roll":
                        System.out.println("You rolled right in front of a maze!! \n This looks mysterious....");
                        System.out.println("\nWould you like to enter the maze now or keep moving around the dorm? Please enter 'Maze' or 'Dorm' to indicate what you would like to do next.");
                            String response4 = sc.nextLine();
                            if (response4.equalsIgnoreCase("Maze")) {
                                System.out.println("Attempting to solve the puzzle...");
                                peanut.poop();
                                puzzleDormRoom.maze();
                                cage.setLocked(false);
                                puzzleDormRoomSolved = true;
                                System.out.println("Congratulations! You solved the maze and unlocked the door to the dorm!\n");
                            } else if (response4.equalsIgnoreCase("Dorm")) {
                                System.out.println("You decide to explore more of the dorm room.");
                            } else {
                                System.out.println("Invalid response. Please enter 'Puzzle' or 'Dorm'.");
                            }
                        break;
                    case "climb":
                        System.out.println("You cannot climb in the dorm room.");
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "use":
                        System.out.println( "\nWhat would you like to use?");
                        String itemToUse = sc.nextLine();
                        peanut.use(itemToUse);
                        peanut.eatAnnoy();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();                    
                        break;
                    case "snooze":
                        peanut.snooze();
                        peanut.eatAnnoy();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");             
                        responseDorm = sc.nextLine();
                        break;
                    case "undo":
                        peanut.undo();
                        peanut.poop();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "HELP":
                        peanut.HELP();
                        peanut.poop();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "help":
                        peanut.HELP();
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    case "eat":
                        peanut.eat();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();
                        break;
                    default:
                        System.out.println("\nPlease check your spelling and capitalization. "+responseDorm+" isn't something that you know how to do.\n");
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseDorm = sc.nextLine();      
                } 
                    
            }
            System.out.println("Congratulations! You've escaped from the dorm room!");
            System.out.println(dormRoom.getDescription());
            System.out.println(dormRoom.isLocked());
        }
}

    private static void campusSection(Scanner sc) {
        System.out.println("You've entered SMITH COLLEGE CAMPUS. Now to find your way to the quad for graduation! \nYour goal is to climb on top of as many things as possible until you can find your way there!");
        System.out.println(campus.getDescription());
        System.out.println(campus.isLocked());

        commands.add("grab");
        commands.add("drop");
        commands.add("eat");
        commands.add("sniff");
        commands.add("drink");
        commands.add("roll");
        commands.add("climb");
        commands.add("HELP");
        commands.add("attack");

        System.out.println("What's next?");
        if (sc.hasNextLine()) {
            String responseCampus = sc.nextLine();
            while (puzzleCampusSolved !=true){

            switch (responseCampus) {
                case "grab":
                        System.out.println( "\nWhat do you want to grab?");
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
                        peanut.eatAnnoy();
                        if (droppedItem != null) {
                            System.out.println(droppedItem + " has been dropped from your inventory.");
                        } else {
                            System.out.println("You don't have " + itemToDrop + " in your inventory.");
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
                        System.out.println( "\nWhat do you want to sniff?");
                        String itemToSniff = sc.nextLine();
                        peanut.sniff(itemToSniff);
                        peanut.poop();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCampus = sc.nextLine();
                        break;
                case "drink":
                        peanut.drink();
                        peanut.eatAnnoy();
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCampus = sc.nextLine();
                        break;
                case "roll":
                        System.out.println("Enter x coordinate: ");
                        int xCoord = sc.nextInt();
                        System.out.println("Enter y coordinate: ");
                        int yCoord = sc.nextInt();
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
                                            peanut.eatAnnoy();
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
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCampus = sc.nextLine();
                        break;
                    default:
                        System.out.println("\nPlease check your spelling and capitalization. "+responseCampus+" isn't something that you know how to do.\n");
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCampus = sc.nextLine();
                }
            }
        }
        }  
    }