package agh.ics.oop;

public class Grass implements IMapElement{
    private Vector2d Position;

    public Grass(Vector2d position){
        Position = position;
    }

    public Vector2d getPosition() {
        return Position;
    }

    public boolean isAt(Vector2d position){return Position.equals(position);}

    @Override
    public String toString() {
        return "*";
    }
}
