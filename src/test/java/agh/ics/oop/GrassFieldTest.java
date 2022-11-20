package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class GrassFieldTest {
    @Test
    public void canMoveToTest(){
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(2,2)));

        assertTrue(map.canMoveTo(new Vector2d(-100000,100000)));
        assertTrue(map.canMoveTo(new Vector2d(50,6000)));
        assertTrue(map.canMoveTo(new Vector2d(2,-2)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    public void placeTest(){
        IWorldMap map = new GrassField(30);
        Animal ani1 = new Animal(map,new Vector2d(2,2));
        Animal ani2 = new Animal(map,new Vector2d(7,2));
        Animal ani3 = new Animal(map,new Vector2d(2,2));
        assertTrue(map.place(ani1));
        assertEquals(map.objectAt(new Vector2d(2,2)), ani1);
        assertTrue(map.place(ani2));
        assertEquals(map.objectAt(new Vector2d(7, 2)), ani2);
        boolean wasThrown = false;
        try {
            map.place(ani3);
        }
        catch (IllegalArgumentException illegalArgumentException){
            wasThrown = true;
        }
        assertTrue(wasThrown);
        assertEquals(map.objectAt(new Vector2d(2,2)), ani1);
    }

    @Test
    public void isOccupiedTest(){
        IWorldMap map = new GrassField(20);
        map.place(new Animal(map, new Vector2d(200,200)));

        for (int i = 0; i < 10; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(20*10));
            int y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(20*10));
            Vector2d coordinates = new Vector2d(x,y);
            if (map.objectAt(coordinates) != null){
                assertTrue(map.isOccupied(coordinates));
            }
            else assertFalse(map.isOccupied(coordinates));

        }

        assertTrue(map.isOccupied(new Vector2d(200, 200)));
    }

    @Test
    public void objectAtTest(){
        IWorldMap map = new GrassField(10);
        Animal ani1 = new Animal(map, new Vector2d(200,200));
        map.place(ani1);
        int grasses = 0;

        for (int i = 0; i <= (int) Math.sqrt(10*10)+1; i++) {
            for (int j = 0; j <= (int) Math.sqrt(10 * 10) + 1; j++) {
                Vector2d coordinates = new Vector2d(i,j);
                if (map.objectAt(coordinates) != null && map.objectAt(coordinates).getClass() == Grass.class) grasses++;
            }
        }
        assertEquals(10, grasses);
        assertEquals(map.objectAt(new Vector2d(200, 200)), ani1);
        assertNull(map.objectAt(new Vector2d(201, 200)));
    }
}
