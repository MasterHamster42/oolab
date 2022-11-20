package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    public void canMoveToTest(){
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(2,2)));

        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(map.canMoveTo(new Vector2d(5,5)));
        assertTrue(map.canMoveTo(new Vector2d(2,1)));

        assertFalse(map.canMoveTo(new Vector2d(-1,0)));
        assertFalse(map.canMoveTo(new Vector2d(6, 1)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    public void placeTest(){
        IWorldMap map = new RectangularMap(5, 5);
        Animal ani1 = new Animal(map,new Vector2d(2,2));
        Animal ani2 = new Animal(map,new Vector2d(7,2));
        Animal ani3 = new Animal(map,new Vector2d(2,2));
        assertTrue(map.place(ani1));
        assertEquals(map.objectAt(new Vector2d(2,2)), ani1);
        boolean wasThrown1 = false;
        try {
            map.place(ani2);
        }
        catch (IllegalArgumentException illegalArgumentException){
            wasThrown1 = true;
        }
        assertTrue(wasThrown1);
        assertNull(map.objectAt(new Vector2d(7, 2)));
        boolean wasThrown2 = false;
        try {
            map.place(ani3);
        }
        catch (IllegalArgumentException illegalArgumentException){
            wasThrown2 = true;
        }
        assertTrue(wasThrown2);
        assertEquals(map.objectAt(new Vector2d(2,2)), ani1);
    }

    @Test
    public void isOccupiedTest(){
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(2,2)));

        assertFalse(map.isOccupied(new Vector2d(0,0)));
        assertFalse(map.isOccupied(new Vector2d(5,5)));
        assertFalse(map.isOccupied(new Vector2d(2,1)));
        assertFalse(map.isOccupied(new Vector2d(-1,0)));
        assertFalse(map.isOccupied(new Vector2d(6, 1)));

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void objectAtTest(){
        IWorldMap map = new RectangularMap(5, 5);
        Animal ani1 = new Animal(map,new Vector2d(2,2));
        Animal ani2 = new Animal(map,new Vector2d(7,2));
        assertTrue(map.place(ani1));
        assertEquals(map.objectAt(new Vector2d(2,2)), ani1);
        assertFalse(map.place(ani2));
        assertNull(map.objectAt(new Vector2d(7, 2)));
    }
}
