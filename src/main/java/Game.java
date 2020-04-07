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

    public boolean isMoveValid(int userInput){
        return grid.isValidMove(userInput, currentPlayer.getSymbol());
    }

    public void placeUserMove(int userInput){
        grid.placeMove(userInput, currentPlayer.getSymbol());
    }

    public void switchCurrentPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

}
