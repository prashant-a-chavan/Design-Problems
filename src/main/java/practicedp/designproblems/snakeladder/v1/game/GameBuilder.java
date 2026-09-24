package practicedp.designproblems.snakeladder.v1.game;

import practicedp.designproblems.snakeladder.v1.Board;
import practicedp.designproblems.snakeladder.v1.BoardEntity;
import practicedp.designproblems.snakeladder.v1.Dice;
import practicedp.designproblems.snakeladder.v1.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameBuilder {
    private Board board;
    private Queue<Player> players;
    private Dice dice;

    public GameBuilder board(int boardSize, List<BoardEntity> boardEntities) {
        this.board = Board.createBoard(boardSize, boardEntities);
        return this;
    }

    public GameBuilder players(List<String> playerNames) {
        this.players = new LinkedList<>();
        for (String playerName : playerNames) {
            this.players.add(new Player(playerName));
        }
        return this;
    }

    public GameBuilder dice(Dice dice) {
        this.dice = dice;
        return this;
    }

    public Game build() {
        validateBuilder();
        return new Game(this);
    }

    Board getBoard() {
        return board;
    }

    Queue<Player> getPlayers() {
        return players;
    }

    Dice getDice() {
        return dice;
    }

    private void validateBuilder() {
        if (board == null) {
            throw new IllegalStateException("Board is required");
        }
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("At least one player is required");
        }
        if (dice == null) {
            throw new IllegalStateException("Dice is required");
        }
    }
}
