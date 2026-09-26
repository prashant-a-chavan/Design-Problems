package practicedp.designproblems.snakeladder.v2.rules;

import practicedp.designproblems.snakeladder.v2.model.Board;
import practicedp.designproblems.snakeladder.v2.model.Player;

public record TurnContext(Player currentPlayer, int currentPosition, int roll, int boardSize, int consecutiveSixes,
                          int turnStartPosition, Board board) {

    public int nextPosition() {
        return currentPosition + roll;
    }
}

