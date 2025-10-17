/* Module 8: Final Project - Player
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   Player.java
*/

public class Player {
    private String playerName;
    private Move moveChoice;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Move getMoveChoice() {
        return moveChoice;
    }

    public void setMoveChoice(Move moveChoice) {
        this.moveChoice = moveChoice;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }
}
