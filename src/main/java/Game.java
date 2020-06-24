import java.util.Arrays;
import java.util.List;

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
        this(new Grid(), new Player(), new Player());
    }

    public Game(Grid grid, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = this.player1;
        this.grid = grid;
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
        return winningConditionsMet(
            List.of(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT),
            List.of(TOP_CENTER, MIDDLE_CENTER, BOTTOM_CENTER),
            List.of(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT)
        );
    }

    private boolean horizontalWinningConditionMet() {
        return winningConditionsMet(
            List.of(TOP_LEFT, TOP_CENTER, TOP_RIGHT),
            List.of(MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT),
            List.of(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT)
        );
    }

    private boolean diagonalWinningConditionMet() {
        return winningConditionsMet(
            List.of(TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT),
            List.of(TOP_RIGHT, MIDDLE_CENTER, BOTTOM_LEFT)
        );
    }

    public boolean gameIsADraw() {
        return !grid.hasEmptyCell();
    }

    @SafeVarargs
    private boolean winningConditionsMet(List<Integer>... winningConditions) {
        return Arrays.stream(winningConditions).anyMatch(this::cellsMatch);
    }

    private boolean cellsMatch(List<Integer> cells) {
        return cells.stream().map(grid::getCell).allMatch(currentPlayer::equals);
    }

}