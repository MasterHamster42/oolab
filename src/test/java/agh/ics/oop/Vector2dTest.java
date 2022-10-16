package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equals() {
        Vector2d vector1 = new Vector2d(1, 3);
        Vector2d vector2 = new Vector2d(1, 3);
        Vector2d vector3 = new Vector2d( 4, -2);

        System.out.println("Vector2dTest.equals");
        assertEquals(vector1.equals(vector2), true);
        assertEquals(vector1.equals(vector3), false);

    }
    @Test
    public void toStringTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 100);
        System.out.println("Vector2dTest.toString");
        assertEquals(vector1.toString(), "(1,2)");
        assertEquals(vector2.toString(), "(-1,100)");
    }
    @Test
    void precedes(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 4);
        Vector2d vector3 = new Vector2d(-2, 4);
        System.out.println("Vector2dTest.precedes");
        assertEquals(vector1.precedes(vector2), true);
        assertEquals(vector1.precedes(vector3), false);
    }
    @Test
    void follows(){
        Vector2d vector1 = new Vector2d(3, 6);
        Vector2d vector2 = new Vector2d(2, 4);
        Vector2d vector3 = new Vector2d(4, 4);
        System.out.println("Vector2dTest.follows");
        assertEquals(vector1.follows(vector2), true);
        assertEquals(vector1.follows(vector3), false);
    }
    @Test
    void upperRight(){
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(2, 4);
        Vector2d vector4 = new Vector2d(5, -4);
        Vector2d vector5 = new Vector2d(5, 4);
        System.out.println("Vector2dTest.upperRight");
        assertEquals(vector1.upperRight(vector2),vector3);
        assertEquals(vector3.upperRight(vector4),vector5);
    }
    @Test
    void lowerLeft(){
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(2, -1);
        Vector2d vector3 = new Vector2d(1, -1);
        Vector2d vector4 = new Vector2d(-2, 400);
        Vector2d vector5 = new Vector2d(-2, -1);
        System.out.println("Vector2dTest.lowerLeft");
        assertEquals(vector1.lowerLeft(vector2), vector3);
        assertEquals(vector3.lowerLeft(vector4), vector5);
    }
    @Test
    void add(){
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(3, 5);
        Vector2d vector4 = new Vector2d(-3, 500);
        Vector2d vector5 = new Vector2d(0, 505);
        System.out.println("Vector2dTest.add");
        assertEquals(vector1.add(vector2), vector3);
        assertEquals(vector3.add(vector4), vector5);
    }
    @Test
    void subtract(){
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(-1, 3);
        Vector2d vector4 = new Vector2d(3, -2);
        System.out.println("Vector2dTest.subtract");
        assertEquals(vector1.subtract(vector2), vector3);
        assertEquals(vector2.subtract(vector3), vector4);
    }
    @Test
    void opposite(){
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(-1, -4);
        Vector2d vector3 = new Vector2d(0, -4);
        Vector2d vector4 = new Vector2d(0, 4);
        System.out.println("Vector2dTest.opposite");
        assertEquals(vector1.opposite(), vector2);
        assertEquals(vector3.opposite(), vector4);
    }

}


