package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.model.Board;
import practicedp.designproblems.snakeladder.v2.model.Dice;
import practicedp.designproblems.snakeladder.v2.model.GameStatus;
import practicedp.designproblems.snakeladder.v2.model.Player;
import practicedp.designproblems.snakeladder.v2.rules.BounceBackRule;
import practicedp.designproblems.snakeladder.v2.rules.MoveOutcome;
import practicedp.designproblems.snakeladder.v2.rules.MoveRule;
import practicedp.designproblems.snakeladder.v2.rules.TurnContext;

import java.util.List;
import java.util.Queue;

public final class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private final List<MoveRule> rules;
    private final TurnOutcomeDispatcher outcomeDispatcher;
    private GameStatus gameStatus;
    private Player winner;

    Game(GameBuilder gameBuilder) {
        this.board = gameBuilder.getBoard();
        this.players = gameBuilder.getPlayers();
        this.dice = gameBuilder.getDice();
        this.rules = gameBuilder.getRules();
        this.outcomeDispatcher = new TurnOutcomeDispatcher();
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

    void takeTurn(Player currentPlayer, int consecutiveSixes, int turnStartPosition) {
        String currentPlayerName = currentPlayer.getName();
        int currentPlayerPosition = currentPlayer.getCurrentPosition();
        int boardSize = board.getBoardSize();

        int roll = dice.rollDice();
        System.out.println(currentPlayerName + "'s turn. Rolled a " + roll);

        TurnContext turnContext = new TurnContext(currentPlayer, currentPlayerPosition, roll, boardSize, consecutiveSixes, turnStartPosition, board);

        MoveOutcome moveOutcome = applyRules(turnContext);
        int nextPosition = resolveNextPosition(turnContext);

        TurnHandlingContext handlingContext = new TurnHandlingContext(this, turnContext, nextPosition);

        outcomeDispatcher.handle(moveOutcome, handlingContext);
    }

    void processMove(Player currentPlayer, int nextPosition, String currentPlayerName, int currentPlayerPosition) {
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

    void declareWinner(Player player) {
        this.winner = player;
        this.gameStatus = GameStatus.COMPLETE;
    }

    private MoveOutcome applyRules(TurnContext turnContext) {
        for (MoveRule rule : rules) {
            MoveOutcome moveOutcome = rule.apply(turnContext);
            if (moveOutcome != MoveOutcome.CONTINUE) {
                return moveOutcome;
            }
        }
        return MoveOutcome.CONTINUE;
    }

    private int resolveNextPosition(TurnContext turnContext) {
        int nextPosition = turnContext.nextPosition();
        int boardSize = turnContext.boardSize();

        if (nextPosition > boardSize && hasRule(BounceBackRule.class)) {
            int overshoot = nextPosition - boardSize;
            return boardSize - overshoot;
        }

        return nextPosition;
    }

    private boolean hasRule(Class<? extends MoveRule> ruleType) {
        for (MoveRule rule : rules) {
            if (ruleType.isInstance(rule)) {
                return true;
            }
        }
        return false;
    }
}

