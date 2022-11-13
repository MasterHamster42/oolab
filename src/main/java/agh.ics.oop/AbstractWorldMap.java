package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, AbstractMapObject> mapObjects = new HashMap<>();
    protected String[] walkable = {"Grass"};

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!coordinateOnMap(position)) return false;
        if (isOccupied(position)){
            String type = ((AbstractMapObject)objectAt(position)).getType();
            for (Object elem: walkable) {
                if(elem.equals(type)) return true;
            }
            return false;
        }
        return true;
    }
    protected abstract boolean coordinateOnMap(Vector2d position);

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractMapObject obj = mapObjects.remove(oldPosition);
        mapObjects.put(newPosition, obj);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
//            animals.add(animal);
            mapObjects.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return  mapObjects.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position){
        return mapObjects.get(position);
    }

    protected abstract Vector2d[] mapSize();

    @Override
    public String toString() {
        Vector2d[] corners = mapSize();
        return new MapVisualizer(this).draw(corners[0], corners[1]);
    }
}
