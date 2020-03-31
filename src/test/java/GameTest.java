import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class GameTest {

  private Game game;

  @BeforeEach
  private void Setup() {
    game = new Game();
  }

  @Test
  void noErrorWhenSwitchPlayerMethodCalled() {
      game.switchCurrentPlayer();
  }

  @Test
  void userInputIsReturned() {
    String mockUserInput = "0";
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput.getBytes());
    Assertions.assertEquals(0, game.takeUserInput(byteArrayInputStream));
  }

}
