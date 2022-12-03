package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] args) throws IllegalArgumentException{
        MoveDirection[] directions = new MoveDirection[args.length];
        int correct_directions = 0;
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> directions[correct_directions++] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[correct_directions++] = MoveDirection.BACKWARD;
                case "r", "right" -> directions[correct_directions++] = MoveDirection.RIGHT;
                case "l", "left" -> directions[correct_directions++] = MoveDirection.LEFT;
                case " " -> {}
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return Arrays.copyOfRange(directions, 0, correct_directions);
    }
    public MoveDirection[] parse(char[] args) throws IllegalArgumentException{
        MoveDirection[] directions = new MoveDirection[args.length];
        int correct_directions = 0;
        for (char arg : args) {
            switch (arg) {
                case 'f' -> directions[correct_directions++] = MoveDirection.FORWARD;
                case 'b' -> directions[correct_directions++] = MoveDirection.BACKWARD;
                case 'r' -> directions[correct_directions++] = MoveDirection.RIGHT;
                case 'l' -> directions[correct_directions++] = MoveDirection.LEFT;
                case ' ' -> {}
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return Arrays.copyOfRange(directions, 0, correct_directions);
    }
}
