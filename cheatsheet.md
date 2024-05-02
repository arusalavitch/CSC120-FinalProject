This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

Possible commands Peanut can use:
    grab(String item);
    drop(String item);
    sniff(String item);
    drink();
    roll(int x, int y);
    climb();
    use(String item);
    eat();
    poop();
    snooze();
    undo();
    unlockRoom();

Challenges:
    If command climb is used while Gerbil is exploring the cage:
        - Gerbil is introduced to the first puzzle that needs to be solved to escape: Cage Door Lock Wheel Puzzle
        - This puzzle requires the gerbil to spin its wheel 5 times counterclockwise to unlock the lock

    If gerbil escapes the cage and command solve is implemented:
        - Gerbil is introduced to the second puzzle: Dorm Maze Puzzle
        - This puzzle has a series of directions that need to be taken in order to successfully make it through : ("right", "left", "left", "right")

    If gerbil escapes from the dorm room and command solve is implemented:
        - Gerbil has to complete the final puzzle to successfully win the game: Tunnel Puzzel
        - Once this puzzle is solved, the Gerbil has successfully escaped campus and won the game!
    