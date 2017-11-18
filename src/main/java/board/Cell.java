package board;

import java.util.List;

public class Cell {
    public int x;
    public int y;
    public int neighbours = 0;

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

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void countNeighbours(List<Cell> aliveCells) {
        for (int _x = x - 1; _x <= x + 1; _x++) {
            for (int _y = y - 1; _y <= y + 1; _y++) {
                this.checkNeighbour(aliveCells, _x, _y);
            }
        }
    }

    private void checkNeighbour(List<Cell> aliveCells, int x, int y) {
        if (x == this.x
                && y == this.y) {
            return;
        } else if (aliveCells.contains(new Cell(x, y))) {
            this.neighbours++; }
    }
}
