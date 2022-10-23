package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){
        MoveDirection[] directions = new MoveDirection[args.length];
        int correct_directions = 0;
        for(int i=0; i< args.length; i++){
            switch (args[i]){
                case "f", "forward" ->directions[correct_directions++] = MoveDirection.FORWARD;
                case "b", "backward" ->directions[correct_directions++] = MoveDirection.BACKWARD;
                case "r", "right" ->directions[correct_directions++] = MoveDirection.RIGHT;
                case "l", "left" ->directions[correct_directions++] = MoveDirection.LEFT;
            }
        }
        return Arrays.copyOfRange(directions, 0, correct_directions);
    }
}
