import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTest {

  private Grid grid;

  @BeforeEach
  void setUp() {
    grid = new Grid();
  }

  @Test
  void gridHasNineCells() {
    Assertions.assertEquals(9, grid.getCells().size());
  }

  @Test
  void initialisedGridIsEmpty() {
    Assertions.assertEquals(Symbol.EMPTY, grid.getCellSymbol(0));
  }

  @Test
  void isMoveOnGridPlacedInCorrectPosition() {
    grid.placeMove(0, Symbol.O);
    Assertions.assertEquals(Symbol.O, grid.getCellSymbol(0));
  }

  @Test
  void isMoveInOccupiedCellInvalid() {
    grid.placeMove(0, Symbol.O);
    Assertions.assertFalse(grid.isValidMove(0, Symbol.O));
  }

  @Test
  void outOfLowerBoundsMoveIsInvalid() {
    Assertions.assertFalse(grid.isValidMove(-1, Symbol.O));
  }

  @Test
  void outOfUpperBoundsMoveIsInvalid() {
    Assertions.assertFalse(grid.isValidMove(9, Symbol.O));
  }

  @Test
  void withinBoundsMoveInEmptyCellIsValid() {
    Assertions.assertTrue(grid.isValidMove(1, Symbol.O));
  }

  @Test
  void isMoveOnGridPlacedInOccupiedCellInvalid() {
    grid.placeMove(1, Symbol.O);
    Assertions.assertFalse(grid.isValidMove(1, Symbol.O));
  }

  @Test
  void emptySymbolsMoveIsInvalid() {
    Assertions.assertFalse(grid.isValidMove(0, Symbol.EMPTY));
  }
}
