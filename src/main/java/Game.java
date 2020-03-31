import java.util.Scanner;

public class Game {

    public Game(){

    }

    private void playGame(){
        Player player1 = new Player("Player One", Symbol.X);
        Player player2 = new Player("Player Two", Symbol.O);
        Player currentPlayer = player1;
        System.out.println(player1.getName() + " Please Enter Input: ");

    }


    private int takeUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
