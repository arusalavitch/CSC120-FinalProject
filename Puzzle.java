import java.util.HashMap;
import java.util.Map;

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
}
