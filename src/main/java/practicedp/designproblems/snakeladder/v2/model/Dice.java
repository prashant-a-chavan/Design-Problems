package practicedp.designproblems.snakeladder.v2.model;

import java.util.concurrent.ThreadLocalRandom;

public final class Dice {
    private final int min;
    private final int max;

    private Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Dice createDice(int min, int max) {
        if (min <= 0 || min >= max) {
            throw new IllegalArgumentException("Invalid Dice specification");
        }

        return new Dice(min, max);
    }

    public int rollDice() {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
}

