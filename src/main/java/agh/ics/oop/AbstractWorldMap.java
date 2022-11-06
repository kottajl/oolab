package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animalList= new ArrayList<>();

    @Override
    public boolean place (Animal animal) {
        // Place an animal.
        if (canMoveTo(animal.getMyLocation())) {
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied (Vector2d position) {
        // Is it being occupied by another animal/grass?
        return objectAt(position) != null;
    }

    public boolean isOccupiedByAnimal (Vector2d position) {
        // Is it being occupied by another animal?
        for (Animal animal: animalList) {
            if (animal.isAt(position))
                return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo (Vector2d position) {
        // Refers to animal - grass cannot move.
        return !isOccupiedByAnimal(position) && position.follows(new Vector2d(0, 0));
    }

    @Override
    public void movedTo (Vector2d position) {};

    protected abstract Vector2d defineMinCorner();
    protected abstract Vector2d defineMaxCorner();

    public String toString () {
        Vector2d minCorner= defineMinCorner();
        Vector2d maxCorner= defineMaxCorner();

        return new MapVisualizer(this).draw(minCorner, maxCorner);
    }
}
