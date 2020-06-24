import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;

public class GameRunnerTest {

    @Test
    void canRunGameWithOneMove() {
        Game game = mock(Game.class);
        String mockInput = "0";
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());

        new GameRunner(game, mockInputStream);
    }
}
