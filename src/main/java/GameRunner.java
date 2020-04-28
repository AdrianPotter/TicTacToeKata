import java.io.InputStream;
import java.util.Scanner;

public class GameRunner {

  private Game game;

  public static void main(String[] args) {
    GameRunner gameRunner = new GameRunner();
    gameRunner.runGame(System.in);
  }

  public GameRunner() {
    this.game = new Game();
  }

  public GameRunner(Game game) {
    this.game = game;
  }

  public void runGame(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream);
    while (!game.isGameDraw()) {
      displayMessage("Please Enter Move: ");
      int userInput = takeUserInput(scanner);
      while() {
        try {
          game.placeUserMove(userInput);
        } catch (IllegalArgumentException e) {
          displayMessage(e.toString());
        }
      }
      if (game.isGameWon()) {
        displayMessage("Congratulations you have won!");
        break;
      }
      game.switchCurrentPlayer();
    }
    if(game.isGameDraw()){
      displayMessage("Game has ended in a draw!");
    }
  }

    private void displayMessage(String string) {
      System.out.println(string);
    }

    private int takeUserInput(Scanner scanner) {
        return scanner.nextInt();
    }
}
