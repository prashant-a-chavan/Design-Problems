package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.model.Player;
import practicedp.designproblems.snakeladder.v2.rules.TurnContext;

/**
 * Handles WIN outcome: player reached final square and won.
 */
public final class WinHandler implements OutcomeHandler {
    @Override
    public void handle(TurnHandlingContext context) {
        TurnContext turnContext = context.turnContext();
        Player currentPlayer = turnContext.currentPlayer();
        String currentPlayerName = currentPlayer.getName();
        int currentPlayerPosition = turnContext.currentPosition();
        int nextPosition = context.nextPosition();

        context.game().processMove(currentPlayer, nextPosition, currentPlayerName, currentPlayerPosition);
        context.game().declareWinner(currentPlayer);
        System.out.println("Hooray! " + currentPlayerName + " reached the final square and won!!!");
    }
}


