import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Puzzle {

    private Map<String, String> puzzles;
    public static void main(String[] args)
    {
    
    
    public Puzzle() {
        puzzles = new HashMap<>();

        // Add gerbil-specific puzzles
        puzzles.put("Under Bed", "Cheese"); // A maze under the bed with a piece of cheese at the end
        puzzles.put("Wheel Rotation", "Spin"); // A puzzle where the gerbil needs to rotate a wheel to open a door
        puzzles.put("Under-The-Bed Tunnel Network", "Burrow"); // A network of tunnels the gerbil needs to navigate to find an exit
    }

    public boolean isSolved(String puzzleName, String solution) {
        return puzzles.containsKey(puzzleName) && puzzles.get(puzzleName).equalsIgnoreCase(solution);
    }

public void maze() {
    //maze.key = {right, left, left, right};
    //String maze = "" ;
    Integer maze_position = 0;
    while (!maze_position.equals(5)) {
        maze_position += 1;
        System.out.println("Where does the gerbil want to go? Left or right?");
        Scanner input = new Scanner(System.in);
        String direction = input.nextLine();
        if (direction.equalsIgnoreCase("right") && maze_position == 1){
            System.out.println("Good choice, you have made it to the next intersection");
            System.out.println("Where does the gerbil want to go? Left or right?");
            maze_position += 1;
        }
        else{
            maze_position -= 1;
        }

            if (direction.equalsIgnoreCase("left") && maze_position == 2){
            System.out.println("Good choice, you have made it to the next intersection");
            System.out.println("Where does the gerbil want to go? Left or right?");
            maze_position += 1;
            }
            else{
            maze_position -= 1;
            }
                if (direction.equalsIgnoreCase("left") && maze_position ==3){
                System.out.println("Good choice, you have made it to the next intersection");
                System.out.println("Where does the gerbil want to go? Left or right?");
                maze_position += 1;
                }
                else{
                maze_position -= 1;
                }
        
                if (direction.equalsIgnoreCase("right") && maze_position ==4){
                    System.out.println("Congrats! You have made it to the end of the maze!");
                    //maze = "Completed!";
                    maze_position +=1;
                }
                else{
                maze_position -= 1;
                }
    input.close();
    }
}

}}
