package practicedp.designproblems.tictactoe.v1;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String message) {
        super(message);
    }
}
