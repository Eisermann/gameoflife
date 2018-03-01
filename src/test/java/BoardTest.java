import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void before() {
        board = new Board();

        board.createCell(2, 0);
        board.createCell(3, 0);

        board.createCell(0, 1);
        board.createCell(1, 1);
        board.createCell(2, 1);

        board.createCell(2, 2);

        board.createCell(0, 3);
    }

    @Test
    void filledBoard_expectedResults() {
        assertEquals(board.getActiveCells(), 7);
    }

    @Test
    void singleCell_isDead() {
        board.tick();

        assertFalse(board.isCellAlive(0, 3));
    }

    @Test
    void oneNeighbourCell_isDead() {
        board.tick();

        assertFalse(board.isCellAlive(0, 1));
    }

    @Test
    void twoOrThreeNeighbourCell_isAlive() {
        board.tick();

        assertTrue(board.isCellAlive(2, 2));
    }

    @Test
    void tooMuchNeighbourCell_isDead() {
        board.tick();

        assertFalse(board.isCellAlive(1, 1));
        assertFalse(board.isCellAlive(2, 1));
    }

    @Test
    void cellsAfterTick() {
        board.tick();

        assertFalse(board.isCellAlive(0, 0));
        assertFalse(board.isCellAlive(1, 0));
        assertTrue(board.isCellAlive(2, 0));
        assertTrue(board.isCellAlive(3, 0));

        assertFalse(board.isCellAlive(0, 1));
        assertFalse(board.isCellAlive(1, 1));
        assertFalse(board.isCellAlive(2, 1));
        assertFalse(board.isCellAlive(3, 1));

        assertTrue(board.isCellAlive(0, 2));
        assertFalse(board.isCellAlive(1, 2));
        assertTrue(board.isCellAlive(2, 2));
        assertFalse(board.isCellAlive(3, 2));
    }
}