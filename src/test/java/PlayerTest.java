import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  @Test
  void canCreateAPlayer() {
    Player player = new Player("John", "X");
    Assertions.assertNotNull(player);
  }

  @Test
  void canGetName(){
    String playerName = "Steve";
    Player player = new Player(playerName, "X");
    Assertions.assertEquals(playerName, player.getName());
  }

  @Test
  void canGetSymbol(){
    String playerSymbol = "X";
    Player player = new Player("Steve", playerSymbol);
    Assertions.assertEquals(playerSymbol, player.getSymbol());
  }
}
