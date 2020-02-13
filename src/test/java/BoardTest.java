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
    void isValidMoveTopLeftTest(){
        assertTrue(board.isValidMove(0,0));
    }

    @Test
    void isOutOfBoundsLeftTest(){
        assertFalse(board.isValidMove(-1,0));
    }

    @Test
    void isValidMoveBottomRightTest(){
        assertTrue(board.isValidMove(2,2));
    }

    @Test
    void isOutOfBoundsRightTest(){
        assertFalse(board.isValidMove(3,0));
    }

    @Test
    void isOutOfBoundsTopTest(){
        assertFalse(board.isValidMove(0,-1));
    }

    @Test
    void isOutOfBoundsBottomTest(){
        assertFalse(board.isValidMove(0,3));
    }

    @Test
    void placeMoveTest(){
        board.placeMove(1, 1, 1);
        assertFalse(board.isValidMove(1,1));
    }

    @Test
    void placeMoveAgainTest(){
        board.placeMove(1, 1, 1);
        board.placeMove(1, 1, 0);
        assertTrue(board.isValidMove(1,1));
    }

    @Test
    void playerOneHasWonTest() {
        board.placeMove(0,0,1);
        board.placeMove(1,1,1);
        board.placeMove(2,2,1);
        assertTrue(board.playerHasWon(1));
        assertFalse(board.playerHasWon(2));
    }

    @Test
    void neitherPlayerHasWonTest() {
        board.placeMove(0,0,1);
        board.placeMove(1,1,2);
        board.placeMove(2,2,1);
        assertFalse(board.playerHasWon(1));
        assertFalse(board.playerHasWon(2));
    }

    @Test
    void noWinnerAfterNoMoves(){
        assertFalse(board.playerHasWon(1));
        assertFalse(board.playerHasWon(2));
    }


}
