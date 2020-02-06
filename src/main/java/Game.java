import java.io.InputStream;
import java.util.Scanner;

public class Game {

  private final int player1 = 1;
  private final int player2 = 2;
  int playerx;
  int playery;
  int currentPlayer = player1;

  public static void main(String[] args) {
    new Game(System.in);
  }

  public Game(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream);
    Board board = new Board();
    do {
      playerx = scanner.nextInt();
      playery = scanner.nextInt();
    } while ((!board.isValidMove(playerx, playery)));
    board.placeMove(playerx, playery, currentPlayer);

  }
}