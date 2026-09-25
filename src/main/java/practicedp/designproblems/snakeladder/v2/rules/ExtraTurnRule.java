package practicedp.designproblems.snakeladder.v2.rules;

/**
 * Rule: If a player rolls a 6, they get another turn.
 */
public final class ExtraTurnRule implements MoveRule {

    @Override
    public MoveOutcome apply(TurnContext ctx) {
        if (ctx.roll() == 6) {
            return MoveOutcome.REPLAY;
        }
        return MoveOutcome.CONTINUE;
    }
}


