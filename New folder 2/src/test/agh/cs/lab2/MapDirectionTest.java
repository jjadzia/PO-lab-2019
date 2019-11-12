package agh.cs.lab2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MapDirectionTest {

    MapDirections n = MapDirections.NORTH;
    MapDirections e = MapDirections.EAST;
    MapDirections s = MapDirections.SOUTH;
    MapDirections w = MapDirections.WEST;

    @Test
    public void testNext(){
        assertEquals( n.next(), e);
        assertEquals( e.next(), s);
        assertEquals( s.next(), w);
        assertEquals( w.next(), n);
    };

    @Test
    public void testPrev(){
        assertEquals( n.previous(), w);
        assertEquals( e.previous(), n);
        assertEquals( s.previous(), e);
        assertEquals( w.previous(), s);
    };
}