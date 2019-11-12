package agh.cs.lab2;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Vector2dTest {

    Vector2d zero = new Vector2d(0,0);
    Vector2d one = new Vector2d(1,1);
    Vector2d two = new Vector2d(2,2);
    Vector2d three = new Vector2d(3,3);
    Vector2d minusOne = new Vector2d(-1,-1);


    @Test
    public void testEquals(){
        assertTrue(zero.equals(zero));
    };

    @Test
    public void testFollows() {
        assertTrue(two.follows(one));
    }
    @Test
    public void testToString() {
        assertEquals(zero.toString(), "(0, 0)");
    }
    @Test
    public void testUpperRight() {
        assertEquals(zero.upperRight(one), one);
    }

    @Test
    public void testAdd() {
        assertEquals(one.add(one), two);
    }
    @Test
    public void testSubstract() {
        assertEquals(three.substract(one), two);
    }
    @Test
    public void testOpposite() {
        assertEquals(one.opposite(), minusOne);
    }
}
