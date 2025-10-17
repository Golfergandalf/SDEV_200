/* Module 8: Final Project - Move
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   Move.java
*/

public enum Move {
    ROCK, PAPER, SCISSORS;

    public static Move getRandomMove() {
        return values()[(int) (Math.random() * values().length)];
    }
}
