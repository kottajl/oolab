package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map <Vector2d, Animal> animalList = new HashMap<>();

    @Override
    public boolean place (Animal animal) {
        // Place an animal.
        if (canMoveTo(animal.getMyLocation())) {
            animalList.put(animal.getMyLocation(), animal);
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
        return animalList.containsKey(position);
    }

    @Override
    public boolean canMoveTo (Vector2d position) {
        // Refers to animal - grass cannot move.
        return !isOccupiedByAnimal(position);
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

    @Override
    public void positionChanged (Vector2d oldPosition, Vector2d newPosition) {
        Animal tempAnimal= animalList.get(oldPosition);
        animalList.remove(oldPosition);
        animalList.put(newPosition, tempAnimal);
    }
}
