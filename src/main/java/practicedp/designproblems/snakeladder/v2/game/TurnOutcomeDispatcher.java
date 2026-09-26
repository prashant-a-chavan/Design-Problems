package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.rules.MoveOutcome;

import java.util.Map;

/**
 * Dispatches turn outcomes to appropriate handlers.
 */
public final class TurnOutcomeDispatcher {
    private final Map<MoveOutcome, OutcomeHandler> handlers;

    public TurnOutcomeDispatcher() {
        this.handlers = Map.ofEntries(
                Map.entry(MoveOutcome.FORFEIT, new ForfeitHandler()),
                Map.entry(MoveOutcome.SKIP, new SkipHandler()),
                Map.entry(MoveOutcome.WIN, new WinHandler()),
                Map.entry(MoveOutcome.CONTINUE, new ContinueHandler()),
                Map.entry(MoveOutcome.REPLAY, new ReplayHandler())
        );
    }

    public void handle(MoveOutcome outcome, TurnHandlingContext context) {
        OutcomeHandler handler = handlers.get(outcome);
        if (handler != null) {
            handler.handle(context);
        } else {
            throw new IllegalArgumentException("No handler found for MoveOutcome: " + outcome);
        }
    }
}

