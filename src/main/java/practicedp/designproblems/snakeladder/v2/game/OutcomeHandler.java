package practicedp.designproblems.snakeladder.v2.game;

/**
 * Handles the outcome of a turn after rules are applied.
 */
public interface OutcomeHandler {
    void handle(TurnHandlingContext context);
}

