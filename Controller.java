import java.util.Scanner;
import java.util.ArrayList;

public class Controller {
    static Peanut peanut = new Peanut();
    static Puzzle puzzleCage = new Puzzle();
    static Puzzle puzzleDormRoom = new Puzzle();
    static Puzzle puzzleCampus = new Puzzle();
    static Room cage = new Room("Cage", true, puzzleCage);
    static Room dormRoom = new Room("Dorm Room",true,puzzleDormRoom);
    static Room campus = new Room("Smith College Campus",true,puzzleCampus);
    static boolean puzzleCageSolved = false;
    static boolean puzzleDormRoomSolved = false;
    static boolean puzzleCampusSolved = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        peanut.startGame();

        System.out.println(cage.getDescription());
        System.out.println(cage.isLocked());

        System.out.println("What would you like to do first? All commands should be entered in lowercase.");
        String response = sc.nextLine();

        ArrayList<String> commands = new ArrayList<String>();
        commands.add("grab");
        commands.add("drop");
        commands.add("sniff");
        commands.add("drink");
        commands.add("roll");
        commands.add("climb");
        commands.add("use");
        commands.add("scurry");
        commands.add("eat");
        commands.add("snooze");
        commands.add("undo");

        while (!puzzleSolved) {
            if (commands.contains(response)) {
                switch (response) {
                    case "grab":
                        System.out.println("What do you want to grab?");
                        String itemToGrab = sc.nextLine();
                        peanut.grab(itemToGrab);
                        System.out.println(itemToGrab + " has been added to your inventory!");
                        break;
                    case "drop":
                        System.out.println("What do you want to drop from your inventory?");
                        String itemToDrop = sc.nextLine();
                        String droppedItem = peanut.drop(itemToDrop);
                        if (droppedItem != null) {
                            System.out.println(droppedItem + " has been dropped from your inventory.");
                        } else {
                            System.out.println("You don't have " + itemToDrop + " in your inventory.");
                        }
                        break;
                    case "sniff":
                        System.out.println("What do you want to sniff?");
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
                        break;
                    case "climb":
                        peanut.climb();
                        System.out.println("In the distance, you see the puzzle you must solve...");
                        System.out.println("The lock on your cage has somehow been connected to your wheel.\nIn order to open the cage, you must solve the puzzle.");
                        System.out.println("Would you like to solve the puzzle now or keep moving around the cage? Please enter 'Puzzle' or 'Cage' to indicate what you would like to do next.");
                        String response4 = sc.nextLine();
                        if (response4.equalsIgnoreCase("Puzzle")) {
                            System.out.println("Attempting to solve the puzzle...");
                            puzzleCage.wheel();
                            cage.setLocked(false);
                            puzzleSolved = true;
                            System.out.println("Congratulations! You solved the puzzle and unlocked the cage!");
                        } else if (response4.equalsIgnoreCase("Cage")) {
                            System.out.println("You decide to explore more of the cage.");
                        } else {
                            System.out.println("Invalid response. Please enter 'Puzzle' or 'Cage'.");
                        }
                        break;
                    case "use":
                        System.out.println("What would you like to use?");
                        String itemToUse = sc.nextLine();
                        peanut.use(itemToUse);
                        break;
                    case "scurry":
                        System.out.println("Where are you scurrying?");
                        String directionToScurry = sc.nextLine();
                        peanut.scurry(directionToScurry);
                        break;
                    case "eat":
                        peanut.eat();
                        break;
                    case "snooze":
                        peanut.snooze();
                        break;
                    case "undo":
                        peanut.undo();
                        break;
                }
            } else {
                System.out.println("Please check your spelling and capitalization. That isn't something that you know how to do.");
            }

            if (!puzzleSolved) {
                System.out.println("What would you like to do next? Remember, all commands should be entered in lowercase.");
                response = sc.nextLine();
            }
        }
        System.out.println("Congratulations! You've escaped the cage!");
        Puzzle puzzleDormRoom = new Puzzle();
        dormRoom = new Room("Dorm Room", false, puzzleDormRoom);

        

        System.out.println("What would you like to do next? All commands should be entered in lowercase.");
        String response5 = sc.nextLine();

        while (!(puzzleDormRoom.isSolved) ){
        System.out.println(dormRoom.getDescription());
        System.out.println(dormRoom.isLocked());
      
            if (commands.contains(response5)) {
                switch (response5) {
                        case "grab":
                            System.out.println("What do you want to grab?");
                            String itemToGrab = sc.nextLine();
                            peanut.grab(itemToGrab);
                            peanut.poop();
                            System.out.println(itemToGrab + " has been added to your inventory!");
                            break;
                        case "drop":
                            System.out.println("What do you want to drop from your inventory?");
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
                            System.out.println("What do you want to sniff?");
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
                        System.out.println("What would you like to use?");
                        String itemToUse = sc.nextLine();
                        peanut.use(itemToUse);
                        peanut.poop();
                        break;
                    case "scurry":
                        System.out.println("Where are you scurrying?");
                        String directionToScurry = sc.nextLine();
                        peanut.scurry(directionToScurry);
                        break;
                    case "eat":
                        peanut.eat();
                        peanut.poop();
                        break;
                    case "snooze":
                        peanut.snooze();
                        break;
                    case "undo":
                        peanut.undo();
                        break;
                }
            } else {
                System.out.println("Please check your spelling and capitalization. That isn't something that you know how to do.");
            }
        }
        System.out.println("Congratulations! You've escaped from the dorm room!");
        System.out.println("You've entered SMITH COLLEGE CAMPUS. Now to find your way to the quad for graduation!");

        while (!puzzleCampusSolved) {
            System.out.println(campus.getDescription());
            System.out.println(campus.isLocked());

            System.out.println("What would you like to do next? All commands should be entered in lowercase.");
            String responseCampus = sc.nextLine();

            if (commands.contains(responseCampus)) {
                switch (response) {
                    case "grab":
                            System.out.println("What do you want to grab?");
                            String itemToGrab = sc.nextLine();
                            peanut.grab(itemToGrab);
                            peanut.poop();
                            System.out.println(itemToGrab + " has been added to your inventory!");
                            break;
                        case "drop":
                            System.out.println("What do you want to drop from your inventory?");
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
                            System.out.println("What do you want to sniff?");
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
                            System.out.println("You cannot climb on campus unfortunately.");
                            break;
                        case "solve":
                            System.out.println("Attempting to solve the puzzle...");
                            puzzleCampus.navigateTunnels();
                            if (puzzleCampus.isSolved) {
                                System.out.println("Congratulations! You've navigated through the tunnels and escaped from the campus!");
                                puzzleCampusSolved = true;
                            } else {
                                System.out.println("You failed to navigate through the tunnels. Try again!");
                            }
                            break;
                        case "use":
                            System.out.println("What would you like to use?");
                            String itemToUse = sc.nextLine();
                            peanut.use(itemToUse);
                            peanut.poop();
                            break;
                        case "scurry":
                            System.out.println("Where are you scurrying?");
                            String directionToScurry = sc.nextLine();
                            peanut.scurry(directionToScurry);
                            break;
                        case "eat":
                            peanut.eat();
                            peanut.poop();
                            break;
                        case "snooze":
                            peanut.snooze();
                            break;
                        case "undo":
                            peanut.undo();
                            break;
                }
            } else {
                System.out.println("Please check your spelling and capitalization. That isn't something that you know how to do.");
            }
        }
        System.out.println("You've successfully escaped from the campus!");
        sc.close();
    }
}
                        