package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<Animal> animals = new ArrayList<Animal>();
    protected Object[] walkable = {Grass.class};

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!coordinateOnMap(position)) return false;
        if (isOccupied(position)){
            Object obj_clas = objectAt(position).getClass();
            for (Object elem: walkable) {
                if(elem.equals(obj_clas)) return true;
            }
            return false;
        }
        return true;
    }
    protected abstract boolean coordinateOnMap(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return  objectAt(position) != null;
    }

    @Override
    public abstract Object objectAt(Vector2d position);

    protected abstract Vector2d[] mapSize();

    @Override
    public String toString() {
        Vector2d[] corners = mapSize();
        return new MapVisualizer(this).draw(corners[0], corners[1]);
    }
}
