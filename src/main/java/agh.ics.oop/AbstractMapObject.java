package agh.ics.oop;

public abstract class AbstractMapObject implements IMapElement{
    protected Vector2d position;
    protected String type;

    public Vector2d getPosition() {
        return this.position;
    }


    public String getType(){return type;}
    public boolean isAt(Vector2d position){return this.position.equals(position);}

    public abstract String toString();
}
