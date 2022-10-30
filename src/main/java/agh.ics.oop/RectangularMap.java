package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;

public class RectangularMap implements IWorldMap{

    private Vector2d size;
    private ArrayList<Animal> occupied_coordinates;

    public RectangularMap(int width, int height){
        this.size = new Vector2d(width, height);
        occupied_coordinates = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!position.precedes(size) || !position.follows(new Vector2d(0,0))) return false;
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getMy_position())){
            occupied_coordinates.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: occupied_coordinates) {
            if (animal.isAt(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: occupied_coordinates) {
            if (animal.isAt(position)) return animal;
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), this.size);
    }
}
