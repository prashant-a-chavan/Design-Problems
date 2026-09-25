package practicedp.designproblems.snakeladder.v2.rules;

/**
 * Alternate variant: If a player overshoots the final square,
 * they bounce back by the overshoot amount.
 * For example, if board size is 100 and they roll 103, they land on 97.
 */
public final class BounceBackRule implements MoveRule {

    @Override
    public MoveOutcome apply(TurnContext ctx) {
        int nextPosition = ctx.nextPosition();
        int boardSize = ctx.boardSize();

        // If overshooting, bounce back
        if (nextPosition > boardSize) {
            return MoveOutcome.CONTINUE;
        }

        // Check if landing on the final square exactly
        int finalPosition = ctx.board().getFinalPosition(nextPosition);
        if (finalPosition == boardSize) {
            return MoveOutcome.WIN;
        }

        return MoveOutcome.CONTINUE;
    }
}


