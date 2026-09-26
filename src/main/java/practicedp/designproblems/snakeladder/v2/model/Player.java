package practicedp.designproblems.snakeladder.v2.model;

public final class Player {
    private final String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int movePosition) {
        this.currentPosition = movePosition;
    }

    public String getName() {
        return name;
    }
}

