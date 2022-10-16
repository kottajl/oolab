package agh.ics.oop;

import java.lang.reflect.Array;
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
                default -> i--;
            }
            i++;
        }

        return Arrays.copyOfRange(output, 0, i);
    }
}
