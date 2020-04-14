import java.io.InputStream;
import java.util.Scanner;

public class Game {

    private final Player player1 = new Player("Player One", Symbol.X);
    private final Player player2 = new Player("Player Two", Symbol.O);
    private Player currentPlayer = player1;
    private Grid grid = new Grid();

    public int takeUserInput(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt();
    }

    private boolean isValidMove(int userInput){
        return grid.isValidMove(userInput, currentPlayer.getSymbol());
    }

    public void placeUserMove(int userInput){
        if ( isValidMove(userInput)){
            grid.placeMove(userInput, currentPlayer.getSymbol());
        }
        else{
            throw new IllegalArgumentException("Move is invalid: " + userInput);
        }
    }

    public void switchCurrentPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public boolean isGameWon() {
        return grid.checkWinner(currentPlayer.getSymbol());
    }


}
