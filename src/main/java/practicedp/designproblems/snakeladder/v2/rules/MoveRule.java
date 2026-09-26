package practicedp.designproblems.snakeladder.v2.rules;

public interface MoveRule {
    /**
     * Applies the rule to the current turn context
     *
     * @param ctx the turn context containing player, position, roll, etc.
     * @return MoveOutcome indicating what should happen next
     */
    MoveOutcome apply(TurnContext ctx);
}

