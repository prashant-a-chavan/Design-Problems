package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.entities.BoardEntity;
import practicedp.designproblems.snakeladder.v2.model.Board;
import practicedp.designproblems.snakeladder.v2.model.Dice;
import practicedp.designproblems.snakeladder.v2.model.Player;
import practicedp.designproblems.snakeladder.v2.rules.ExactLandingRule;
import practicedp.designproblems.snakeladder.v2.rules.ExtraTurnRule;
import practicedp.designproblems.snakeladder.v2.rules.MoveRule;
import practicedp.designproblems.snakeladder.v2.rules.ThreeSixesRule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameBuilder {
    private Board board;
    private Queue<Player> players;
    private Dice dice;
    private List<MoveRule> rules;

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

    public GameBuilder rules(List<MoveRule> rules) {
        this.rules = new ArrayList<>(rules);
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

    List<MoveRule> getRules() {
        return rules;
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

        // Set default rules if not provided
        if (rules == null) {
            rules = List.of(
                    new ThreeSixesRule(),
                    new ExactLandingRule(),
                    new ExtraTurnRule()
            );
        }
    }
}
