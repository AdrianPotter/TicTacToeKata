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

    public boolean

    public void switchCurrentPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

}
