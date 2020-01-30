import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class GameTest {

    @Test
    void gameStartsTest() {
        new Game();
        mock(Board.class);
    }
}
