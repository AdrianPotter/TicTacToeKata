import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

class GameTest {

  @Test
  void exceptionThrownIfNoMovesGiven() {
    List<Integer> coordinates = List.of();
    Assertions.assertThrows(NoSuchElementException.class, () -> {
      new Game(getInputStreamFromList(coordinates));
    });
  }

  @Test
  void playerSwitchedAfterTurn() {
    List<Integer> coordinates = List.of(0, 0, 1, 1, 2, 2);
    Assertions.assertThrows(NoSuchElementException.class, () -> {
      new Game(getInputStreamFromList(coordinates));
    });
  }

  @Test
  void playerCanWin() {
    List<Integer> coordinates = List.of(0, 0, 0, 1, 1, 1, 1, 0, 2, 2);
    new Game(getInputStreamFromList(coordinates));
  }

  @Test
  void gameEndsInDraw() {
    List<Integer> coordinates = List.of(
            1, 1,
            0, 0,
            0, 1,
            2, 1,
            1, 0,
            1, 2,
            0, 2,
            2, 0,
            2, 2
    );
    new Game(getInputStreamFromList(coordinates));
  }


  private <T> InputStream getInputStreamFromList(List<T> coordinates) {
    return new ByteArrayInputStream(
            coordinates
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("\n"))
                    .getBytes()
    );
  }


}
