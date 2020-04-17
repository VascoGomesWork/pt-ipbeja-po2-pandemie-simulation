package ipbeja.stu.po2.Model;

public class Cell {

    private final CellPosition cellPosition;

    public Cell(CellPosition cellposition)
    {
        this.cellPosition = cellposition;
    }

    public CellPosition cellPosition() {
        return cellPosition;
    }

    public int dx() {
        return 0;
    }

    public int dy() {
        return 0;
    }

    public boolean randomMove() {
        return false;
    }
}
