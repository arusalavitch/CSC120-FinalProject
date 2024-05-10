import java.util.Scanner;

/**
 * Controls the flow of the game.
 */
public class Controller {
    // Instances of Peanut, Puzzle, and Room
    static Peanut peanut = new Peanut();
    static Puzzle puzzleCage = new Puzzle();
    static Puzzle puzzleDormRoom = new Puzzle();
    static Puzzle puzzleCampus = new Puzzle();
    static Room cage = new Room("CAGE", true, puzzleCage);
    static Room dormRoom = new Room("DORM ROOM", true, puzzleDormRoom);
    static Room campus = new Room("SMITH COLLEGE CAMPUS", true, puzzleCampus);
    
    // Flags to track puzzle solving status
    static boolean puzzleCageSolved = false;
    static boolean puzzleDormRoomSolved = false;
    static boolean puzzleCampusSolved = false;
    
    static Scanner sc = new Scanner(System.in);

    /**
     * Entry point of the game.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        peanut.startGame();

        // Enter cage room
        CageRoom cageRoom = new CageRoom();
        cageRoom.enterRoom(sc);

        // Enter dorm room
        DormRoom dormRoom = new DormRoom();
        dormRoom.enterRoom(sc);

        // Enter campus room
        CampusRoom campusRoom = new CampusRoom();
        campusRoom.enterRoom(sc);

        // Successful escape message
        System.out.println("You've successfully escaped from the campus!");

        // Quit the game
        peanut.quitGame();
        sc.close();
    }
}
