import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

class GameTest {

  @Test
  void gameStartsTest() {
    List<Integer> coordinates = List.of(1, 1);
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
