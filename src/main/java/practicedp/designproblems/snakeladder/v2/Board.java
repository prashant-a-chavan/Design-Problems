package practicedp.designproblems.snakeladder.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Board {
    private final int boardSize;
    private final Map<Integer, Integer> snakesAndLadders;

    private Board(int boardSize, Map<Integer, Integer> snakesAndLadders) {
        this.boardSize = boardSize;
        this.snakesAndLadders = Map.copyOf(snakesAndLadders);
    }

    public static Board createBoard(int boardSize, List<BoardEntity> boardEntities) {
        validateBoardSize(boardSize);

        Map<Integer, Integer> entities = buildEntityPositions(boardSize, boardEntities);

        return new Board(boardSize, entities);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getFinalPosition(int position) {
        return snakesAndLadders.getOrDefault(position, position);
    }

    private static Map<Integer, Integer> buildEntityPositions(int boardSize, List<BoardEntity> boardEntities) {
        Map<Integer, Integer> entities = new HashMap<>();

        for (BoardEntity boardEntity : boardEntities) {
            int start = boardEntity.getStart();
            int end = boardEntity.getEnd();

            if (start < 1 || start > boardSize || end < 1 || end > boardSize)
                throw new IllegalArgumentException("Entity positions must be within 1 and " + boardSize);

            if (start == boardSize) throw new IllegalArgumentException("No entity may start on the final cell");

            if (start == 1) throw new IllegalArgumentException("No entity may start on cell 1");

            if (entities.containsKey(start)) {
                throw new IllegalArgumentException("Two entities cannot share the same start cell: " + start);
            }
            entities.put(start, end);
        }
        return entities;
    }

    private static void validateBoardSize(int boardSize) {
        if (boardSize <= 0) throw new IllegalArgumentException("Invalid Board Size");
    }
}
