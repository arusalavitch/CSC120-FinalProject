/**
 * Represents a room in a game.
 * Each room has a name, lock status, and a puzzle.
 */
public class Room {

    // Fields
    private String name;
    private boolean isLocked;
    private Puzzle puzzle;
    
    /**
     * Constructs a room with the given name, lock status, and puzzle.
     * 
     * @param name The name of the room.
     * @param isLocked The lock status of the room.
     * @param puzzle The puzzle associated with the room.
     */
    public Room(String name, boolean isLocked, Puzzle puzzle) {
        this.name = name;
        this.isLocked = isLocked;
        this.puzzle = puzzle;
    }
    
    // Getters and setters
    
    /**
     * Gets the description of the room.
     * 
     * @return The description of the room.
     */
    public String getDescription() {
        return "You are currently in the " + name + ".";
    }
    
    /**
     * Checks if the room is locked.
     * 
     * @return A message indicating the lock status of the room.
     */
    public String isLocked() {
        if (isLocked) {
            return "The " + name + " is LOCKED.";
        } else {
            return "You've UNLOCKED the " + name + "!!";
        }
    }
    
    /**
     * Sets the lock status of the room.
     * 
     * @param locked The lock status to set.
     */
    public void setLocked(boolean locked) {
        isLocked = locked;
    }
    
    /**
     * Gets the puzzle associated with the room.
     * 
     * @return The puzzle associated with the room.
     */
    public Puzzle getPuzzle() {
        return puzzle;
    }
    
    /**
     * Sets the puzzle associated with the room.
     * 
     * @param puzzle The puzzle to set.
     */
    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
}
