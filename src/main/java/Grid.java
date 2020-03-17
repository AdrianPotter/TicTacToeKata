import java.util.ArrayList;
import java.util.List;

public class Grid {
  private List<Cell> cells = new ArrayList<>();

  public Grid() {
    initialiseEmptyGrid();
  }

  public List<Cell> getCells() {
    return cells;
  }

  public Symbol getCellSymbol(int index) {
    return cells.get(index).getSymbol();
  }

  public boolean isValidMove(int index, Symbol symbol) {
    if (index < 0 || index > 8) {
      return false;
    }
    else if (getCellSymbol(index) != Symbol.EMPTY) {
      return false;
    }
    return true;
  }

  public void placeMove(int gridPosition, Symbol symbol) {
    cells.get(gridPosition).setSymbol(symbol);
  }

  private void initialiseEmptyGrid() {
    for (int i = 0; i < 9; i++) {
      Cell cell = new Cell();
      cells.add(cell);
    }
  }

}
