import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void playerIsInstantiatedWithoutError() {
        Player player = new Player("AName", 'X');
    }
}
