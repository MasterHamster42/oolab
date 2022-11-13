package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractMapObject{
    private MapDirection my_orientation = MapDirection.NORTH;
    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> observerArrayList = new ArrayList<>();

    public Animal(){
        this.position = new Vector2d(2, 2);
        this.type = "Animal";
    }
    public Animal(IWorldMap map){
        this.map = map;
        this.position = new Vector2d(2, 2);
        this.type = "Animal";
    };

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.type = "Animal";
    }

    @Override
    public String toString() {
        return my_orientation.toString();
    }

    void addObserver(IPositionChangeObserver observer){
        observerArrayList.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observerArrayList.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observerArrayList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public void move(MoveDirection direction){
        Vector2d oldPosition = this.position;
        switch (direction) {
            case LEFT -> my_orientation = my_orientation.previous();
            case RIGHT -> my_orientation = my_orientation.next();
            case FORWARD ->
                    position = map.canMoveTo(position.add(my_orientation.toUnitVector())) ? position.add(my_orientation.toUnitVector()) : position;
            case BACKWARD ->
                    position = map.canMoveTo(position.add(my_orientation.toUnitVector().opposite())) ? position.add(my_orientation.toUnitVector().opposite()) : position;
        }
        if (!oldPosition.equals(this.position)){
            this.positionChanged(oldPosition, this.position);
        }
    }

}
