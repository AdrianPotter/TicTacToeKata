import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.*;


class GameTest {
    private Game game;
    private static final Integer GRID_SIZE = 9;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    @Test
    void outOfBoundsMoveIsInvalid() {
        assertFalse(game.isValidMove(-1));
        assertFalse((game.isValidMove(9)));
    }

    @Test
    void inBoundsAndEmptyCellIsValidMove() {
        assertTrue(game.isValidMove(0));
    }

    @Test
    void inBoundsAndNotEmptyCellIsInvalidMove() {
        game.placeMove(0);
        assertFalse(game.isValidMove(0));
    }

    @Test
    void moveIsPlacedOnBoard() {
        game.placeMove(0);
    }

    @Test
    void invalidMoveThrowsExceptionWhenPlaced() {
        game.placeMove(0);
        assertThrows(IllegalArgumentException.class, () -> game.placeMove(0));
    }

    @Test
    void playerIsSwitched() {
        game.switchPlayer();
    }

    @Test
    void gameIsDrawIfNoEmptyCellsLeft() {
        range(0, GRID_SIZE).forEach(game::placeMove);
        assertTrue(game.gameIsADraw());
    }

    @Test
    void noWinnerIfNoConditionsMet() {
        placeMoves(0, 2, 6, 8);
        assertFalse(game.currentPlayerHasWon());
    }

    @Test
    void playerHasWonIfConditionsMet() {
        placeMoves(0, 1, 2);
        assertTrue(game.currentPlayerHasWon());
    }

    private void placeMoves(Integer... moves) {
        stream(moves).forEach(game::placeMove);
    }

}
