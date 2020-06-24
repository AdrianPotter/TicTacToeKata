import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class GameRunnerTest {

    @Test
    void userInputIsReturned(){
        String mockInput = "0";
        Game game = new Game();
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());
        GameRunner gameRunner = new GameRunner(game, mockInputStream);
        Assertions.assertEquals(0, gameRunner.takeUserInput());
    }
}
