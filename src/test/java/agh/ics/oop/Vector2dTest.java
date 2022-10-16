package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Vector2dTest {
    Vector2d v1= new Vector2d(1, 0);

    @Test
    public void checkEquals () {
        assertTrue(v1.equals(new Vector2d(1, 0)));
        assertFalse(v1.equals(new Vector2d(1, 1)));
        assertFalse(v1.equals((MoveDirection.BACKWARD)));
    }

    @Test
    public void checkToString () {
        assertEquals(v1.toString(), "(1,0)");
    }

    @Test
    public void checkPrecedes () {
        assertTrue(v1.precedes(new Vector2d(1, 0)));
        assertFalse(v1.precedes(new Vector2d(-1, 0)));
        assertTrue(v1.precedes(new Vector2d(2, 3)));
        assertFalse(v1.precedes(new Vector2d(0, 1)));
    }

    @Test
    public void checkFollows () {
        assertTrue(v1.follows(new Vector2d(1, 0)));
        assertTrue(v1.follows(new Vector2d(-1, 0)));
        assertFalse(v1.follows(new Vector2d(2, 3)));
        assertFalse(v1.follows(new Vector2d(0, 1)));
    }

    @Test
    public void checkUpperRight () {
        assertEquals(v1.upperRight(new Vector2d(0, 3)), new Vector2d(1, 3));
        assertEquals(v1.upperRight(new Vector2d(1, 0)), v1);
    }

    @Test
    public void checkLowerLeft () {
        assertEquals(v1.lowerLeft(new Vector2d(0, 3)), new Vector2d(0, 0));
        assertEquals(v1.lowerLeft(new Vector2d(1, 0)), v1);
    }

    @Test
    public void checkAdd () {
        assertEquals(v1.add(new Vector2d(1, 3)), new Vector2d(2, 3));
    }

    @Test
    public void checkSubtract () {
        assertEquals(v1.subtract(new Vector2d(1, 3)), new Vector2d(0, -3));
    }

    @Test
    public void checkOpposite () {
        assertEquals(v1.opposite(), new Vector2d(-1, 0));
    }

}
