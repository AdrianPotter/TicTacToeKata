import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void newGamesHaveNoWinner() {
        Optional<Integer> winner = new Game().winner();
        assertTrue(winner.isEmpty());
    }
}
