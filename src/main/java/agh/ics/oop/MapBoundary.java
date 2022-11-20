package agh.ics.oop;

import java.util.TreeMap;


public class MapBoundary implements IPositionChangeObserver{
    Vector2d right_corner;
    Vector2d left_corner;
    AbstractWorldMap worldMap;

    private TreeMap<AbstractMapObject, AbstractMapObject> xAxis = new TreeMap<>(new AnimalGrassComparator(true));
    private TreeMap<AbstractMapObject, AbstractMapObject> yAxis = new TreeMap<>(new AnimalGrassComparator(false));

    public MapBoundary(AbstractWorldMap map){
        worldMap = map;
    }

    public void updateCorners(){
        left_corner = new Vector2d(xAxis.firstEntry().getValue().position.x,
                yAxis.firstEntry().getValue().position.y);
        right_corner = new Vector2d(xAxis.lastEntry().getValue().position.x,
                yAxis.lastEntry().getValue().position.y);
    }
    public Vector2d[] getCorners(){
        return new Vector2d[] {left_corner, right_corner};
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractMapObject toMove = worldMap.objectAt(newPosition);
        if (toMove == null) toMove = worldMap.objectAt(oldPosition);
        xAxis.remove(toMove);
        xAxis.put(toMove,toMove);
        yAxis.remove(toMove);
        yAxis.put(toMove,toMove);
    }
    public void addObject(AbstractMapObject mapObject){
        xAxis.put(mapObject,mapObject);
        yAxis.put(mapObject,mapObject);
    }
}
