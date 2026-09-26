package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.rules.TurnContext;

/**
 * Handles SKIP outcome: player stays at current position.
 */
public final class SkipHandler implements OutcomeHandler {
    @Override
    public void handle(TurnHandlingContext context) {
        TurnContext turnContext = context.turnContext();
        int nextPosition = context.nextPosition();
        int boardSize = turnContext.boardSize();
        String currentPlayerName = turnContext.currentPlayer().getName();

        if (nextPosition > boardSize) {
            System.out.println("Oops," + currentPlayerName + " is trying to move to " + nextPosition + " but, needs to land exactly on " + boardSize + ", Turn skipped.");
        }
    }
}



