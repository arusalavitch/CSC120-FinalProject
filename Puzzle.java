import java.util.Scanner;
import java.util.*;

public class Puzzle {

    public boolean isSolved;
    Peanut peanut = new Peanut();


    public boolean setSolved(boolean done){
        isSolved = done;
        return isSolved;
    }

public void maze() {
    
        String[] directions = {"right", "left", "left", "right"};
        int maze_position = 0;
        Scanner input = new Scanner(System.in);

        while (maze_position < directions.length) {
            System.out.println("Where do you want to go? Left or right?");
            String direction = input.nextLine();
            if (direction.equalsIgnoreCase(directions[maze_position])) {
                maze_position++;
                if (maze_position < directions.length) {
                    System.out.println("Good choice, you have made it to the next intersection.");
                } else {
                    System.out.println("Congrats! You have made it to the end of the maze! You found a piece of cheese!");
                    // Implement the inventory method here to add cheese:
                }
            } else if(maze_position>2){
                peanut.attack("mouse");
                System.out.println("Try again!");
            }else{
                System.out.println("Wrong way! Try again please.");
            }
        }

        input.close();
    }

public void wheel() {

    Scanner scanner = new Scanner(System.in);
    int goalRotations = 5; // The wheel needs 5 clockwise rotations to open the door
    int currentRotations = 0;
    boolean wheelStuck = false;

    System.out.println("Open the door by rotating the wheel!");
    System.out.println("Spin the wheel 5 times to unlock the door.");

    while (currentRotations < goalRotations) {
        System.out.print("Enter rotation direction ('clockwise' or 'counterclockwise'): ");
        String direction = scanner.nextLine();

        if (direction.equalsIgnoreCase("clockwise")) {
            currentRotations++;
            System.out.println("Good! " + (goalRotations - currentRotations) + " more rotations needed.");
            if (currentRotations == goalRotations - 1) {
                wheelStuck = true;
                break;
            }
        } else if (direction.equalsIgnoreCase("counterclockwise")) {
            currentRotations = Math.max(0, currentRotations - 1); // Prevent negative rotations
            System.out.println("Oh no! The wheel moved in the wrong direction. Now you need " +
                               (goalRotations - currentRotations) + " more rotations.\n");
            
        } else {
            System.out.println("Invalid input. Please enter 'clockwise' or 'counterclockwise'.\n");
        }
    }

    if (wheelStuck) {
        System.out.println("Oh no!! \nThe wheel gets caught on the last rotation and you're too tired to push through!");
        System.out.println("You need to eat to gain strength before trying again. \n");

        boolean hasEaten = false;
        while (!hasEaten) {
            System.out.print("What would you like to do next? ");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("eat")) {
                System.out.println("\nYou look around for something to eat...");
                System.out.println("\nYou find a nut and have a tasty treat.");
                System.out.println("Time for the last push! You hop on the wheel one last time.");
                hasEaten = true;
            } else {
                System.out.println("Invalid input. Please check your campitalization and enter 'eat'.\n");
            }
        }
      
        System.out.print("Enter rotation direction ('clockwise' or 'counterclockwise'): ");
        String direction = scanner.nextLine();
    
            if (direction.equalsIgnoreCase("clockwise")) {
                System.out.println("Congratulations!");
            }else if (direction.equalsIgnoreCase("counterclockwise")) {
                System.out.println("Oh no! The wheel moved in the wrong direction. Now you need 2 more rotations.\n");
                
            } else {
                System.out.println("Invalid input. Please enter 'clockwise' or 'counterclockwise'.\n");
            }
            }
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

    System.out.println("Find your way out of these tunnels, you don't want to miss the graduation ceremony!");
    while (!tunnels.get(currentTunnel).equals("Exit Tunnel")) {
        System.out.println("You are in " + tunnels.get(currentTunnel) + ". There are exits to the following tunnels:");
        peanut.attack("mouse");
        for (int exit : exits[currentTunnel]) {
            System.out.println((exit + 1) + ": " + tunnels.get(exit));
        }

        System.out.print("Which tunnel do you want to enter? Choose a number: ");
        int choice = scanner.nextInt() - 1; // Convert to 0-based index
        peanut.attack("mouse");

        if (choice >= 0 && contains(exits[currentTunnel], choice)) {
            currentTunnel = choice;
        } else {
            System.out.println("Invalid choice, try again.");
        }
    }

    System.out.println("Congratulations! You have escaped the tunnels!");
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
       


   
    

    