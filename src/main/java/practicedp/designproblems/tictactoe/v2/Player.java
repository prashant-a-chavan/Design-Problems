package practicedp.designproblems.tictactoe.v2;

public class Player {
    private final String name;
    private final PlayerSymbol playerSymbol;

    public Player(String name, PlayerSymbol playerSymbol) {
        this.name = name;
        this.playerSymbol = playerSymbol;
    }

    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player[" + name + ", Symbol: " + playerSymbol + "]";
    }
}
