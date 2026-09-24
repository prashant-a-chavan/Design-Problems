package practicedp.designproblems.snakeladder.v1;

public final class Ladder extends BoardEntity {
    private Ladder(int start, int end) {
        super(start, end);
    }

    public static Ladder createLadder(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("Invalid Ladder specification");
        }

        return new Ladder(start, end);
    }
}
