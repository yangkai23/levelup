package lld.snakeandladder;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public class Board {
    Cell[][] cells;

    public Board(int boardSize, int numOfLadders, int numOfSnakes) {

        initBoard(boardSize);
        addSnakesAndLadders(numOfLadders, numOfSnakes);
    }

    private void addSnakesAndLadders(int numOfLadders, int numOfSnakes) {
        int boardLen = cells.length * cells.length - 1;
        while (numOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, boardLen);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, boardLen);
            if (snakeTail >= snakeHead) {
                continue;

            }
            Jump snake = new Jump();
            snake.start = snakeHead;
            snake.end = snakeTail;
            Cell cell = getCell(snakeHead);
            cell.jump = snake;
            numOfSnakes--;
        }
        while (numOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, boardLen);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, boardLen);
            if (ladderStart >= ladderEnd) {
                continue;

            }
            Jump ladder = new Jump();
            ladder.start = ladderStart;
            ladder.end = ladderEnd;
            Cell cell = getCell(ladderStart);
            cell.jump = ladder;
            numOfLadders--;
        }
    }

    public Cell getCell(int snakeHead) {
        int cols = cells[0].length;
        int snakeRow = snakeHead / cols;
        int snakeCol = snakeHead % cols;
        return cells[snakeRow][snakeCol];
    }

    private void initBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }

    }
}
