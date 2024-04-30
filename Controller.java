public class Controller {
    static Peanut peanut = new Peanut();
    static Puzzle puzzleCage = new Puzzle();
    static Room cage = new Room( "Cage", true, puzzleCage);

    public static void main(String[] args){
        peanut.startGame();
        cage.getDescription();
        cage.getPuzzle();
        cage.isLocked();

    }

    
}


   