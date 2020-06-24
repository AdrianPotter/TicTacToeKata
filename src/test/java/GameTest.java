import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class GameTest {
    private Game game;
    private Grid grid;
    private Player player1 = mock(Player.class);
    private Player player2 = mock(Player.class);

    @BeforeEach
    void setup() {
        grid = mock(Grid.class);
        game = new Game(grid, player1, player2);
    }

    @Test
    void moveOutsideGridIsInvalid() {
        final int size = 1;
        when(grid.getGridSize()).thenReturn(size);

        assertFalse(game.isValidMove(-1));
        assertFalse((game.isValidMove(size)));
    }

    @Test
    void inBoundsAndEmptyCellIsValidMove() {
        when(grid.getGridSize()).thenReturn(1);
        assertTrue(game.isValidMove(0));
    }

    @Test
    void whenMovePlacedOnOccupiedCellThenInvalidMove() {
        when(grid.getGridSize()).thenReturn(1);
        when(grid.getCell(0)).thenReturn(new Player());

        assertFalse(game.isValidMove(0));
    }

    @Test
    void moveIsPlacedOnBoard() {
        when(grid.getGridSize()).thenReturn(1);
        game.placeMove(0);
    }

    @Test
    void invalidMoveThrowsExceptionWhenPlaced() {
        when(grid.getGridSize()).thenReturn(1);
        when(grid.getCell(0)).thenReturn(new Player());
        assertThrows(IllegalArgumentException.class, () -> game.placeMove(0));
    }

    @Test
    void playerIsSwitched() {
        game.switchPlayer();
    }

    @Test
    void gameIsDrawIfNoEmptyCellsLeft() {
        final int size = 1;
        when(grid.getGridSize()).thenReturn(size);
        range(0, size).forEach(game::placeMove);
        assertTrue(game.gameIsADraw());
    }

    @Test
    void noWinnerIfNoConditionsMet() {
        assertFalse(game.currentPlayerHasWon());
    }

    @Test
    void playerHasWonIfConditionsMet() {
        when(grid.getCell(anyInt())).thenReturn(player1);
        assertTrue(game.currentPlayerHasWon());
    }

}
