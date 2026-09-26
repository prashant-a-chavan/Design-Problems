package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.model.Player;
import practicedp.designproblems.snakeladder.v2.rules.TurnContext;

/**
 * Handles FORFEIT outcome: player returns to turn start position.
 */
public final class ForfeitHandler implements OutcomeHandler {
    @Override
    public void handle(TurnHandlingContext context) {
        TurnContext turnContext = context.turnContext();
        Player currentPlayer = turnContext.currentPlayer();
        String currentPlayerName = currentPlayer.getName();
        int turnStartPosition = turnContext.turnStartPosition();

        currentPlayer.setCurrentPosition(turnStartPosition);
        System.out.println(currentPlayerName + " rolled three 6s in a row. Turn forfeited, back to " + turnStartPosition);
    }
}



