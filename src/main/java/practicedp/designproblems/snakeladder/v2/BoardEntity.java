package practicedp.designproblems.snakeladder.v2;

public abstract sealed class BoardEntity permits Snake, Ladder {
    private final int start;
    private final int end;

    protected BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
