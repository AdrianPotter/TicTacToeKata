import java.util.Optional;
import java.util.Scanner;

public class Game {


    Board board = new Board();


    private final int player1 = 1;
    private final int player2 = 2;
    int playerx;
    int playery;
    int currentPlayer = player1;

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Game game = new Game();
    }

    public Game()
    {
        do {
            playerx = nextInt(1);
            playery = nextInt(2);
        }while((!board.isValidMove(playerx, playery)));
        board.placeMove(playerx, playery, currentPlayer);

    }

    private int nextInt(int value){
        return value;
    }
}