import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

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
            safePlaceMove();
        }
    }

    private void safePlaceMove() {
        while (true) {
            try {
                game.placeMove(takeUserInput());
                break;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
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
