import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller {
    static Peanut peanut = new Peanut();
    static Puzzle puzzleCage = new Puzzle();
    static Room cage = new Room( "Cage", true, puzzleCage);
    ArrayList commands = new ArrayList();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        peanut.startGame();

        System.out.println(cage.getDescription());
        System.out.println(cage.isLocked());

        System.out.println("What would you like to do first?");
        String response = sc.nextLine();
        // Mirroring words
            for (int i = 0; i < response.length; i++) {
                switch (words[i]) {
                    case "I":
                        words[i] = "you";
                        break;
                    case "me":
                        words[i] = "you";
                        break;
                    case "am":
                        words[i] = "are";
                        break;
                    case "you":
                        words[i] = "I";
                        break;
                    case "my":
                        words[i] = "your";
                        break;
                    case "your":
                        words[i] = "my";
                        break;
                    case "You're":
                        words[i] = "I'm";
                        break;
                    case "I'm":
                        words[i] = "you're";
                        break;
                    case "are":
                        words[i] = "am";
                        break;
                    case "you're":
                        words[i] = "I'm";
                        break;
                    case "you?":
                        words[i]="I?";
                        break;
                    case "me?":
                        words[i]="you?";
                        break;
                    case "I?":
                        words[i]="you?";
                        break;
                    case "myself":
                        words[i]="yourself";
                        break;
                }
            }







    }

    
}


   