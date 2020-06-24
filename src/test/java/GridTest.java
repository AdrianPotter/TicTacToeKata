import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTest {

    Grid grid;
    private final int GRIDSIZE = 9;

    @BeforeEach
    void Setup() {
        grid = new Grid();
    }

    @Test
    void gridIsInitialisedWithRightSize() {
        Assertions.assertTrue(grid.getGridSize() == GRIDSIZE);
    }

    @Test
    void newGridIsEmpty() {
        for (int i = 0; i < grid.getGridSize(); i++) {
            Assertions.assertTrue(grid.getCell(i) == null);
        }
    }

    @Test
    void gridWithEmptySpaceHasEmptyCell() {
        Assertions.assertTrue(grid.hasEmptyCell());
    }

    @Test
    void fullGridHasNoEmptyCell() {
        Player player = new Player("aName", 'X');
        for (int i = 0; i < grid.getGridSize(); i++) {
            grid.setCell(i, player);
        }
        Assertions.assertFalse(grid.hasEmptyCell());
    }
}
