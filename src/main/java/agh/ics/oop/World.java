package agh.ics.oop;

public class World {
    public static void main (String[] args) {
        System.out.println("-> system wystartował");
        // String[] input= {"f", "f", "r", "x", "b", "l"};                   // INPUT
        Direction.Direct[] arguments= stringToEnum(args);
        run(arguments);
        System.out.print("-> system zakończył działanie");
    }

    public static Direction.Direct[] stringToEnum (String[] input) {
        int numberOfElements= 0;
        for (String x: input)
            if (x.equals("f") || x.equals("b") || x.equals("r") || x.equals("l"))
                numberOfElements++;

        Direction.Direct[] output= new Direction.Direct[numberOfElements];
        int i= 0;
        for (String x: input) {
            switch (x) {
                case "f":
                    output[i++] = Direction.Direct.f;
                    break;
                case "b":
                    output[i++] = Direction.Direct.b;
                    break;
                case "r":
                    output[i++] = Direction.Direct.r;
                    break;
                case "l":
                    output[i++] = Direction.Direct.l;
                    break;
            }
        }
        return output;
    }
    public static void run (Direction.Direct[] args) {
        //System.out.println("zwierzak zmierza ku przodowi");

        // zad 11-12 (wypisywanie argumentów)
        int counter= 0;
        for (Direction.Direct x: args) {
            if (counter != 0)
                System.out.print(", ");
            counter++;
            System.out.print(x);
        }
        System.out.print("\n");

        // zad 14-15 (wypisywanie ruchu zwierzaka)
        System.out.println("Start");
        for (Direction.Direct x: args) {
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
