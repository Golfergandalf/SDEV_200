/* Module 8: Final Project - Game
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   Game.java
*/

public class Game {
    private Player player;
    private Player computer;

    public Game(String playerName) {
        player = new Player(playerName);
        computer = new Player("Computer");
    }

    public String playRound(Move playerMove) {
        player.setMoveChoice(playerMove);
        Move computerMove = Move.getRandomMove();
        computer.setMoveChoice(computerMove);

        String result = determineWinner(playerMove, computerMove);
        return String.format("You chose %s | Computer chose %s\n%s",
                playerMove, computerMove, result);
    }

    private String determineWinner(Move pMove, Move cMove) {
        if (pMove == cMove) return "It's a tie!";
        switch (pMove) {
            case ROCK:
                if (cMove == Move.SCISSORS) {
                    player.incrementScore();
                    return "Rock beats Scissors — You win!";
                }
                break;
            case PAPER:
                if (cMove == Move.ROCK) {
                    player.incrementScore();
                    return "Paper beats Rock — You win!";
                }
                break;
            case SCISSORS:
                if (cMove == Move.PAPER) {
                    player.incrementScore();
                    return "Scissors beats Paper — You win!";
                }
                break;
        }
        computer.incrementScore();
        return "You lose!";
    }

    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }
}
