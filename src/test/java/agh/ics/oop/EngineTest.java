package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {
    /**
     * Zawartość identyczna jak w klasie MapDirectionTest - średnio da się przetestować jedno
     *  nie kierzystając jednocześnie z drugiego (pomijam w ogóle korzystanie z klasy GrassField,
     *  bo jest ona bardziej skomplikowana).
     */

    // one animal - basic test with incorrect input
    // one animal - basic test with incorrect input
    @Test
    public void test1 () {
        try {
            String[] args = {"f", "r", "f", "o"};
            Vector2d[] positions = {new Vector2d(1, 0)};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(4, 5);

            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            Vector2d[] goodOutput = {new Vector2d(2, 1)};
            for (int i = 0; i < positions.length; i++)
                assertEquals(positions[i], goodOutput[i]);
            //System.out.println(map);

            assertTrue(false);
        }
        catch (IllegalArgumentException ex) {
            //System.out.println(ex);
            assertTrue(true);
        }
    }

    // two animals - without confrontation
    @Test
    public void test2 () {
        try {
            String[] args = {"f", "b", "f", "b", "l", "l", "b", "f", "b", "f", "l", "r"};
            Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(2, 2)};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(3, 3);

            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            Vector2d[] goodOutput = {new Vector2d(2, 2), new Vector2d(0, 0)};
            for (int i = 0; i < positions.length; i++)
                assertEquals(positions[i], goodOutput[i]);
            //System.out.println(map);
        }

        catch (IllegalArgumentException ex) {
            //System.out.println(ex);
            assertTrue(false);
        }
    }

    // two animals - with confrontation and testing borders
    @Test
    public void test3 () {
        try {
            String[] args = {"r", "f", "f", "b", "b", "f", "b", "f"};
            Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(1, 0)};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(2, 3);

            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            Vector2d[] goodOutput = {new Vector2d(0, 0), new Vector2d(1, 2)};
            for (int i = 0; i < positions.length; i++)
                assertEquals(positions[i], goodOutput[i]);
            //System.out.println(map);
        }
        catch (IllegalArgumentException ex) {
            //System.out.println(ex);
            assertTrue(false);
        }
    }

    // three animals - with confrontation and testing borders
    @Test
    public void test4 () {
        try {
            String[] args = {"l", "b", "r", "b", "f", "r", "f", "f", "f", "r", "f", "l", "f", "f", "b"};
            Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(1, 1), new Vector2d(1, 0)};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(4, 4);

            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            Vector2d[] goodOutput = {new Vector2d(0, 1), new Vector2d(1, 3), new Vector2d(0, 0)};
            for (int i = 0; i < positions.length; i++)
                assertEquals(positions[i], goodOutput[i]);
            //System.out.println(map);
        }
        catch (IllegalArgumentException ex) {
            //System.out.println(ex);
            assertTrue(false);
        }
    }

}
