package board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Cell> cells = new ArrayList<Cell>();

    public boolean isEmpty() {
        return cells.isEmpty();
    }

    public void createCell(int x, int y) {
        cells.add(new Cell(x, y));
    }

    public void tick() {
        List<Cell> oldCells = cells;
        cells = new ArrayList<Cell>();

        for (int i = 0; i < oldCells.size(); i++) {
            this.checkCell(oldCells, i);
        }
    }

    private void checkCell(List<Cell> oldCells, int i) {
        Cell cell = oldCells.get(i);
        cell.neighbours = 0;
        cell.countNeighbours(oldCells);
        this.continueLife(cell);
    }

    private void continueLife(Cell cell) {
        if (cell.neighbours == 2) {
            cells.add(cell);
        } else if (cell.neighbours == 3) {
            cells.add(cell);
        }
    }

    public boolean isCellAlive(int x, int y) {
        return cells.contains(new Cell(x, y));
    }
}
