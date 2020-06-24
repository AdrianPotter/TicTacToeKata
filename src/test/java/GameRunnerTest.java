import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class GameRunnerTest {

    @Test
    void canRunGameWithOneMove() {
        Game game = new Game();
        String mockInput = "0";
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());

        new GameRunner(game, mockInputStream);
    }
}
