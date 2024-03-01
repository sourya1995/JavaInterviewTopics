package Enums;

public enum Direction {
    NORTH, EAST, WEST, SOUTH;

    private Direction opposite;

    public Direction getOpposite() {
        return opposite;
    }

    static {
        NORTH.opposite = SOUTH;
        EAST.opposite = WEST;
        WEST.opposite = EAST;
        SOUTH.opposite = NORTH;
    }

}
