package agh.ics.oop;

import java.lang.Math;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {
    private final int numOfGrasses;
    private List<Grass> cordsOfGrasses= new LinkedList<>();

    public GrassField (int numOfGrasses) {
        this.numOfGrasses= numOfGrasses;

        int maxCord= (int)Math.sqrt(10 * numOfGrasses);
        for (int i=0; i < numOfGrasses; i++)
            generateNewGrass(maxCord);
    }

    private void generateNewGrass (int maxCord) {
        Vector2d temp;
        do {
            int randomX= ThreadLocalRandom.current().nextInt(0, maxCord + 1);
            int randomY= ThreadLocalRandom.current().nextInt(0, maxCord + 1);
            temp= new Vector2d(randomX, randomY);
        } while (isOccupied(temp));

        cordsOfGrasses.add(new Grass(temp));
    }

    @Override
    public Object objectAt (Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.isAt(position))
                return animal;
        }
        for (Grass grass: cordsOfGrasses) {
            if (grass.getPosition().equals(position))
                return grass;
        }

        return null;
    }

    @Override
    public void movedTo (Vector2d position) {
        if (cordsOfGrasses.remove(new Grass(position)))
            generateNewGrass((int)Math.sqrt(10 * numOfGrasses));
    }

    protected Vector2d defineMinCorner () {
        Vector2d minCorner= cordsOfGrasses.get(0).getPosition();

        for (Animal animal: animalList)
            minCorner= minCorner.lowerLeft(animal.getMyLocation());
        for (Grass grass: cordsOfGrasses)
            minCorner= minCorner.lowerLeft(grass.getPosition());

        return minCorner;
    }

    protected Vector2d defineMaxCorner () {
        Vector2d maxCorner= cordsOfGrasses.get(0).getPosition();

        for (Animal animal: animalList)
            maxCorner= maxCorner.upperRight(animal.getMyLocation());
        for (Grass grass: cordsOfGrasses)
            maxCorner= maxCorner.upperRight(grass.getPosition());

        return maxCorner;
    }

}
