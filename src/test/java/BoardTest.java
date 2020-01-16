import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    void isValidMoveTest(){
        assertTrue(board.isValidMove(0,0));
    }

    @Test
    void isNotValidMoveTest(){
        assertFalse(board.isValidMove(-1,0));
    }
}
