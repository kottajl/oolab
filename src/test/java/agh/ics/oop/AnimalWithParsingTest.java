package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AnimalWithParsingTest {
    private OptionsParser myParser= new OptionsParser();
    private IWorldMap myMap= new RectangularMap(0, 0);

    // Musiałem wykomentować, bo testy te były pisane, gdy nie używałem mapy. Teraz te testy
    // sprawdzałyby tylko niepoprawną aktualnie implementację.
    /*@Test
    public void test1 () {
        Animal cat= new Animal(null);
        String[] str= {"forward", "forward", "backward", "left", "backward"};
        MoveDirection[] orders= myParser.parse(str);
        for (MoveDirection x: orders)
            cat.move(x);
        assertTrue(cat.isAt(new Vector2d(3, 3)));
    }

    @Test
    public void test2 () {
        Animal dog= new Animal(null);
        String[] str= {"f", "r", "f", "f", "f", "f", "r", "b", "b", "l", "b"};
        MoveDirection[] orders= myParser.parse(str);
        for (MoveDirection x: orders)
            dog.move(x);
        assertTrue(dog.isAt(new Vector2d(3, 4)));
    }

    @Test
    public void test3 () {
        Animal cow= new Animal(null);
        String[] str= {"backward", "jump", "left", "forward", "right", "eatGrass"};
        MoveDirection[] orders= myParser.parse(str);
        for (MoveDirection x: orders)
            cow.move(x);
        assertTrue(cow.isAt(new Vector2d(1, 1)));
    }

    @Test
    public void test4 () {
        Animal snake= new Animal(null);
        String[] str= {"f", "backward", "b", "backward", "l", "f", "forward", "right"};
        MoveDirection[] orders= myParser.parse(str);
        for (MoveDirection x: orders)
            snake.move(x);
        assertTrue(snake.isAt(new Vector2d(0, 0)));
    }*/

}
