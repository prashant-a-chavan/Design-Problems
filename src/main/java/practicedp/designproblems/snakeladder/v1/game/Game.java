package practicedp.designproblems.snakeladder.v1.game;

import practicedp.designproblems.snakeladder.v1.Board;
import practicedp.designproblems.snakeladder.v1.Dice;
import practicedp.designproblems.snakeladder.v1.GameStatus;
import practicedp.designproblems.snakeladder.v1.Player;

import java.util.Queue;

public final class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private GameStatus gameStatus;
    private Player winner;

    Game(GameBuilder gameBuilder) {
        this.board = gameBuilder.getBoard();
        this.players = gameBuilder.getPlayers();
        this.dice = gameBuilder.getDice();
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public void play() {
        this.gameStatus = GameStatus.IN_PROGRESS;
        System.out.println("Game started!");

        while (gameStatus == GameStatus.IN_PROGRESS) {
            Player currentPlayer = players.poll();
            takeTurn(currentPlayer);
            if (gameStatus == GameStatus.IN_PROGRESS) {
                players.add(currentPlayer);
            }
        }

        System.out.println("Game Finished!");
        if (winner != null) {
            System.out.println("The winner is : " + winner.getName());
        }
    }

    private void takeTurn(Player currentPlayer) {
        takeTurn(currentPlayer, 0, currentPlayer.getCurrentPosition());
    }

    private void takeTurn(Player currentPlayer, int consecutiveSixes, int turnStartPosition) {
        String currentPlayerName = currentPlayer.getName();
        int currentPlayerPosition = currentPlayer.getCurrentPosition();
        int boardSize = board.getBoardSize();
        
        int roll = dice.rollDice();
        System.out.println(currentPlayerName + "'s turn. Rolled a " + roll);

        if (shouldForfeitTurn(currentPlayer, consecutiveSixes, turnStartPosition, roll, currentPlayerName)) return;

        int nextPosition = currentPlayerPosition + roll;

        if (hasReachedOverBoardSize(nextPosition, boardSize, currentPlayerName)) return;

        if (hasReachedFinalSquare(currentPlayer, nextPosition, boardSize, currentPlayerName)) return;

        processMove(currentPlayer, nextPosition, currentPlayerName, currentPlayerPosition);

        continueTurnIfSix(currentPlayer, consecutiveSixes, turnStartPosition, roll, currentPlayerName);
    }

    private void continueTurnIfSix(Player currentPlayer, int consecutiveSixes, int turnStartPosition, int roll, String currentPlayerName) {
        if (roll == 6) {
            System.out.println(currentPlayerName + " rolled a 6 and gets another turn!");
            takeTurn(currentPlayer, consecutiveSixes + 1, turnStartPosition);
        }
    }

    private void processMove(Player currentPlayer, int nextPosition, String currentPlayerName, int currentPlayerPosition) {
        int finalPosition = board.getFinalPosition(nextPosition);

        if (finalPosition > nextPosition) {
            System.out.println("Wow! " + currentPlayerName + " found a ladder at " + nextPosition + " and climbed to " + finalPosition);
        } else if (finalPosition < nextPosition) {
            System.out.println("Oh no! " + currentPlayerName + " was bitten by a snake at " + nextPosition + " and slid down to " + finalPosition);
        } else {
            System.out.println(currentPlayerName + " moved from " + currentPlayerPosition + " to " + finalPosition);
        }

        currentPlayer.setCurrentPosition(finalPosition);
    }

    private static boolean hasReachedOverBoardSize(int nextPosition, int boardSize, String currentPlayerName) {
        if (nextPosition > boardSize) {
            System.out.println("Oops," + currentPlayerName + " is trying to move to " + nextPosition + " but, needs to land exactly on " + boardSize + ", Turn skipped.");
            return true;
        }
        return false;
    }

    private boolean hasReachedFinalSquare(Player currentPlayer, int nextPosition, int boardSize, String currentPlayerName) {
        if (nextPosition == boardSize) {
            currentPlayer.setCurrentPosition(nextPosition);
            this.winner = currentPlayer;
            this.gameStatus = GameStatus.COMPLETE;
            System.out.println("Hooray! " + currentPlayerName + " reached the final square and won!!!");
            return true;
        }
        return false;
    }

    private static boolean shouldForfeitTurn(Player currentPlayer, int consecutiveSixes, int turnStartPosition, int roll, String currentPlayerName) {
        if(roll == 6 && consecutiveSixes == 2) {
            currentPlayer.setCurrentPosition(turnStartPosition);
            System.out.println(currentPlayerName + " rolled three 6s in a row. Turn forfeited, back to " + turnStartPosition);
            return true;
        }
        return false;
    }
}

