import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Scanner;

public class Game {
    public Integer winner() {
        return null;
    }

    public void match () {
        int player1 = 1;
        int player2 = 2;
        int curPlayer = player1;
        int count = 0;
        int playerx = -1;
        int playery = -1;
        Board board = new Board();

        Scanner scanner = new Scanner(System.in);

        while(count < 9){
            while(board.checkIfLegal(playerx, playery)) {
                System.out.printf("Player %d Input x\n", curPlayer);
                playerx = scanner.nextInt();
                System.out.printf("Player %d Input y\n", curPlayer);
                playery = scanner.nextInt();
            }
            board.placeMove(playerx, playery, curPlayer);
            curPlayer = nextPlayer(player1, player2, curPlayer);
            count++;
        }
    }

    private int nextPlayer(int player1, int player2, int curPlayer) {
        return curPlayer == player1 ? player2 : player1;
    }
}