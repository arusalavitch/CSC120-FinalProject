public class Room {
    private String description;
    private boolean isLocked;
    private Puzzle puzzle;
    
    public Room(String description) {
        this.description = description;
        isLocked = true;
        puzzle = null;
    }
    
    // Getters and setters for description, isLocked, and puzzle
    public String getDescription() {
        return description;
    }
    
    public boolean isLocked() {
        return isLocked;
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
