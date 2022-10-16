package agh.ics.oop;

public class World {
    public static void main (String[] args) {
        // sprawdzanie Vector2d
        Vector2d position1= new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2= new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        //  sprawdzanie MoveDirection
        MapDirection myOrientation= MapDirection.WEST;
        if (!myOrientation.toString().equals("Zachód"))
            System.out.println("Błąd w MapDirection.toString()");
        if (myOrientation.next() != MapDirection.NORTH)
            System.out.println("Błąd w MapDirection.next()");
        if (myOrientation.previous() != MapDirection.SOUTH)
            System.out.println("Błąd w MapDirection.previous()");
        if (!myOrientation.toUnitVector().equals(MapDirection.EAST.toUnitVector().opposite()))
            System.out.println("Błąd w MapDirection.toUnitVector");

        System.out.println("Sprawdzanie zakończone!");
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
                    output[i++]= Direction.f;
                    break;
                case "b":
                    output[i++]= Direction.b;
                    break;
                case "r":
                    output[i++]= Direction.r;
                    break;
                case "l":
                    output[i++]= Direction.l;
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
                case f -> "Zwierzak idzie do przodu";
                case b -> "Zwierzak idzie do tyłu";
                case r -> "Zwierzak skręca w prawo";
                case l -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
        System.out.println("Stop");
    }
}
