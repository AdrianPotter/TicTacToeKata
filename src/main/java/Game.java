import javax.swing.text.html.Option;
import java.sql.SQLOutput;
import java.util.Optional;
import java.util.Scanner;



public class Game {

    public static  void main(String[] args){
        new Game().match();
    }


    public Integer winner() {
        return null;
    }

    public void match () {
        int player1 = 1;
        int player2 = 2;
        int curPlayer = player1;
        int count = 0;
        int playerx = 0;
        int playery = 0;
        Board board = new Board();

        Scanner scanner = new Scanner(System.in);

        while (count < 9) {
            do {
                System.out.printf("Player %d Input x\n", curPlayer);
                playerx = scanner.nextInt();
                System.out.printf("Player %d Input y\n", curPlayer);
                playery = scanner.nextInt();
            } while (!board.checkIfLegal(playerx, playery));
            board.placeMove(playerx, playery, curPlayer);
            if (checkWin(curPlayer, board)) {
                break;
            }
            curPlayer = nextPlayer(player1, player2, curPlayer);
            count++;
        }
        if (checkWin(curPlayer, board)) {
            System.out.printf("Congrats Player %d\n", curPlayer);
        }
        else {
            System.out.println("Draw");
        }
    }

    private int nextPlayer(int player1, int player2, int curPlayer) {
        return curPlayer == player1 ? player2 : player1;
    }

    private boolean checkWin(int curPlayer, Board board)
    {
        for(int i = 0; i < 3; i++) {
            if (board.getCell(0,i) == curPlayer && board.getCell(1,i) ==curPlayer && board.getCell(2,i) == curPlayer){
                return true;
            }
            if (board.getCell(i,0) == curPlayer && board.getCell(i, 1) ==curPlayer && board.getCell(i, 2) == curPlayer){
                return true;
            }
        }
        if (board.getCell(0,0) == curPlayer && board.getCell(1,1) ==curPlayer && board.getCell(2,2) == curPlayer){
            return true;
        }
        if (board.getCell(0,2) == curPlayer && board.getCell(1,1) ==curPlayer && board.getCell(2,0) == curPlayer){
            return true;
        }
        return false;
    }
}