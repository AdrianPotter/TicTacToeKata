import java.io.InputStream;

public class GameRunner {

    private Game game;

    public GameRunner(){
        this.game = new Game();
    }

    public GameRunner(Game game){
        this.game = game;
    }

    public void runGame(InputStream inputStream){

        int userInput = game.takeUserInput(inputStream);
        game.isMoveValid(userInput);

    }
}
