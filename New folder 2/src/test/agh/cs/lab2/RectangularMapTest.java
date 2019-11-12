package agh.cs.lab2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class RectangularMapTest {


    String[] args1= new String[]{"f","b","r", "l", "f", "f","r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirections[] directions = new OptionsParser().parse(args1);
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d twotwo =new Vector2d(2,2);
    Vector2d twozero =new Vector2d(2,0);
    Vector2d threefive =new Vector2d(3,5);
    Vector2d threefour =new Vector2d(3,4);
    Vector2d tenTen = new Vector2d(10,10);
    MapDirections n = MapDirections.NORTH;



    @Test
    public void placeTest(){
        assertTrue(map.place(new Animal(map)));
        //assertFalse(map.place(new Animal(map)));
        map.place(new Animal(map,new Vector2d(3,4)));
        System.out.println(map);
        assertTrue(map.isOccupied(threefour));
        //assertFalse(map.place(new Animal(map, tenTen)));
    }

    @Test
    public void runTest(){
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);

        assertTrue(map.isOccupied(twozero));
        assertTrue(map.isOccupied(threefive));
    }

    @Test
    public void canMoveTest(){
        assertFalse(map.canMoveTo(tenTen));
        assertTrue(map.canMoveTo(threefive));
        map.place(new Animal(map,new Vector2d(3,4)));
        assertFalse(map.canMoveTo(threefour));
    }

    @Test
    public void isOccupiedTest(){
        assertTrue(!map.isOccupied(twotwo));
        assertTrue(!map.isOccupied(threefour));
        map.place(new Animal(map));
        //map.place(new Animal(map));
        assertTrue(map.isOccupied(twotwo));
        map.place(new Animal(map,new Vector2d(3,4)));
        assertTrue(map.isOccupied(threefour));
    }
}
