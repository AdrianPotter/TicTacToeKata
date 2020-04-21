import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

public class GameRunnerTest {

  GameRunner gameRunner;

  @BeforeEach
  void setup() {
    gameRunner = new GameRunner();
  }

  @Test
  void shouldRunGame() {
    String mockUserInput = "0";
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput.getBytes());
    gameRunner.runGame(byteArrayInputStream);
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

}
