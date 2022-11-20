package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse (String[] input) {
        MoveDirection[] output= new MoveDirection[input.length];
        int i= 0;
        for (String x: input) {
            switch (x) {
                case "f", "forward" -> output[i]= MoveDirection.FORWARD;
                case "b", "backward" -> output[i]= MoveDirection.BACKWARD;
                case "l", "left" -> output[i]= MoveDirection.LEFT;
                case "r", "right" -> output[i]= MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException(x + " is not legal move specification");
            }
            i++;
        }

        return Arrays.copyOfRange(output, 0, i);
    }
}
