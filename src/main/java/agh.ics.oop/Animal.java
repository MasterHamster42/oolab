package agh.ics.oop;

public class Animal {
    private MapDirection my_orientation = MapDirection.NORTH;
    private Vector2d my_position = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal(){
    }
    public Animal(IWorldMap map){
        this.map = map;
    };

    Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this. my_position = initialPosition;
    }
    public Vector2d getMy_position(){
        return this.my_position;
    }

    @Override
    public String toString() {
//        return my_position.toString() +" "+ my_orientation.toString();
        return my_position.toString();
    }

    public boolean isAt(Vector2d position){
        return my_position.equals(position);
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
                my_position =  map.canMoveTo(my_position.add(my_orientation.toUnitVector()))?my_position.add(my_orientation.toUnitVector()): my_position;
                break;
            case BACKWARD:
                my_position =  map.canMoveTo(my_position.add(my_orientation.toUnitVector().opposite()))?my_position.add(my_orientation.toUnitVector().opposite()): my_position;
                break;
        }
    }

}
