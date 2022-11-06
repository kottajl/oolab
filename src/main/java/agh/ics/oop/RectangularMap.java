package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private int width, height;

    public RectangularMap (int width, int height) {
        this.width= width;
        this.height= height;
    }

    @Override
    public boolean canMoveTo (Vector2d position) {
        return super.canMoveTo(position) && position.precedes(new Vector2d (width - 1, height - 1));
    }

    @Override
    public Object objectAt (Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.isAt(position))
                return animal;
        }
        return null;
    }

    @Override
    protected Vector2d defineMinCorner () {
        return new Vector2d(0, 0);
    }

    @Override
    protected Vector2d defineMaxCorner () {
        return new Vector2d(width - 1, height - 1);
    }
}
