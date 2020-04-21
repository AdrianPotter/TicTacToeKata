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
    if (index < 0 || index > cells.size()-1) {
      return false;
    }
    else if (getCellSymbol(index) != Symbol.EMPTY) {
      return false;
    }
    else if (symbol == Symbol.EMPTY){
      return false;
    }
    return true;
  }

  public void placeMove(int gridPosition, Symbol symbol) {
    try {
      cells.get(gridPosition).setSymbol(symbol);
    }
    catch(IndexOutOfBoundsException e){

    }
  }

  private void initialiseEmptyGrid() {
    for (int i = 0; i < 9; i++) {
      Cell cell = new Cell();
      cells.add(cell);
    }
  }

  public boolean checkDraw(){
    for(int i = 0; i < cells.size(); i++){
      if(cells.get(i).getSymbol() == Symbol.EMPTY) {
        return false;
      }
    }
    return true;
  }

  public boolean checkWinner(Symbol symbol){
    if(symbol == Symbol.EMPTY){
      throw new IllegalArgumentException("EMPTY symbol cannot win");
    }
    if(getCellSymbol(0) == symbol && getCellSymbol(1) == symbol && getCellSymbol(2) == symbol) {
      return true;
    }
    if(getCellSymbol(3) == symbol && getCellSymbol(4) == symbol && getCellSymbol(5) == symbol) {
      return true;
    }
    if(getCellSymbol(6) == symbol && getCellSymbol(7) == symbol && getCellSymbol(8) == symbol) {
      return true;
    }
    if(getCellSymbol(0) == symbol && getCellSymbol(3) == symbol && getCellSymbol(6) == symbol) {
      return true;
    }
    if(getCellSymbol(1) == symbol && getCellSymbol(4) == symbol && getCellSymbol(7) == symbol) {
      return true;
    }
    if(getCellSymbol(2) == symbol && getCellSymbol(5) == symbol && getCellSymbol(8) == symbol) {
      return true;
    }
    if(getCellSymbol(0) == symbol && getCellSymbol(4) == symbol && getCellSymbol(8) == symbol) {
      return true;
    }
    if(getCellSymbol(2) == symbol && getCellSymbol(4) == symbol && getCellSymbol(6) == symbol) {
      return true;
    }

    return false;
  }

}
