public class Room {
    private String name;
    private boolean isLocked;
    private Puzzle puzzle;
    
    public Room(String name, boolean isLocked, Puzzle puzzle) {
        this.name = name;
        isLocked = true;
        puzzle = null;
    }
    
    // Getters and setters for description, isLocked, and puzzle
    public String getDescription() {
        return "You are currently in your "+name+".";
    }
    
    public String isLocked() {
        if (isLocked){
            return "The "+name+ " is currently locked";
        }else{
            return "You've unlocked the "+name+".";
        }
    }
    
    public void setLocked(boolean locked) {
        isLocked = locked;
    }
    
    public Puzzle getPuzzle() {
        return puzzle;
    }
    
    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
}
