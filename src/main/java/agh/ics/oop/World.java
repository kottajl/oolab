package agh.ics.oop;

import java.util.concurrent.ThreadLocalRandom;

public class World {
    public static void main (String[] args) {
        // sprawdzanie Vector2d
        /*Vector2d position1= new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2= new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/

        //  sprawdzanie MoveDirection
        /*MapDirection myOrientation= MapDirection.WEST;
        if (!myOrientation.toString().equals("Zachód"))
            System.out.println("Błąd w MapDirection.toString()");
        if (myOrientation.next() != MapDirection.NORTH)
            System.out.println("Błąd w MapDirection.next()");
        if (myOrientation.previous() != MapDirection.SOUTH)
            System.out.println("Błąd w MapDirection.previous()");
        if (!myOrientation.toUnitVector().equals(MapDirection.EAST.toUnitVector().opposite()))
            System.out.println("Błąd w MapDirection.toUnitVector");

        System.out.println("Sprawdzanie zakończone!\n");*/

        // lab3 - tworzenie Animal i wyznaczanie trasy
        /*Animal myPet= new Animal();
        System.out.println("Status przed wędrówką: " + myPet);*/

        /*myPet.move(MoveDirection.RIGHT);
        myPet.move(MoveDirection.FORWARD);
        myPet.move(MoveDirection.FORWARD);
        myPet.move(MoveDirection.FORWARD);
        System.out.println(myPet.toString());*/

        /*OptionsParser myParser1= new OptionsParser();
        MoveDirection[] theOrders= myParser1.parse(args);
        for (MoveDirection x: theOrders)
            myPet.move(x);
        System.out.println("Status po wędrówce: " + myPet);*/

        // Odpowiedź na pytanie z polecenia 10 zajduje się w klasie Animal.

        // input: f b r l f f r r f f f f f f f f

        // lab4 - zad 6
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);

        //lab5
        MoveDirection[] directions2 = new OptionsParser().parse(args);
        IWorldMap map2 = new GrassField(10);
        Vector2d[] positions2 = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();
        System.out.println(map2);
    }

    public static Direction[] stringToEnum (String[] input) {
        int numberOfElements= 0;
        for (String x: input)
            if (x.equals("f") || x.equals("b") || x.equals("r") || x.equals("l"))
                numberOfElements++;

        Direction[] output= new Direction[numberOfElements];
        int i= 0;
        for (String x: input) {
            switch (x) {
                case "f":
                    output[i++]= Direction.forward;
                    break;
                case "b":
                    output[i++]= Direction.backward;
                    break;
                case "r":
                    output[i++]= Direction.right;
                    break;
                case "l":
                    output[i++]= Direction.left;
                    break;
            }
        }
        return output;
    }
    public static void run (Direction[] args) {
        //System.out.println("zwierzak zmierza ku przodowi");

        // zad 11-12 (wypisywanie argumentów)
        int counter= 0;
        for (Direction x: args) {
            if (counter != 0)
                System.out.print(", ");
            counter++;
            System.out.print(x);
        }
        System.out.print("\n");

        // zad 14-15 (wypisywanie ruchu zwierzaka)
        System.out.println("Start");
        for (Direction x: args) {
            String message= switch (x) {
                case forward -> "Zwierzak idzie do przodu";
                case backward -> "Zwierzak idzie do tyłu";
                case right -> "Zwierzak skręca w prawo";
                case left -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
        System.out.println("Stop");
    }
}
