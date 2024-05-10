import java.util.Scanner;

public class Controller {
    static Peanut peanut = new Peanut();
    static Puzzle puzzleCage = new Puzzle();
    static Puzzle puzzleDormRoom = new Puzzle();
    static Puzzle puzzleCampus = new Puzzle();
    static Room cage = new Room("CAGE", true, puzzleCage);
    static Room dormRoom = new Room("DORM ROOM", true, puzzleDormRoom);
    static Room campus = new Room("SMITH COLLEGE CAMPUS", true, puzzleCampus);
    static boolean puzzleCageSolved = false;
    static boolean puzzleDormRoomSolved = false;
    static boolean puzzleCampusSolved = false;
    static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        peanut.startGame();
    
        CageRoom cageRoom = new CageRoom();
        cageRoom.enterRoom(sc);
    
        DormRoom dormRoom = new DormRoom();
        dormRoom.enterRoom(sc);
    
        CampusRoom campusRoom = new CampusRoom();
        campusRoom.enterRoom(sc);
    
        System.out.println("You've successfully escaped from the campus!");
        peanut.quitGame();
        sc.close();
        }
    }
    