package practicedp.designproblems.snakeladder.v2.rules;

/**
 * Rule: If a player rolls three consecutive 6s, their turn is forfeited
 * and they return to the position where they started their turn.
 */
public final class ThreeSixesRule implements MoveRule {

    @Override
    public MoveOutcome apply(TurnContext ctx) {
        int roll = ctx.roll();
        int consecutiveSixes = ctx.consecutiveSixes();

        if (roll == 6 && consecutiveSixes == 2) {
            return MoveOutcome.FORFEIT;
        }

        return MoveOutcome.CONTINUE;
    }
}

