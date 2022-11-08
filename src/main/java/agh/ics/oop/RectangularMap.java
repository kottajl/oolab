package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {

    private final int width, height;

    public RectangularMap (int width, int height) {
        this.width= width;
        this.height= height;
    }

    @Override
    public boolean canMoveTo (Vector2d position) {
        return super.canMoveTo(position) && position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d (width - 1, height - 1));
    }

    @Override
    public Object objectAt (Vector2d position) { return animalList.get(position); }

    @Override
    protected Vector2d defineMinCorner () {
        return new Vector2d(0, 0);
    }

    @Override
    protected Vector2d defineMaxCorner () {
        return new Vector2d(width - 1, height - 1);
    }
}
