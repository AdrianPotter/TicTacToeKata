import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Game {


  Board board = new Board();


  private final int player1 = 1;
  private final int player2 = 2;
  int playerx;
  int playery;
  int currentPlayer = player1;

  public static void main(String[] args) {
    List<Integer> moves = new ArrayList<>();
    Game game = new Game(moves);
  }

  public Game(List moves) {

    do {
      playerx = getNextMove(moves);
      playery = getNextMove(moves);
    } while ((!board.isValidMove(playerx, playery)));
    board.placeMove(playerx, playery, currentPlayer);

  }

  private Integer getNextMove(List<Integer> moves){
      Integer move = moves.get(0);
      moves.remove(0);
      return move;


  }

}