import java.util.ArrayList;
import java.util.Collections;

public class Grid {
    private static final int GRID_SIZE = 9;
    ArrayList<Player> grid = new ArrayList<>(Collections.nCopies(GRID_SIZE, null));

    public Player getCell(int index) {
        return grid.get(index);
    }

    public void setCell(int index, Player player) {
        grid.set(index, player);
    }

    public Integer getGridSize() {
        return grid.size();
    }

    public boolean hasEmptyCell() {
        return grid.contains(null);
    }
}
