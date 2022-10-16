package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void next(){
        MapDirection[] directions = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};
        System.out.println("MapDirectionTest.next:");
        for (int i=0; i<directions.length; i++) {
            if(! (directions[i].next() == directions[(i+1)%directions.length])) System.out.println("Case "+Integer.toString(i)+" failed");
            else System.out.println("Case "+Integer.toString(i)+" passed");
        }
    }

    @Test
    public void previous(){
        MapDirection[] directions = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};
        System.out.println("MapDirectionTest.previous:");
        for (int i=0; i<directions.length; i++) {
            if(! (directions[i].previous() == directions[(directions.length + i-1)%directions.length])) System.out.println("Case "+Integer.toString(i)+" failed");
            else System.out.println("Case "+Integer.toString(i)+" passed");
        }
    }
}
