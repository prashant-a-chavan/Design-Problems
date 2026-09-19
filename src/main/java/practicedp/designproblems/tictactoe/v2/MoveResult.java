package practicedp.designproblems.tictactoe.v2;

public class MoveResult {
    private final boolean successful;
    private final GameStatus gameStatus;

    public MoveResult(boolean successful, GameStatus gameStatus) {
        this.successful = successful;
        this.gameStatus = gameStatus;
    }

    public boolean isMoveSuccessful() {
        return successful;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

}
