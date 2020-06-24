import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class GameTest {
    private Game game;
    private static final Integer GRID_SIZE = 9;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    @Test
    void outOfBoundsMoveIsInvalid() {
        Assertions.assertFalse(game.isValidMove(-1));
        Assertions.assertFalse((game.isValidMove(9)));
    }

    @Test
    void inBoundsAndEmptyCellIsValidMove() {
        Assertions.assertTrue(game.isValidMove(0));
    }

    @Test
    void inBoundsAndNotEmptyCellIsInvalidMove() {
        game.placeMove(0);
        Assertions.assertFalse(game.isValidMove(0));
    }

    @Test
    void moveIsPlacedOnBoard() {
        game.placeMove(0);
    }

    @Test
    void invalidMoveThrowsExceptionWhenPlaced() {
        game.placeMove(0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.placeMove(0));
    }

    @Test
    void playerIsSwitched() {
        Player player = game.getCurrentPlayer();
        game.switchPlayer();
        Assertions.assertNotSame(game.getCurrentPlayer(), player);
    }

    @Test
    void gameIsDrawIfNoEmptyCellsLeft() {
        IntStream.range(0, GRID_SIZE).forEach(game::placeMove);
        Assertions.assertTrue(game.gameIsADraw());
    }

    @Test
    void noWinnerIfNoConditionsMet() {
        placeMoves(0, 2, 6, 8);
        Assertions.assertFalse(game.currentPlayerHasWon());
    }

    @Test
    void playerHasWonIfConditionsMet() {
        placeMoves(0, 1, 2);
        Assertions.assertTrue(game.currentPlayerHasWon());
    }

    private void placeMoves(Integer ...moves) {
        Arrays.stream(moves).forEach(game::placeMove);
    }

}
