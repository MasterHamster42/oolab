package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString() {
        switch (this) {
            case NORTH:
                return "N";
            case SOUTH:
                return "P";
            case WEST:
                return "Z";
            case EAST:
                return "W";
        }
        return null;
    }
    public MapDirection next(){
        switch (this) {
            case NORTH:
                return MapDirection.EAST;
            case SOUTH:
                return MapDirection.WEST;
            case WEST:
                return MapDirection.NORTH;
            case EAST:
                return MapDirection.SOUTH;
        }
        return null;
    }
    public MapDirection previous(){
        switch (this) {
            case NORTH:
                return MapDirection.WEST;
            case SOUTH:
                return MapDirection.EAST;
            case WEST:
                return MapDirection.SOUTH;
            case EAST:
                return MapDirection.NORTH;
        }
        return null;
    }
    public Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case EAST -> new Vector2d(1, 0);
        };
    }
}
