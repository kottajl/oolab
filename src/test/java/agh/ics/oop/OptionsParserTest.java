package agh.ics.oop;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionsParserTest {

    //test1 - good input
    @Test
    public void test1 () {
        String[] args= {"f", "r", "f", "b", "l"};
        MoveDirection[] goodDirections= {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.BACKWARD, MoveDirection.LEFT};
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            assertTrue(Arrays.equals(directions, goodDirections));
        }
        catch (IllegalArgumentException ex) {
            //System.out.println(ex);
            assertTrue(false);
        }
    }

    //test2 - bad input
    @Test
    public void test2 () {
        String[] args= {"f", "r", "f", "x", "l", "?"};
        MoveDirection[] goodDirections= {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.LEFT};
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            assertTrue(Arrays.equals(directions, goodDirections));
        }
        catch (IllegalArgumentException ex) {
            //System.out.println(ex);
            assertTrue(true);
        }
    }
}
