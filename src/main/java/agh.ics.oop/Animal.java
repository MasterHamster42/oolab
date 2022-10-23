package agh.ics.oop;

public class Animal {
    private MapDirection my_orientation = MapDirection.NORTH;
    private Vector2d my_position = new Vector2d(2, 2);

    public Animal(){
    }

    @Override
    public String toString() {
        return my_position.toString() +" "+ my_orientation.toString();
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
                switch (my_orientation){
                    case EAST -> my_position =  my_position.add((my_position.precedes(new Vector2d(3,4)))?new Vector2d(1, 0):new Vector2d(0, 0));
                    case WEST -> my_position =  my_position.add(my_position.follows(new Vector2d(1,0))?new Vector2d(-1, 0):new Vector2d(0, 0));
                    case NORTH -> my_position =  my_position.add(my_position.precedes(new Vector2d(4,3))?new Vector2d(0, 1):new Vector2d(0, 0));
                    case SOUTH -> my_position =  my_position.add(my_position.follows(new Vector2d(0,1))?new Vector2d(0, -1):new Vector2d(0, 0));
                }
                break;
            case BACKWARD:
                switch (my_orientation){
                    case EAST -> my_position =  my_position.add(my_position.precedes(new Vector2d(3,4))?new Vector2d(1, 0):new Vector2d(0, 0));
                    case WEST -> my_position =  my_position.add(my_position.follows(new Vector2d(1,0))?new Vector2d(-1, 0):new Vector2d(0, 0));
                    case SOUTH -> my_position =  my_position.add(my_position.precedes(new Vector2d(4,3))?new Vector2d(0, 1):new Vector2d(0, 0));
                    case NORTH -> my_position =  my_position.add(my_position.follows(new Vector2d(0,1))?new Vector2d(0, -1):new Vector2d(0, 0));
                }
                break;
        }
    }

}
