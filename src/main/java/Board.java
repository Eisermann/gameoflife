import java.util.HashSet;
import java.util.Set;

public class Board {
    Set<Cell> cells = new HashSet<Cell>();

    public void createCell(int x, int y) {
        cells.add(new Cell(x, y));
    }

    int getActiveCells() {
        return cells.size();
    }

    public boolean isCellAlive(int x, int y) {
        return cells.stream().filter(it -> it.x == x && it.y == y).count() > 0;
    }

    public void tick() {
        Set<Cell> oldCells = cells;
        cells = new HashSet<Cell>();

        oldCells.forEach(it -> {
            long neighbours = getNeighbours(oldCells, it);

            if (neighbours == 2 || neighbours == 3) {
                cells.add(it);
            }

            for (int _x = it.x - 1; _x <= it.x + 1; _x++) {
                for (int _y = it.y - 1; _y <= it.y + 1; _y++) {
                    if (!isCellAlive(_x, _y)) {
                        Cell tempCell = new Cell(_x, _y);
                        long tempLen = getNeighbours(oldCells, tempCell);

                        if (tempLen == 3) {
                            cells.add(tempCell);
                        }
                    }
                }
            }
        });
    }

    private long getNeighbours(Set<Cell> oldCells, Cell it) {
        return oldCells.stream().filter(old -> {
                    double length = Math.sqrt(Math.pow(Math.abs(old.x - it.x), 2) + Math.pow(Math.abs(old.y - it.y), 2));

                    if (length > 0 && length <= Math.sqrt(2)) {
                        return true;
                    }
                    return false;
                }).count();
    }
}
