import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


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
  void noErrorWhenPlaceValidUserMove() {
    game.placeUserMove(1);
  }

  @Test
  void errorThrownWhenPlaceInvalidUserMove() {
    Assertions.assertThrows(IllegalArgumentException.class, () ->  game.placeUserMove(-1));
  }

  @Test
  void noWinnerWhenNoMovePlaced() {
    Assertions.assertFalse(game.isGameWon());
  }

  @Test
  void winnerWhenWinningConditionMet() {
    Grid grid = Mockito.mock(Grid.class);
    Mockito.when(grid.checkWinner(Symbol.X)).thenReturn(true);
    Game winningGame = new Game(grid);
    Assertions.assertTrue(winningGame.isGameWon());
  }

  @Test
  void drawWhenDrawConditionMet() {
    Grid grid = Mockito.mock(Grid.class);
    Mockito.when(grid.checkDraw()).thenReturn(true);
    Game drawnGame = new Game(grid);
    Assertions.assertTrue(drawnGame.isGameDraw());
  }
}
