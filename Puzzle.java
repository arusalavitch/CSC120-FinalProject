import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Puzzle {

    private Map<String, String> puzzles;
   
    
    
    
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
    
        String[] directions = {"right", "left", "left", "right"};
        int maze_position = 0;
        Scanner input = new Scanner(System.in);

        while (maze_position < directions.length) {
            System.out.println("Where does the gerbil want to go? Left or right?");
            String direction = input.nextLine();
            if (direction.equalsIgnoreCase(directions[maze_position])) {
                maze_position++;
                if (maze_position < directions.length) {
                    System.out.println("Good choice, you have made it to the next intersection");
                } else {
                    System.out.println("Congrats! You have made it to the end of the maze! You found a piece of cheese!");
                    // Implement the inventory method here to add cheese:
                }
            } else {
                System.out.println("Oops! Wrong way. Try again!");
            }
        }

        input.close();
    }

public void wheel() {

    Scanner scanner = new Scanner(System.in);
    int goalRotations = 5; // The wheel needs 5 clockwise rotations to open the door
    int currentRotations = 0;

    System.out.println("Help the gerbil open the door by rotating the wheel!");
    System.out.println("Spin the wheel clockwise 5 times to unlock the door.");

    while (currentRotations < goalRotations) {
        System.out.print("Enter rotation direction ('clockwise' or 'counterclockwise'): ");
        String direction = scanner.nextLine();

        if (direction.equalsIgnoreCase("clockwise")) {
            currentRotations++;
            System.out.println("Good! " + (goalRotations - currentRotations) + " more clockwise rotations needed.");
        } else if (direction.equalsIgnoreCase("counterclockwise")) {
            currentRotations = Math.max(0, currentRotations - 1); // Prevent negative rotations
            System.out.println("Oh no! The wheel moved in the wrong direction. Now you need " +
                               (goalRotations - currentRotations) + " more clockwise rotations.");
        } else {
            System.out.println("Invalid input. Please enter 'clockwise' or 'counterclockwise'.");
        }
    }

    System.out.println("Congratulations! The door is unlocked, and the gerbil can escape.");
    scanner.close();
}

public void navigateTunnels() {
    Scanner scanner = new Scanner(System.in);
    
    // Tunnels identified by their names
    List<String> tunnels = new ArrayList<>();
    tunnels.add("Tunnel 1"); // index 0
    tunnels.add("Tunnel 2"); // index 1
    tunnels.add("Tunnel 3"); // index 2
    tunnels.add("Exit Tunnel"); // index 3
    
    // Connections between tunnels represented as adjacency matrix or similar structure
    int[][] exits = new int[][]{
        {1, 2},    // Exits from Tunnel 1
        {0, 3},    // Exits from Tunnel 2
        {0},       // Exits from Tunnel 3
        {}         // Exits from Exit Tunnel
    };
    
    int currentTunnel = 0; // Starting at Tunnel 1

    System.out.println("Help the gerbil find the exit of this Under-The-Bed Tunnel Network!");
    while (!tunnels.get(currentTunnel).equals("Exit Tunnel")) {
        System.out.println("You are in " + tunnels.get(currentTunnel) + ". There are exits to the following tunnels:");

        for (int exit : exits[currentTunnel]) {
            System.out.println((exit + 1) + ": " + tunnels.get(exit));
        }

        System.out.print("Which tunnel do you want to enter? Choose a number: ");
        int choice = scanner.nextInt() - 1; // Convert to 0-based index

        if (choice >= 0 && contains(exits[currentTunnel], choice)) {
            currentTunnel = choice;
        } else {
            System.out.println("Invalid choice, try again.");
        }
    }

    System.out.println("Congratulations! You've helped the gerbil find the exit of this Under-The-Bed Tunnel Network.");
    scanner.close();
}

private boolean contains(int[] array, int value) {
    for (int i : array) {
        if (i == value) {
            return true;
        }
    }
    return false;
}
}
       


   
    

    