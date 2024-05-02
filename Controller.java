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

        System.out.println("What would you like to do first?");
        String response = sc.nextLine();

        ArrayList <String> commands = new ArrayList <String>();
        commands.add("inventory");
        commands.add("grab");
        commands.add("drop");
        commands.add("sniff");
        commands.add("drink");
        commands.add("roll");
        commands.add("climb");
        commands.add("bite");
        commands.add("attack");
        commands.add("use");
        commands.add("scurry");
        commands.add("jump");
        commands.add("eat");
        commands.add("poop");
        commands.add("snooze");
        commands.add("undo");
        commands.add("solvePuzzle");
        commands.add("unlockRoom");
    

        if (commands.contains(response)){
            switch (response) {
                case "inventory":
                    System.out.println(peanut.inventory);
                    break;
                case "grab":
                    System.out.println("What do you want to grab?");
                    String response1 = sc.nextLine();
                    System.out.print(peanut.grab(response1));
                    break;
                case "drop":
                    words[i] = "are";
                    break;
                case "sniff":
                    words[i] = "I";
                    break;
                case "drink":
                    words[i] = "your";
                    break;
                case "roll":
                    words[i] = "my";
                    break;
                case "climb":
                    words[i] = "I'm";
                    break;
                case "bite":
                    words[i] = "you're";
                    break;
                case "attack":
                    words[i] = "am";
                    break;
                case "use":
                    words[i] = "I'm";
                    break;
                case "scurry":
                    words[i]="I?";
                    break;
                case "jump":
                    words[i]="you?";
                    break;
                case "eat":
                    words[i]="you?";
                    break;
                case "poop":
                    words[i]="yourself";
                    break;
                case "snooze":
                    words[i]="yourself";
                    break;
                case "undo":
                    words[i]="yourself";
                    break;
                case "solvePuzzle":
                    words[i]="yourself";
                    break;
                case "unlockRoom":
                    words[i]="yourself";
                    break;
            }
        }
        







        // Mirroring words
            for (int i = 0; i < response.length; i++) {
                
            }







    }

    
}


   