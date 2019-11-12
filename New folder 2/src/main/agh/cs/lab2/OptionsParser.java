package agh.cs.lab2;


import java.util.Arrays;

public class OptionsParser {

    public MoveDirections stringToMoveDirection(String arg) {
        if (arg.equals("forward") || arg.equals("f")) return MoveDirections.FORWARD;
        else if (arg.equals("backward") || arg.equals("b")) return MoveDirections.BACKWARD;
        else if (arg.equals("left") || arg.equals("l")) return MoveDirections.LEFT;
        else if (arg.equals("right") || arg.equals("r")) return MoveDirections.RIGHT;
        else throw new IllegalArgumentException("'"+arg +"'"+ " is not a valid move");
    }

    public MoveDirections[] parse(String[] args) {
        int size = args.length;
        MoveDirections[] tabDirection = new MoveDirections[size];
        int validElements = 0;
        for (String i : args) {
            MoveDirections tmp=stringToMoveDirection(i);
            tabDirection[validElements] = tmp;
            validElements++;
        }
        return tabDirection;
    }
}
