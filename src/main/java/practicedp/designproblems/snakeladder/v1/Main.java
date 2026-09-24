package practicedp.designproblems.snakeladder.v1;

import practicedp.designproblems.snakeladder.v1.game.Game;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int boardSize = 100;

        List<BoardEntity> boardEntities = List.of(
                Snake.createSnake(17, 7),
                Snake.createSnake(54, 34),
                Snake.createSnake(62, 19),
                Snake.createSnake(98, 79),

                Ladder.createLadder(3, 38),
                Ladder.createLadder(24, 33),
                Ladder.createLadder(42, 93),
                Ladder.createLadder(72, 84)
                );

        List<String> players = Arrays.asList("Prashant", "Prajwal", "Prateek");

        Dice dice = Dice.createDice(1, 6);

        Game game = Game.getBuilder()
                .board(boardSize, boardEntities)
                .players(players)
                .dice(dice)
                .build();

        game.play();
    }
}
