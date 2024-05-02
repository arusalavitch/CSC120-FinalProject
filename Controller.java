import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller {
    static Peanut peanut = new Peanut();
    static Puzzle puzzleCage = new Puzzle();
    static Room cage = new Room( "Cage", true, puzzleCage);
    ArrayList <String> commands = new ArrayList <String>();
    
    

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        peanut.startGame();

        System.out.println(cage.getDescription());
        System.out.println(cage.isLocked());

        System.out.println("What would you like to do first? All of the commands should be entered in lowercase please.");
        String response = sc.nextLine();

        ArrayList <String> commands = new ArrayList <String>();
        commands.add("inventory");
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
    

        if (commands.contains(response)){
            switch (response) {
                case "inventory":
                    System.out.println(peanut.inventory);
                    break;
                case "grab":
                    System.out.println("What do you want to grab?");
                    String response1 = sc.nextLine();
                    peanut.poop();
                    peanut.grab(response1);
                    System.out.println(response1+" has been added to your inventory!");
                    break;
                case "drop":
                    System.out.println("What do you want to drop from your inventory?");
                    String response2 = sc.nextLine();
                    if (response2 != null) {
                        System.out.print(peanut.drop(response2));
                    } else {
                        System.out.println("You don't have " + response2 + " in your inventory.");
                    }
                    break;
                case "sniff":
                    System.out.println("What do you want to sniff?");
                    String response3 = sc.nextLine();
                    peanut.sniff(response3);
                    peanut.poop();
                    break;
                case "drink":
                    peanut.drink();
                    break;
                case "roll":
                    System.out.println("Where do you want to roll? Please give me an integer 'x' coordinate.");
                    int x_coord = sc.nextInt();
                    System.out.println("Now please give me an integer 'y' coordinate.");
                    int y_coord = sc.nextInt();
                    peanut.roll (x_coord,y_coord);
                    break;
                    case "climb":
                        peanut.climb();
                        System.out.println("In the distance, you see the puzzle you must solve...");
                        System.out.println("The lock on your cage has somehow been connected to your wheel.\nIn order to open the cage, you must solve the puzzle.");
                        System.out.println("Would you like to solve the puzzle now or keep moving around the cage? Please enter 'Puzzle' or 'Cage' to indicate what you would like to do next.");
                        String response4 = sc.nextLine();
                        peanut.poop();
                        if (response4.equalsIgnoreCase("Puzzle")) {
                            System.out.println("Attempting to solve the puzzle...");
                            String solution = sc.nextLine();
                            cage.getPuzzle().wheel();
                            cage.setLocked(false);
                            System.out.println("Congratulations! You solved the puzzle and unlocked the cage!");
                            break;
                    } else if (response4.equalsIgnoreCase("Cage")) {
                        System.out.println("You decide to explore more of the cage.");
                        peanut.poop();
                        break;
                    } else {
                        System.out.println("Invalid response. Please enter 'Puzzle' or 'Cage'.");
                        peanut.poop();
                    }
                    break;
                case "use":
                    peanut.poop();
                    System.out.println("What would you like to use?");
                    String response5 = sc.nextLine();
                    if (response5 != null) {
                        peanut.use(response5);
                    } else {
                        System.out.println("You don't have " + response5+ " in your inventory.");
                    }
                    break;
                case "scurry":
                    System.out.println("Where are you scurrying?");
                    String response6 = sc.nextLine();
                    if (response6.equalsIgnoreCase("left") || response6.equalsIgnoreCase("right")){
                        peanut.scurry(response6);
                        peanut.poop();
                    }else{
                        System.out.println("That's not a valid direction. Please enter 'Left' or 'Right'");
                        peanut.poop();
                    }
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
        }else{
            peanut.poop();
            System.out.println("Please check your spelling and capitalization. That isn't something that you know how to do.");
        }

        System.out.println("What would you like to do next? Remember, all of the commands should be entered in lowercase please.");
        String response7 = sc.nextLine();
        System.out.println("Would you like to solve the puzzle now or keep moving around the cage? Please enter 'Puzzle' or 'Cage' to indicate what you would like to do next.");
                        String response4 = sc.nextLine();
                        peanut.poop();
                        if (response4.equalsIgnoreCase("Puzzle")) {
                            System.out.println("Attempting to solve the puzzle...");
                            String solution = sc.nextLine();
                            cage.getPuzzle().wheel();
                            cage.setLocked(false);
                            System.out.println("Congratulations! You solved the puzzle and unlocked the cage!");
                            break;

        













    }

    
}


   