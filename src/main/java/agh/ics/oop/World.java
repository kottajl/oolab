package agh.ics.oop;

public class World {
    public static void main (String[] args) {
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
