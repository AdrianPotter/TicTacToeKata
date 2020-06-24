import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void playerIsInstantiatedWithoutError() {
        new Player("AName", 'X');
    }
}
