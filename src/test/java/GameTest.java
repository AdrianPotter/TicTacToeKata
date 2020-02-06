import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.InputStreamReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.mock;

class GameTest {

    private Scanner scanner;

    @BeforeEach
    public void setup() {

        //scanner = mock(Scanner.class);
    }

    @Test
    void gameStartsTest() {
        List<Integer> moves = new ArrayList<>();
        moves.add(1);
        moves.add(1);
        Game game = new Game(moves);
    }

    @Test
    void playerChangesAfterPlacingMoveTest() {
        List<Integer> moves = new ArrayList<>();
        moves.add(0);
        moves.add(0);
        moves.add(1);
        moves.add(1);
        moves.add(2);
        moves.add(2);
        Game game = new Game(moves);

    }

//    @Test
//    void gameStartsTest() {
//        String data = "";
//        InputStream stdin = System.in;
//        try {
//            System.setIn(new ByteArrayInputStream(data.getBytes()));
//            scanner = new Scanner(System.in);
//            new Game(scanner);
//        } finally {
//            System.setIn(stdin);
//        }
//
//
//    }
}
