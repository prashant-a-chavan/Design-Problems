package practicedp.designproblems.tictactoe.v2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private final Board board;
    private final Player[] players;
    private GameStatus gameStatus;
    private int currentPlayerIndex;
    private final Scanner scanner;

    public Game(Player[] players, int size) {
        validatePlayers(players);
        validateBoardSize(size);
        this.players = players;
        this.board = new Board(size);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.currentPlayerIndex = 0;
        this.scanner = new Scanner(System.in);
    }

    private void validateBoardSize(int size) {
        if (size < 3) throw new InvalidInput("Invalid Board Size, should be at least 3");
    }

    private void validatePlayers(Player[] players) {
        for (Player player : players) {
            if (player.getPlayerSymbol() == null || player.getName() == null || player.getPlayerSymbol().equals(PlayerSymbol.EMPTY)) {
                throw new InvalidInput("Invalid Player Details...!");
            }
        }

        Set<PlayerSymbol> uniqueSymbols = Arrays.stream(players).map(Player::getPlayerSymbol).collect(Collectors.toSet());
        if (uniqueSymbols.size() < players.length) {
            throw new InvalidInput("Players symbol must be unique!");
        }
    }

    public void start() {
        while (gameStatus.equals(GameStatus.IN_PROGRESS)) {
            Player player = makeMove();
            if (gameStatus.equals(GameStatus.COMPLETE)) {
                System.out.println("Player: " + player + " is the winner");
            }
        }
        if (gameStatus.equals(GameStatus.DRAW)) {
            System.out.println("Game is DRAW!");
        }
    }

    private Player makeMove() {
        Player player = getCurrentTurnPlayer();
        int[] rowColInput = getUserInput(player.getPlayerSymbol());
        MoveResult moveResult = board.placeSymbol(player.getPlayerSymbol(), rowColInput[0], rowColInput[1]);

        if (!moveResult.isMoveSuccessful()) {
            System.out.println("Invalid move! please try again");
            makeMove();
        }
        gameStatus = moveResult.getGameStatus();

        switchPlayerTurn();
        return player;
    }

    private void switchPlayerTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    private int[] getUserInput(PlayerSymbol playerSymbol) {
        System.out.print("Turn : " + playerSymbol + " Enter [row col] value: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    private Player getCurrentTurnPlayer() {
        return players[currentPlayerIndex];
    }

}
