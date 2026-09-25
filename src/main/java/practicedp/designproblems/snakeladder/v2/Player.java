package practicedp.designproblems.snakeladder.v2;

public final class Player {
    private final String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public void setCurrentPosition(int movePosition) {
        this.currentPosition = movePosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
