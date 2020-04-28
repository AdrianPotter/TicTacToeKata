import java.io.InputStream;
import java.util.Scanner;

public class GameRunner {

  private Game game;

  public GameRunner() {
    this.game = new Game();
  }

  public GameRunner(Game game) {
    this.game = game;
  }

  public void runGame(InputStream inputStream) {

    while (!game.isGameDraw()) {
      int userInput = game.takeUserInput(inputStream);
      game.placeUserMove(userInput);
      if (game.isGameWon()) {
        break;
      }
      game.switchCurrentPlayer();
    }

  }

    public int takeUserInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt();
    }
}
