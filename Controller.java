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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        peanut.startGame();

        System.out.println(cage.getDescription());
        System.out.println(cage.isLocked());

        System.out.println( "\nWhat would you like to do first?");
        String responseCage = sc.nextLine();

        ArrayList<String> commands = new ArrayList<String>();
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
                        peanut.eat();
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
                        peanut.eat();
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
                        System.out.println("In the distance, you see the puzzle you must solve...");
                        System.out.println("The lock on your cage has somehow been connected to your wheel.\nIn order to open the cage, you must solve the puzzle.");
                        System.out.println("\nWould you like to solve the puzzle now or keep moving around the cage? Please enter 'Puzzle' or 'Cage' to indicate what you would like to do next.");
                        String response4 = sc.nextLine();
                        if (response4.equalsIgnoreCase("Puzzle")) {
                            System.out.println("Attempting to solve the puzzle...");
                            peanut.poop();
                            puzzleCage.wheel();
                            cage.setLocked(false);
                            puzzleCageSolved = true;
                            peanut.eat();
                            System.out.println("Congratulations! You solved the puzzle and unlocked the cage!\n");
                        } else if (response4.equalsIgnoreCase("Cage")) {
                            System.out.println("You decide to explore more of the cage.");
                        } else {
                            System.out.println("Invalid response. Please enter 'Puzzle' or 'Cage'.");
                        }
                        System.out.println( "\nWhat would you like to do next?");
                        responseCage = sc.nextLine();
                        break;
                    case "use":
                        System.out.println( "\nWhat would you like to use?");
                        String itemToUse = sc.nextLine();
                        peanut.use(itemToUse);
                        peanut.eat();
                        System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                        break;
                    case "snooze":
                        peanut.snooze();
                        peanut.eat();
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
                    default:
                        System.out.println("\nPlease check your spelling and capitalization. "+responseCage+" isn't something that you know how to do.\n");
                        System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                        responseCage = sc.nextLine();
                }
            
        }

        System.out.println("Congratulations! You've escaped the cage!");
        Puzzle puzzleDormRoom = new Puzzle();
        dormRoom = new Room("Dorm Room", false, puzzleDormRoom);

        System.out.println("Next?");
        String responseDorm = sc.nextLine();

        while (puzzleDormRoom.isSolved !=true){
            System.out.println(dormRoom.getDescription());
            System.out.println(dormRoom.isLocked());
            switch (responseDorm) {
                    case "grab":
                        System.out.println( "\nWhat do you want to grab?");
                        String itemToGrab = sc.nextLine();
                        peanut.grab(itemToGrab);
                        peanut.poop();
                        System.out.println(itemToGrab + " has been added to your inventory!");
                         
                        break;
                    case "drop":
                        System.out.println( "\nWhat do you want to drop from your inventory?");
                        String itemToDrop = sc.nextLine();
                        String droppedItem = peanut.drop(itemToDrop);
                        if (droppedItem != null) {
                            System.out.println(droppedItem + " has been dropped from your inventory.");
                        } else {
                            System.out.println("You don't have " + itemToDrop + " in your inventory.");
                            peanut.poop();
                        }
                         
                        break;
                    case "sniff":
                        System.out.println( "\nWhat do you want to sniff?");
                        String itemToSniff = sc.nextLine();
                        peanut.sniff(itemToSniff);
                         
                        break;
                    case "drink":
                        peanut.drink();
                        break;
                    case "roll":
                        System.out.println("Enter x coordinate: ");
                        int xCoord = sc.nextInt();
                        System.out.println("Enter y coordinate: ");
                        int yCoord = sc.nextInt();
                        peanut.roll(xCoord, yCoord);
                        peanut.poop();
                         
                        break;
                    case "climb":
                        System.out.println("You cannot climb in the dorm room.");
                         
                        break;
                    case "solve":
                        System.out.println("Attempting to solve the puzzle...");
                        puzzleDormRoom.maze();
                        if (puzzleDormRoom.isSolved) {
                            System.out.println("Congratulations! You've solved the maze puzzle and escaped from the dorm room!");
                            puzzleDormRoom.setSolved(true);
                        } else {
                            peanut.poop();
                            System.out.println("You failed to solve the maze puzzle. Try again!");
                        }
                         
                        break;
                    case "use":
                        System.out.println( "\nWhat would you like to use?");
                        String itemToUse = sc.nextLine();
                        peanut.use(itemToUse);
                        peanut.poop();
                         
                        break;
                    case "snooze":
                        peanut.snooze();
                         
                        break;
                    case "undo":
                        peanut.undo();
                         
                        break;
                    case "HELP":
                        peanut.HELP();
                        break;
                    case "help":
                        peanut.HELP();
                        break;
                    default:
                            System.out.println("Please check your spelling and capitalization. That isn't something that you know how to do.");
                            System.out.println( "\nWhat would you like to do next? Please enter a new response:");
                            responseCage = sc.nextLine();
                
        }
        System.out.println("Congratulations! You've escaped from the dorm room!");
        System.out.println("You've entered SMITH COLLEGE CAMPUS. Now to find your way to the quad for graduation!");

        while (!puzzleCampusSolved) {
            System.out.println(campus.getDescription());
            System.out.println(campus.isLocked());

            System.out.println( "\nWhat's next?");
            String responseCampus = sc.nextLine();

            switch (responseCampus) {
                    case "grab":
                        System.out.println( "\nWhat do you want to grab?");
                        String itemToGrab = sc.nextLine();
                        peanut.grab(itemToGrab);
                        peanut.poop();
                        System.out.println(itemToGrab + " has been added to your inventory!");
                         
                        break;
                    case "drop":
                        System.out.println( "\nWhat do you want to drop from your inventory?");
                        String itemToDrop = sc.nextLine();
                        String droppedItem = peanut.drop(itemToDrop);
                        if (droppedItem != null) {
                            System.out.println(droppedItem + " has been dropped from your inventory.");
                        } else {
                            System.out.println("You don't have " + itemToDrop + " in your inventory.");
                            peanut.poop();
                        }
                         
                        break;
                    case "sniff":
                        System.out.println( "\nWhat do you want to sniff?");
                        String itemToSniff = sc.nextLine();
                        peanut.sniff(itemToSniff);
                        peanut.eat();
                         
                        break;
                    case "drink":
                        peanut.drink();
                         
                        break;
                    case "roll":
                        System.out.println("Enter x coordinate: ");
                        int xCoord = sc.nextInt();
                        System.out.println("Enter y coordinate: ");
                        int yCoord = sc.nextInt();
                        peanut.roll(xCoord, yCoord);
                        peanut.poop();
                         
                        break;
                    case "climb":
                        System.out.println("You cannot climb on campus unfortunately.");
                         
                        break;
                    case "solve":
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
                    case "use":
                        System.out.println( "\nWhat would you like to use?");
                        String itemToUse = sc.nextLine();
                        peanut.use(itemToUse);
                        peanut.poop();
                         
                        break;
                    case "snooze":
                        peanut.eat();
                        peanut.snooze();
                         
                        break;
                    case "undo":
                        peanut.undo();
                         
                        break;
                    case "HELP":
                        peanut.HELP();
                        break;
                    case "help":
                        peanut.HELP();
                        break;
                    default:
                        System.out.println("Please check your spelling and capitalization. That isn't something that you know how to do.");
                        System.out.println( "\nWhat would you like to do next? Please enter a new response:");
                        responseCage = sc.nextLine();
                }
           
            
        System.out.println("You've successfully escaped from the campus!");
        peanut.quitGame();
        sc.close();
        }

        }
    }
}
