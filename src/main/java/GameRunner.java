import java.io.InputStream;
import java.util.Scanner;

//TODO: Low test coverage
public class GameRunner {

    private Game game;
    private Scanner scanner;

    public GameRunner() {
        this(new Game(), System.in);
    }

    public GameRunner(Game game, InputStream inputStream) {
        this.game = game;
        this.scanner = new Scanner(inputStream);
    }

    public void runGame() {
        while (!game.currentPlayerHasWon() && !game.gameIsADraw()) {
            game.switchPlayer();
            while (true) {
                try {
                    game.placeMove(takeUserInput());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private int takeUserInput() {
        System.out.println("Enter move: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        new GameRunner().runGame();
    }

}
