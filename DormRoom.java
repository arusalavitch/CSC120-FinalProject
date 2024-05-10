import java.util.NoSuchElementException;
import java.util.Scanner;

public class DormRoom extends Room {
    private boolean puzzleDormRoomSolved;
    static Puzzle puzzleDormRoom=new Puzzle();
    Peanut peanut = new Peanut();

    public DormRoom() {
        super("DORM ROOM", true, puzzleDormRoom);
        this.puzzleDormRoomSolved = false;
    }

    public void enterRoom() {
        Scanner sc_dorm = new Scanner(System.in);
        System.out.println(getDescription());
        System.out.println(isLocked());

        while (puzzleDormRoomSolved != true){
            System.out.println("\nWhat's next?");

            String responseDorm = null;
            boolean validInput = false;
    
            while (!validInput) {
                try {
                    responseDorm = sc_dorm.nextLine().trim().toLowerCase();
                    validInput = true;
                } catch (NoSuchElementException e) {
                    System.out.println("No input found. Please input your response again.");
                    responseDorm=sc_dorm.nextLine();
                }
            }
            switch (responseDorm.toLowerCase()) {
                case "grab":
                    System.out.println( "\nWhat do you want to grab?");
                    String itemToGrab = sc_dorm.nextLine();
                    peanut.grab(itemToGrab);
                    System.out.println(itemToGrab + " has been added to your inventory!");
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();
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
                    responseDorm = sc_dorm.nextLine();
                    break;
                case "sniff":
                    System.out.println( "\nWhat do you want to sniff?");
                    String itemToSniff = sc_dorm.nextLine();
                    peanut.sniff(itemToSniff);
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();
                    break;
                case "drink":
                    peanut.drink();
                    System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();
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
                    responseDorm = sc_dorm.nextLine();
    
                    break;
                case "use":
                    System.out.println( "\nWhat would you like to use?");
                    String itemToUse = sc_dorm.nextLine();
                    peanut.use(itemToUse);
                    peanut.eat();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();                    
                    break;
                case "snooze":
                    peanut.snooze();
                    peanut.eat();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");             
                    responseDorm = sc_dorm.nextLine();
                    break;
                case "undo":
                    peanut.undo();
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();
                    break;
                case "HELP":
                    peanut.HELP();
                    peanut.poop();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();
                    break;
                case "help":
                    peanut.HELP();
                    System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();
                    break;
                case "eat":
                    peanut.eat();
                    System.out.println("\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();
                    break;
                default:
                    System.out.println("\nPlease check your spelling and capitalization. "+responseDorm+" isn't something that you know how to do.\n");
                    System.out.println( "\nWhat would you like to do next? \nPlease enter a new response:");
                    responseDorm = sc_dorm.nextLine();      
            }
        }
        setLocked(false);
        System.out.println(isLocked());
        System.out.println("You've escaped from the dorm room!");
        sc_dorm.close();
}
}

