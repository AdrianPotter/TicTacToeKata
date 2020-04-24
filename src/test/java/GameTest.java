import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GameTest {
    Game game;
    private final int GRIDSIZE = 9;
    @BeforeEach
    void setup(){
        game = new Game();
    }
    @Test
    void outOfBoundsMoveIsInvalid(){
        Assertions.assertFalse(game.isValidMove(-1));
        Assertions.assertFalse((game.isValidMove(9)));
    }

    @Test
    void inBoundsAndEmptyCellIsValidMove(){
        Assertions.assertTrue(game.isValidMove(0));
    }

    @Test
    void inBoundsAndNotEmptyCellIsInvalidMove(){
        game.placeMove(0);
        Assertions.assertFalse(game.isValidMove(0));
    }

    @Test
    void moveIsPlacedOnBoard(){
        game.placeMove(0);
    }

    @Test
    void invalidMoveThrowsExceptionWhenPlaced(){
        game.placeMove(0);
        Assertions.assertThrows(IllegalArgumentException.class,() -> game.placeMove(0));
    }

    @Test
    void playerIsSwitched(){
        Player player = game.getCurrentPlayer();
        game.switchPlayer();
        Assertions.assertFalse(game.getCurrentPlayer() == player);
    }

    @Test
    void gameIsDrawIfNoEmptyCellsLeft(){
        for(int i = 0; i < GRIDSIZE; i++){
            game.placeMove(i);
        }
        Assertions.assertTrue(game.gameIsADraw());
    }

    @Test
    void noWinnerIfNoConditionsMet(){
        game.placeMove(0);
        game.placeMove(2);
        game.placeMove(6);
        game.placeMove(8);
        Assertions.assertFalse(game.currentPlayerHasWon());
    }

    @Test
    void playerHasWonIfConditionsMet(){
        game.placeMove(0);
        game.placeMove(1);
        game.placeMove(2);
        Assertions.assertTrue(game.currentPlayerHasWon());
    }


}
