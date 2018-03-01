import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void before() {
        board = new Board();

        board.createCell(4, 0, false);
        board.createCell(0, 1, false);
        board.createCell(1, 1, true);
        board.createCell(2, 1, false);
        board.createCell(2, 2, false);
        board.createCell(0, 3, false);
    }

    @Test
    void emptyBoard_isEmpty() {
        Board emptyBoard = new Board();

        assertTrue(emptyBoard.isEmpty());
    }

    @Test
    void board_isNotEmpty() {
        assertFalse(board.isEmpty());
    }

    @Test
    void singleCellTick_isDead() {
        board.tick();

        assertFalse(board.isCellAlive(0, 3));
    }

    @Test
    void doubleCellTick_isAlive() {
        board.tick();;

        assertTrue(board.isCellAlive(1, 1));
        assertTrue(board.isCellAlive(2, 1));
        assertTrue(board.isCellAlive(2, 2));
    }

    @Test
    void zombie_isZombie() {
        assertTrue(board.isCellZombie(1, 1));
    }

    @Test
    void zombieThreeTurns_isDeadZombie() {
        board.tick();
        board.tick();
        board.tick();

        assertFalse(board.isCellAlive(1, 1));
    }

    @Test
    void newZombies_areTheyZombies() {
        board.tick();
        board.tick();
        board.tick();
        board.tick();
    }
}