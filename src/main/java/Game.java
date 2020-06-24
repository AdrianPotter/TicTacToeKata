public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Grid grid;

    public Game() {
        player1 = new Player();
        player2 = new Player();
        currentPlayer = player1;
        grid = new Grid(); //TODO: Hard dependency on Grid
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public void placeMove(int index) throws IllegalArgumentException {
        if (!isValidMove(index)) {
            throw new IllegalArgumentException("Invalid Move");
        } else {
            grid.setCell(index, currentPlayer);
        }

    }

    public boolean isValidMove(int index) {
        return isMoveWithinGrid(index) && hasMoveAlreadyBeenPlayed(index);
    }

    private boolean isMoveWithinGrid(int index) {
        return index >= 0 && index < grid.getGridSize();
    }

    private boolean hasMoveAlreadyBeenPlayed(int index) {
        return grid.getCell(index) == null;
    }

    public boolean currentPlayerHasWon() {
        return horizontalWinningConditionMet() || verticalWinningConditionMet() || diagonalWinningConditionMet();
    }

    private boolean verticalWinningConditionMet() {
        return cellsMatch(0, 3, 6) || cellsMatch(1, 4, 7) || cellsMatch(2, 5, 8);
    }

    private boolean horizontalWinningConditionMet() {
        return cellsMatch(0, 1, 2) || cellsMatch(3, 4, 5) || cellsMatch(6, 7, 8);
    }

    private boolean diagonalWinningConditionMet() {
        return cellsMatch(0, 4, 8) || cellsMatch(2, 4, 6);
    }

    public boolean gameIsADraw() {
        return !grid.hasEmptyCell();
    }

    private boolean cellsMatch(int index1, int index2, int index3) {
        return grid.getCell(index1) == currentPlayer && grid.getCell(index2) == currentPlayer && grid.getCell(index3) == currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}