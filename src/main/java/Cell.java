import javax.swing.text.MutableAttributeSet;
import java.util.Set;

class Cell {
    int x;
    int y;
    int tours = 0;
    boolean zombie = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Cell(int x, int y, boolean zombie) {
        this.x = x;
        this.y = y;
        this.zombie = zombie;
    }

    long countNeighbours(Set<Cell> oldCells) {
        return oldCells.stream().filter(
                it -> Math.abs(it.x - this.x) <= 1 && Math.abs(it.y - this.y) <= 1 && (it.y != this.y || it.x != this.x)
        ).count();
    }
}
