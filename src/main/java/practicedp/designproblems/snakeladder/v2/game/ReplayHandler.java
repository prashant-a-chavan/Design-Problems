package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.model.Player;
import practicedp.designproblems.snakeladder.v2.rules.TurnContext;

/**
 * Handles REPLAY outcome: player moves normally, then gets another turn.
 */
public final class ReplayHandler implements OutcomeHandler {
    @Override
    public void handle(TurnHandlingContext context) {
        TurnContext turnContext = context.turnContext();
        Player currentPlayer = turnContext.currentPlayer();
        String currentPlayerName = currentPlayer.getName();
        int currentPlayerPosition = turnContext.currentPosition();
        int nextPosition = context.nextPosition();
        int consecutiveSixes = turnContext.consecutiveSixes();
        int turnStartPosition = turnContext.turnStartPosition();

        context.game().processMove(currentPlayer, nextPosition, currentPlayerName, currentPlayerPosition);
        System.out.println(currentPlayerName + " rolled a 6 and gets another turn!");
        context.game().takeTurn(currentPlayer, consecutiveSixes + 1, turnStartPosition);
    }
}


