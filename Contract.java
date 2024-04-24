public interface Contract {

    void startGame();
    void inventory();
    void grab(String item);
    String drop(String item);
    void sniff(String item);
    void drink();
    boolean roll(int x, int y);
    void climb(String item);
    void bite(String item);
    void attack(String item);
    void use(String item);
    boolean scurry(String direction);
    boolean jump(int x, int y);
    Number eat();
    Number poop();
    void snooze();
    void undo();
    void solvePuzzle(String puzzleName, String solution);
    void unlockAchievement(String achievementName);
    void quitGame();
}
    

