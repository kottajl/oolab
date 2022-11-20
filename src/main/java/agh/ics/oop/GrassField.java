package agh.ics.oop;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {
    private final int numOfGrasses;
    private final Map<Vector2d, Grass> cordsOfGrasses= new HashMap<>();
    private MapBoundary mapB;

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

        Grass tempGrass= new Grass(temp);
        cordsOfGrasses.put(temp, tempGrass);

        /*mapB.xElements.add(tempGrass);
        mapB.yElements.add(tempGrass);*/
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

    public Vector2d defineMinCorner () {
        Vector2d minCorner= new Vector2d( (int)Math.sqrt(10 * numOfGrasses), (int)Math.sqrt(10 * numOfGrasses) );

        for (Vector2d key: animalList.keySet())
            minCorner= minCorner.lowerLeft(key);
        for (Vector2d key: cordsOfGrasses.keySet())
            minCorner= minCorner.lowerLeft(key);

        return minCorner;

        // próba nowego podejścia - niestety nie działa, jakoś źle używam tego TreeSeta

        /*Vector2d wnk1, wnk2;
        //Object tempObj= mapB.xElements.first();

        if (tempObj instanceof Grass)
            wnk1= new Vector2d(((Grass)tempObj).getPosition().x, ((Grass)tempObj).getPosition().y);
        else
            wnk1= new Vector2d(((Animal)tempObj).getMyLocation().x, ((Animal)tempObj).getMyLocation().y);

        //tempObj= mapB.yElements.first();
        if (tempObj instanceof Grass)
            wnk2= new Vector2d(((Grass)tempObj).getPosition().x, ((Grass)tempObj).getPosition().y);
        else
            wnk2= new Vector2d(((Animal)tempObj).getMyLocation().x, ((Animal)tempObj).getMyLocation().y);

        return wnk1.lowerLeft(wnk2);*/
    }

    public Vector2d defineMaxCorner () {
        Vector2d maxCorner= new Vector2d(0, 0);

        for (Vector2d key: animalList.keySet())
            maxCorner= maxCorner.upperRight(key);
        for (Vector2d key: cordsOfGrasses.keySet())
            maxCorner= maxCorner.upperRight(key);

        return maxCorner;

        // próba nowego podejścia - niestety nie działa, jakoś źle używam tego TreeSeta

        /*Vector2d wnk1, wnk2;
        //Object tempObj= mapB.xElements.last();

        if (tempObj instanceof Grass)
            wnk1= new Vector2d(((Grass)tempObj).getPosition().x, ((Grass)tempObj).getPosition().y);
        else
            wnk1= new Vector2d(((Animal)tempObj).getMyLocation().x, ((Animal)tempObj).getMyLocation().y);

        //tempObj= mapB.yElements.last();
        if (tempObj instanceof Grass)
            wnk2= new Vector2d(((Grass)tempObj).getPosition().x, ((Grass)tempObj).getPosition().y);
        else
            wnk2= new Vector2d(((Animal)tempObj).getMyLocation().x, ((Animal)tempObj).getMyLocation().y);

        return wnk1.upperRight(wnk2);*/
    }

}
