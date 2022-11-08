package agh.ics.oop;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {
    private final int numOfGrasses;
    private final Map<Vector2d, Grass> cordsOfGrasses= new HashMap<>();

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

        cordsOfGrasses.put(temp, new Grass(temp));
    }

    @Override
    public Object objectAt (Vector2d position) {
        if (animalList.get(position) != null)
            return animalList.get(position);

        return cordsOfGrasses.get(position);
    }

    @Override
    public void movedTo (Vector2d position) {
        if (cordsOfGrasses.containsKey(position)) {
            cordsOfGrasses.remove(position);
            generateNewGrass((int)Math.sqrt(10 * numOfGrasses));
        }
    }

    protected Vector2d defineMinCorner () {
        Vector2d minCorner= new Vector2d( (int)Math.sqrt(10 * numOfGrasses), (int)Math.sqrt(10 * numOfGrasses) );

        for (Vector2d key: animalList.keySet())
            minCorner= minCorner.lowerLeft(key);
        for (Vector2d key: cordsOfGrasses.keySet())
            minCorner= minCorner.lowerLeft(key);

        return minCorner;
    }

    protected Vector2d defineMaxCorner () {
        Vector2d maxCorner= new Vector2d(0, 0);

        for (Vector2d key: animalList.keySet())
            maxCorner= maxCorner.upperRight(key);
        for (Vector2d key: cordsOfGrasses.keySet())
            maxCorner= maxCorner.upperRight(key);

        return maxCorner;
    }

}
