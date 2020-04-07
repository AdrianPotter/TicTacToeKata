import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class GameRunnerTest {

    GameRunner gameRunner;

    @BeforeEach
    void setup(){
        gameRunner = new GameRunner();
    }

    @Test
    void shouldRunGame(){
        String mockUserInput = "0";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput.getBytes());
        gameRunner.runGame(byteArrayInputStream);
    }
}
