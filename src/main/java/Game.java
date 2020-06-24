public class Game {

    private static final Integer TOP_LEFT = 0;
    private static final Integer TOP_CENTER = 1;
    private static final Integer TOP_RIGHT = 2;
    private static final Integer MIDDLE_LEFT = 3;
    private static final Integer MIDDLE_CENTER = 4;
    private static final Integer MIDDLE_RIGHT = 5;
    private static final Integer BOTTOM_LEFT = 6;
    private static final Integer BOTTOM_CENTER = 7;
    private static final Integer BOTTOM_RIGHT = 8;

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
        return horizontalWinningConditionMet()
            || verticalWinningConditionMet()
            || diagonalWinningConditionMet();
    }

    private boolean verticalWinningConditionMet() {
        return cellsMatch(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT)
            || cellsMatch(TOP_CENTER, MIDDLE_CENTER, BOTTOM_CENTER)
            || cellsMatch(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT);
    }

    private boolean horizontalWinningConditionMet() {
        return cellsMatch(TOP_LEFT, TOP_CENTER, TOP_RIGHT)
            || cellsMatch(MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT)
            || cellsMatch(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT);
    }

    private boolean diagonalWinningConditionMet() {
        return cellsMatch(TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT)
            || cellsMatch(TOP_RIGHT, MIDDLE_CENTER, BOTTOM_LEFT);
    }

    public boolean gameIsADraw() {
        return !grid.hasEmptyCell();
    }

    private boolean cellsMatch(int index1, int index2, int index3) {
        return grid.getCell(index1) == currentPlayer && grid.getCell(index2) == currentPlayer && grid.getCell(index3) == currentPlayer;
    }

}