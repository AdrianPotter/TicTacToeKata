import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

public class GameRunnerTest {

  GameRunner gameRunner;

  @BeforeEach
  void setup() {
    gameRunner = new GameRunner();
  }

  @Test
  void gameEndsWhenWinner() {
    String mockUserInput = "0";
    Game game = Mockito.mock(Game.class);
    Mockito.when(game.isGameDraw()).thenReturn(false);
    Mockito.when(game.isGameWon()).thenReturn(true);
    GameRunner winGameRunner = new GameRunner(game);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput.getBytes());
    winGameRunner.runGame(byteArrayInputStream);
  }

    @Test
    void gameEndsWhenDraw() {
        String mockUserInput = "0";
        Game game = Mockito.mock(Game.class);
        Mockito.when(game.isGameDraw())
                .thenReturn(false)
                .thenReturn(true);
        Mockito.when(game.isGameWon()).thenReturn(false);
        GameRunner drawGameRunner = new GameRunner(game);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput.getBytes());
        drawGameRunner.runGame(byteArrayInputStream);
    }

    @Test
    void gameRunnerThrowsExceptionWhenNoInputIsAvailable() {
        String mockUserInput = "0\n1";
        Game game = Mockito.mock(Game.class);
        Mockito.when(game.isGameDraw()).thenReturn(false);
        Mockito.when(game.isGameWon()).thenReturn(false);
        GameRunner noInputLeftGameRunner = new GameRunner(game);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput.getBytes());
        Assertions.assertThrows(NoSuchElementException.class, ()-> noInputLeftGameRunner.runGame(byteArrayInputStream));
    }
}
