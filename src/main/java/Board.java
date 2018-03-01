import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class Board {
    Set<Cell> cells = new HashSet<Cell>();

    void createCell(int x, int y, boolean zombie) {
        cells.add(new Cell(x, y, zombie));
    }

    boolean isEmpty() {
        return cells.isEmpty();
    }

    void tick() {
        final Set<Cell> oldCells = cells;
        cells = new HashSet<Cell>();

        oldCells.forEach(it->{
            long neighbours = it.countNeighbours(oldCells);

            if (neighbours == 2 || neighbours == 3) {
                it.tours++;

                if (it.tours >= 3) {
                    it.zombie = true;
                }

                cells.add(it);
            }
        });
    }

    boolean isCellAlive(int x, int y) {
        Optional<Cell> cell = cells.stream().filter(it -> (it.x == x && it.y == y)).findFirst();

        if (!cell.isPresent()) {
            return false;
        }

        Cell c = cell.get();

        return !(c.zombie && c.tours >= 3);
    }

    boolean isCellZombie(int x, int y) {
        Cell cell = cells.stream().filter(it -> (it.x == x && it.y == y)).findFirst().get();
        return cell.zombie;
    }
}
