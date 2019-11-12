package agh.cs.lab2;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AnimalTest {
    MapDirections n = MapDirections.NORTH;
    MapDirections w = MapDirections.WEST;

    MoveDirections f = MoveDirections.FORWARD;
    MoveDirections b = MoveDirections.BACKWARD;
    MoveDirections r = MoveDirections.RIGHT;
    MoveDirections l = MoveDirections.LEFT;


    Vector2d oneThree = new Vector2d(2,3);
    Vector2d zeroThree = new Vector2d(0,3);
    Vector2d zero = new Vector2d(0,0);
    Vector2d four = new Vector2d(4,4);

    Animal kotek = new Animal();

    @Test
    public void testOrientation() {
        assertEquals(kotek.getOrientation(), n);
        kotek.move(l);
        assertEquals(kotek.getOrientation(), w);
        kotek.move(r);
        assertEquals(kotek.getOrientation(), n);
    }

    @Test
    public void testPosition() {
        kotek.move(f);
        assertTrue(kotek.getPosition().equals(oneThree));
        kotek.move(r);
        kotek.move(b);
        kotek.move(b);
        assertTrue(kotek.getPosition().equals(zeroThree));
        kotek.move(b);
        kotek.move(b);
        kotek.move(b);
        kotek.move(b);
        kotek.move(b);
        assertTrue(kotek.getPosition().follows(zero));

    }

    @Test
    public void testArray(){
        String[] sample = {"b","c","r","l","g","f"};
        MoveDirections[] expected= {b,r,l,f};
        OptionsParser p = new OptionsParser();
        assertTrue(Arrays.equals(p.parse(sample), expected));
    }
}