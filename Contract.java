public interface Contract {

    void startGame();
    void inventory();
    void grab(String item);
    String drop(String item);
    void sniff(String item);
    void drink();
    boolean roll(int x, int y);
    void climb();
    void use(String item);
    boolean scurry(String direction);
    void eat();
    void poop();
    void snooze();
    void undo();
    void unlockRoom();
    void quitGame();
}
    

