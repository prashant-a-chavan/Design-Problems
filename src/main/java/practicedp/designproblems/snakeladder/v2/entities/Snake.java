package practicedp.designproblems.snakeladder.v2.entities;

public final class Snake extends BoardEntity {
    private Snake(int start, int end) {
        super(start, end);
    }

    public static Snake createSnake(int start, int end) {
        if (start <= end) {
            throw new IllegalArgumentException("Invalid Snake specification");
        }

        return new Snake(start, end);
    }
}

