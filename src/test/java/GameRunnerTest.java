import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameRunnerTest {

    @Test
    void userInputIsReturned() {
        Game game = new Game();
        String mockInput = "0";
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());

        GameRunner gameRunner = new GameRunner(game, mockInputStream);

        assertEquals(0, gameRunner.takeUserInput());
    }
}
