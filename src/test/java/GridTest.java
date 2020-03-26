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

  @Test
  void threeMatchingSymbolsOnTopRowIsAWinner() {
    grid.placeMove(0, Symbol.O);
    grid.placeMove(1, Symbol.O);
    grid.placeMove(2, Symbol.O);
    Assertions.assertTrue(grid.checkWinner(Symbol.O));
  }

  @Test
  void threeUnMatchingSymbolsOnTopRowIsNotAWinner() {
    grid.placeMove(0, Symbol.O);
    grid.placeMove(1, Symbol.X);
    grid.placeMove(2, Symbol.O);
    Assertions.assertFalse(grid.checkWinner(Symbol.O));
  }

  @Test
  void threeMatchingSymbolsOnMiddleRowIsAWinner() {
    grid.placeMove(3, Symbol.X);
    grid.placeMove(4, Symbol.X);
    grid.placeMove(5, Symbol.X);
    Assertions.assertTrue(grid.checkWinner(Symbol.X));
  }

  @Test
  void threeMatchingSymbolsOnMiddleRowIsNotAWinner() {
    grid.placeMove(3, Symbol.X);
    grid.placeMove(4, Symbol.O);
    grid.placeMove(5, Symbol.X);
    Assertions.assertFalse(grid.checkWinner(Symbol.X));
  }

  @Test
  void threeMatchingSymbolsOnBottomRowIsAWinner() {
    grid.placeMove(6, Symbol.X);
    grid.placeMove(7, Symbol.X);
    grid.placeMove(8, Symbol.X);
    Assertions.assertTrue(grid.checkWinner(Symbol.X));
  }

  @Test
  void threeMatchingSymbolsOnBottomRowIsNotAWinner() {
    grid.placeMove(6, Symbol.X);
    grid.placeMove(7, Symbol.O);
    grid.placeMove(8, Symbol.X);
    Assertions.assertFalse(grid.checkWinner(Symbol.X));
  }
}
