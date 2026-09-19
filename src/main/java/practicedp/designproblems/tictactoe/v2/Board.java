package practicedp.designproblems.tictactoe.v2;

public class Board {
    private final Cell[][] grid;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        initializeBoard();
    }

    public MoveResult placeSymbol(PlayerSymbol playerSymbol, int row, int col) {
        if (!grid[row][col].isCellEmpty() || !isValidPayload(row, col)) return new MoveResult(false, null);

        grid[row][col].setPlayerSymbol(playerSymbol);
        return checkWin(playerSymbol, row, col);
    }

    private MoveResult checkWin(PlayerSymbol playerSymbol, int row, int col) {
        if (isRowWinning(playerSymbol, row) || isColWinning(playerSymbol, col) || isDiagonalWinning(playerSymbol, row, col) || isAntiDiagonalWinning(playerSymbol, row, col)) {
            return new MoveResult(true, GameStatus.COMPLETE);
        }
        if (isBoardFull()) return new MoveResult(true, GameStatus.DRAW);
        return new MoveResult(true, GameStatus.IN_PROGRESS);
    }

    private boolean isAntiDiagonalWinning(PlayerSymbol playerSymbol, int row, int col) {
        if (row + col != size - 1) return false;
        for (int i = 0; i < size; i++) {
            if (!grid[i][size-i-1].getPlayerSymbol().equals(playerSymbol)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalWinning(PlayerSymbol playerSymbol, int row, int col) {
        if (row != col) return false;
        for (int i = 0; i < size; i++) {
            if(!grid[i][i].getPlayerSymbol().equals(playerSymbol)) {
                return false;
            }
        }
        return true;
    }

    private boolean isColWinning(PlayerSymbol playerSymbol, int col) {
        for (int i = 0; i < size; i++) {
            if (!grid[i][col].getPlayerSymbol().equals(playerSymbol)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRowWinning(PlayerSymbol playerSymbol, int row) {
        for (int i = 0; i < size; i++) {
            if(!grid[row][i].getPlayerSymbol().equals(playerSymbol)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPayload(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isCellEmpty())
                    return false;
            }
        }
        return true;
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

}
