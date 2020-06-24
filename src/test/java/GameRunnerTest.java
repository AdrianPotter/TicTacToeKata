import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.mockito.Mockito.*;

public class GameRunnerTest {

    private Game game;

    @BeforeEach
    void setup() {
        game = mock(Game.class);
    }

    @Test
    void givenMoveWhenGameRunThenMovePlaced() {
        when(game.currentPlayerHasWon()).thenReturn(false, true);
        runGameWithInput("0");
        verify(game).placeMove(0);
    }

    @Test
    void whenGameHasWinnerThenGameEnds() {
        when(game.currentPlayerHasWon()).thenReturn(true);
        runGameWithInput("");
    }

    @Test
    void whenGameHasDrawnThenGameEnds() {
        when(game.gameIsADraw()).thenReturn(true);
        runGameWithInput("");
    }

    @Test
    void whenPlaceMoveThrowsIllegalArgumentThenNextMoveReadAndPlaced() {
        whenPlaceMoveThrowsThenNextMoveReadAndPlaced(IllegalArgumentException.class);
    }

    @Test
    void whenPlaceMoveThrowsInputMismatchThenNextMoveReadAndPlaced() {
        whenPlaceMoveThrowsThenNextMoveReadAndPlaced(InputMismatchException.class);
    }

    private void whenPlaceMoveThrowsThenNextMoveReadAndPlaced(Class<? extends RuntimeException> thrownClass) {
        when(game.currentPlayerHasWon()).thenReturn(false, true);
        doThrow(thrownClass).when(game).placeMove(0);

        runGameWithInput("0\n1");

        verify(game).placeMove(0);
        verify(game).placeMove(1);
    }

    @Test
    void canCreateGameRunnerFromDefaultConstructor() {
        new GameRunner();
    }

    private void runGameWithInput(String input) {
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        new GameRunner(game, mockInputStream).runGame();
    }
}
