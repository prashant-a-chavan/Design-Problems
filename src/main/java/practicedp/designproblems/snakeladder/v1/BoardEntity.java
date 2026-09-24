package practicedp.designproblems.snakeladder.v1;

public abstract class BoardEntity {
    private final int start;
    private final int end;

    protected BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected int getStart() {
        return this.start;
    }

    protected int getEnd() {
        return this.end;
    }
}
