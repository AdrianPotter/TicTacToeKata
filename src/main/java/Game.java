import java.util.Scanner;

public class Game {

    private final Player player1 = new Player("Player One", Symbol.X);
    private final Player player2 = new Player("Player Two", Symbol.O);
    private Player currentPlayer = player1;

    public Game(){
    }

    public void play(){

        System.out.println(player1.getName() + " Please Enter Input: ");
        int playerMove = takeUserInput();
        switchCurrentPlayer();

    }

    public int takeUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void switchCurrentPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

}
