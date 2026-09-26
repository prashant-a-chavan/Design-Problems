package practicedp.designproblems.snakeladder.v2.rules;

public enum MoveOutcome {
    CONTINUE,    // Turn continues, player moves normally
    SKIP,        // Turn is skipped, player stays in place
    FORFEIT,     // Player returns to turn start position
    WIN,         // Player reached final square and won
    REPLAY       // Player gets another turn (rolled a 6)
}

