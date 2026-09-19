package practicedp.designproblems.tictactoe.v2;

public class Cell {
    private PlayerSymbol playerSymbol;

    public Cell() {
        this.playerSymbol = PlayerSymbol.EMPTY;
    }

    public boolean isCellEmpty() {
        return playerSymbol.equals(PlayerSymbol.EMPTY);
    }

    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(PlayerSymbol playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}
