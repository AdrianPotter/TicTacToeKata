import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

public class GameRunnerTest {

    @Test
    void userInputIsReturned(){
        String mockInput = "0";
        Game game = new Game();
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());
        GameRunner gameRunner = new GameRunner(game, mockInputStream);
        Assertions.assertTrue(gameRunner.takeUserInput() == 0);
    }
}
