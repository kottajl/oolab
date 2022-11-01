package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private int width, height;
    private List <Animal> animalList= new ArrayList<>();

    public RectangularMap (int width, int height) {
        this.width= width;
        this.height= height;
    }

    @Override
    public String toString () {
        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }

    @Override
    public boolean canMoveTo (Vector2d position) {
        if (position.precedes(new Vector2d (width - 1, height - 1)) && position.follows(new Vector2d(0, 0)))
            return !isOccupied(position);
        return false;
    }

    @Override
    public boolean place (Animal animal) {
        if (canMoveTo(animal.getMyLocation())) {
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied (Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt (Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.isAt(position))
                return animal;
        }
        return null;
    }

}
