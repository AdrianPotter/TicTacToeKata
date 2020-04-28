import java.io.InputStream;
import java.util.Scanner;

public class GameRunner {

    private Game game;
    private InputStream inputStream;

    public GameRunner(){
        this.game = new Game();
        this.inputStream = System.in;
    }

    public GameRunner(Game game, InputStream inputStream){
        this.game = game;
        this.inputStream = inputStream;
    }

    public void runGame(){
        while(!game.currentPlayerHasWon() && !game.gameIsADraw()){
            game.switchPlayer();
            while(true){
                try{
                    game.placeMove(takeUserInput());
                    break;
                }catch(IllegalArgumentException e){
                    continue;
                }
            }
        }
    }

    public int takeUserInput(){
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt();
    }



}
