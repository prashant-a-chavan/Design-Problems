package practicedp.designproblems.tictactoe;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player[] players;
    private GameStatus gameStatus;

    public void start(String player1, String player2, int boardSize) {
        validatePlayersAndBoardSize(player1, player2, boardSize);
        setUpBoardAndPlayers(player1, player2, boardSize);

        System.out.println("========== TIC TAC TOE ==========");

        int currentPlayerIndex = 0;
        while (gameStatus.equals(GameStatus.IN_PROGRESS)) {
            System.out.println("Current Player: " + players[currentPlayerIndex].getName() + " (" + players[currentPlayerIndex].getSymbol().getDisplayChar() + ")");
            System.out.println("Enter your move (row and column): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            makeMove(row, col, currentPlayerIndex);
            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        }

        System.out.println("Result: " + getGameStatus());
        Player winner = getWinner();
        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        }
    }

    private void validatePlayersAndBoardSize(String player1, String player2, int boardSize) {
        if (player1.trim().isEmpty() || player2.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid player name!");
        }
        if (boardSize <= 0) {
            throw new IllegalArgumentException("Invalid board size!");
        }
    }

    private void makeMove(int row, int col, int currentPlayerIndex) {
        if (!gameStatus.equals(GameStatus.IN_PROGRESS)) {
            throw new InvalidMoveException("Game is already over!");
        }

        if (!board.isCellEmpty(row, col)) {
            throw new InvalidMoveException("Cell (" + row + "," + col + ") is already occupied.");
        }

        Player currentPlayer = players[currentPlayerIndex];
        board.placeSymbol(row, col, currentPlayer.getSymbol());

        if (checkWin(row, col, currentPlayer.getSymbol())) {
            gameStatus = (currentPlayer.getSymbol().equals(Symbol.X)) ? GameStatus.WINNER_X : GameStatus.WINNER_O;
            return;
        }

        if (board.isFull()) {
            gameStatus = GameStatus.DRAW;
        }
    }

    private boolean checkWin(int row, int col, Symbol symbol) {
        int size = board.getSize();

        return isRowWinning(row, symbol, size) || isColumnWinning(col, symbol, size) ||
                isDiagonalWinning(row, col, symbol, size) || isAntiDiagonalWinning(row, col, symbol, size);
    }

    private boolean isAntiDiagonalWinning(int row, int col, Symbol symbol, int size) {
        if (row + col != size - 1) return false;

        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, size - 1 - i).getSymbol() != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }

    private boolean isDiagonalWinning(int row, int col, Symbol symbol, int size) {
        if (row != col) return false;

        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i).getSymbol() != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }

    private boolean isColumnWinning(int col, Symbol symbol, int size) {
        boolean win = true;

        for (int r = 0; r < size; r++) {
            if (board.getCell(r, col).getSymbol() != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }

    private boolean isRowWinning(int row, Symbol symbol, int size) {
        boolean win = true;
        for (int c = 0; c < size; c++) {
            if (board.getCell(row, c).getSymbol() != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }

    private void setUpBoardAndPlayers(String player1, String player2, int boardSize) {
        Player player1Obj = new Player(player1, Symbol.X);
        Player player2Obj = new Player(player2, Symbol.O);

        this.board = new Board(boardSize);
        this.players = new Player[]{player1Obj, player2Obj};
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    private GameStatus getGameStatus() {
        return gameStatus;
    }

    private Player getWinner() {
        if (gameStatus == GameStatus.WINNER_X) {
            return players[0].getSymbol() == Symbol.X ? players[0] : players[1];
        } else if (gameStatus == GameStatus.WINNER_O) {
            return players[0].getSymbol() == Symbol.O ? players[0] : players[1];
        }
        return null;
    }
}
