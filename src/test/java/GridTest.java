import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private Grid grid;
    private static final Integer GRID_SIZE = 9;

    @BeforeEach
    void Setup() {
        grid = new Grid();
    }

    @Test
    void gridIsInitialisedWithRightSize() {
        assertEquals(grid.getGridSize(), GRID_SIZE);
    }

    @Test
    void newGridIsEmpty() {
        IntStream
            .range(0, grid.getGridSize())
            .mapToObj(grid::getCell)
            .forEach(Assertions::assertNull);
    }

    @Test
    void gridWithEmptySpaceHasEmptyCell() {
        assertTrue(grid.hasEmptyCell());
    }

    @Test
    void fullGridHasNoEmptyCell() {
        Player player = new Player();
        IntStream
            .range(0, grid.getGridSize())
            .forEach(i -> grid.setCell(i, player));
        assertFalse(grid.hasEmptyCell());
    }
}
