import java.io.InputStream;
import java.util.Scanner;

public class Game {

  private int playerx;
  private int playery;
  private int currentPlayer;

  public static void main(String[] args) {
    new Game(System.in);
  }

  public Game(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream);
    Board board = new Board();
    switchPlayer();

    while (gameHasNotEnded(board)) {
      switchPlayer();
      do {
        getPlayerMove(scanner);
        notifyPlayerIfMoveInvalid(board);
      } while (!board.isValidMove(playerx, playery));
      board.placeMove(playerx, playery, currentPlayer);
    }
    notifyResult(board);
  }

  private boolean gameHasNotEnded(Board board) {
    return !board.playerHasWon(currentPlayer) && board.hasEmptyCell();
  }

  private void switchPlayer() {
    int player1 = 1;
    int player2 = 2;
    currentPlayer = currentPlayer == player1 ? player2 : player1;
  }

  private void notifyResult(Board board) {
    if (board.playerHasWon(currentPlayer)) {
      System.out.println("Congrats Player " + currentPlayer);
    } else {
      System.out.println("Game ends in a draw.");
    }
  }

  private void notifyPlayerIfMoveInvalid(Board board) {
    if (!board.isValidMove(playerx, playery)) {
      System.out.println("Invalid Move!");
    }
  }

  private void getPlayerMove(Scanner scanner) {
    System.out.println("Player " + currentPlayer + " enter move - x co-ord:");
    playerx = scanner.nextInt();
    System.out.println("Player " + currentPlayer + " enter move - y co-ord:");
    playery = scanner.nextInt();
  }
}