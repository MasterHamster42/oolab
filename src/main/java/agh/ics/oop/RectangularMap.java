package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{

    private Vector2d size;

    public RectangularMap(int width, int height){
        this.size = new Vector2d(width, height);
    }

    @Override
    protected boolean coordinateOnMap(Vector2d position) {
        return position.precedes(this.size) && position.follows(new Vector2d(0,0));
    }

//    @Override
//    public Object objectAt(Vector2d position) {
//        for (Animal animal: animals) {
//            if (animal.isAt(position)) return animal;
//        }
//        return null;
//    }

    @Override
    public Vector2d[] mapSize() {
        return new Vector2d[]{new Vector2d(0,0), this.size};
    }

}
