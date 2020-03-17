public enum Symbol {
  X("X"), O("O"), EMPTY(" ");

  private String symbol;

  private Symbol(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}

