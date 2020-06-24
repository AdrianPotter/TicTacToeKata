import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTest {

    private Grid grid;
    private static final Integer GRID_SIZE = 9;

    @BeforeEach
    void Setup() {
        grid = new Grid();
    }

    @Test
    void gridIsInitialisedWithRightSize() {
        Assertions.assertEquals(grid.getGridSize(), (int) GRID_SIZE);
    }

    @Test
    void newGridIsEmpty() {
        for (int i = 0; i < grid.getGridSize(); i++) {
            Assertions.assertNull(grid.getCell(i));
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
