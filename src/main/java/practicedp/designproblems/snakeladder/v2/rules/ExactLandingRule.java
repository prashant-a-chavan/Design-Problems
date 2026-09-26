package practicedp.designproblems.snakeladder.v2.rules;

/**
 * Rule: Player must land exactly on the final square.
 * If they overshoot, their turn is skipped, and they stay at their current position.
 */
public final class ExactLandingRule implements MoveRule {

    @Override
    public MoveOutcome apply(TurnContext ctx) {
        int nextPosition = ctx.nextPosition();
        int boardSize = ctx.boardSize();

        // Check if landing on the final square exactly
        int finalPosition = ctx.board().getFinalPosition(nextPosition);
        if (finalPosition == boardSize) {
            return MoveOutcome.WIN;
        }

        // Check if overshooting the final square
        if (nextPosition > boardSize) {
            return MoveOutcome.SKIP;
        }

        return MoveOutcome.CONTINUE;
    }
}

