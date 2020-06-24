import java.util.ArrayList;

public class Grid {
    ArrayList<Player> grid = new ArrayList<>();
    private static final int GRID_SIZE = 9;

    public Grid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            grid.add(null);
        }
    }


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
