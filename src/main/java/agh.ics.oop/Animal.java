package agh.ics.oop;

public class Animal implements IMapElement{
    private MapDirection my_orientation = MapDirection.NORTH;
    private Vector2d Position = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal(){
    }
    public Animal(IWorldMap map){
        this.map = map;
    };

    Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.Position = initialPosition;
    }
    public Vector2d getPosition(){
        return this.Position;
    }

    @Override
    public String toString() {
        return my_orientation.toString();
    }

    public boolean isAt(Vector2d position){
        return Position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction){
            case LEFT:
                my_orientation = my_orientation.previous();
                break;
            case RIGHT:
                my_orientation = my_orientation.next();
                break;
            case FORWARD:
                Position =  map.canMoveTo(Position.add(my_orientation.toUnitVector()))? Position.add(my_orientation.toUnitVector()): Position;
                break;
            case BACKWARD:
                Position =  map.canMoveTo(Position.add(my_orientation.toUnitVector().opposite()))? Position.add(my_orientation.toUnitVector().opposite()): Position;
                break;
        }
    }

}
