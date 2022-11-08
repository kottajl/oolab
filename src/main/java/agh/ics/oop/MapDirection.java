package agh.ics.oop;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

        public String toString () {
        switch (this) {
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
            case WEST: return "Zachód";
            case EAST: return "Wschód";
            default: return "";
        }
    }

    public MapDirection next () {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return this;
        }
    }

    public MapDirection previous () {
        switch (this) {
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            default: return this;
        }
    }

    public Vector2d toUnitVector () {
        switch (this) {
            case NORTH: return new Vector2d(0, 1);
            case SOUTH: return new Vector2d(0, -1);
            case WEST: return new Vector2d(-1, 0);
            case EAST: return new Vector2d(1, 0);

            default: throw new RuntimeException();
        }
    }
}
