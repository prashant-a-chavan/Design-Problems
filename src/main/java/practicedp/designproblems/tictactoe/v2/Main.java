package practicedp.designproblems.tictactoe.v2;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[]{new Player("Prashant", PlayerSymbol.X),
                new Player("Sagar", PlayerSymbol.O)};

        Game game = new Game(players, 3);
        game.start();
    }
}
