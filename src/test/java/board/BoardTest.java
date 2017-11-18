package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BoardTest {

    Board board;

    @BeforeEach
    public void before() {
        board = new Board();
    }

    @Test
    public void emptyBoard_isEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    void singleCellBoard_isNotEmpty() {
        board.createCell(0, 0);

        assertFalse(board.isEmpty());
    }

    @Test
    void singleCellBoardTick_isEmpty() {
        board.createCell(0, 0);

        board.tick();

        assertTrue(board.isEmpty());
    }

    @Test
    void dobuleCellBoardTick_isEmpty() {
        board.createCell(0, 0);
        board.createCell(0, 1);

        board.tick();

        assertTrue(board.isEmpty());
    }

    @Test
    void twoNeighboursTick_keepsAlive() {
        board.createCell(0, 0);
        board.createCell(0, 1);
        board.createCell(0, 2);

        board.tick();

        assertFalse(board.isCellAlive(0, 0));
        assertTrue(board.isCellAlive(0, 1));
        assertFalse(board.isCellAlive(0, 2));
    }

    @Test
    void threeNeighboursTick_keepsAlive() {
        board.createCell(0, 0);
        board.createCell(0, 1);
        board.createCell(1, 1);

        board.tick();

        assertTrue(board.isCellAlive(0, 0));
        assertTrue(board.isCellAlive(0, 1));
        assertTrue(board.isCellAlive(1, 1));
    }
}
