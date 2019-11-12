package agh.cs.lab2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UnboundTest {




    String[] args1= new String[]{"f","b","r", "l", "f", "f","r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirections[] directions = new OptionsParser().parse(args1);
    Vector2d twotwo =new Vector2d(2,2);
    Vector2d twozero =new Vector2d(2,0);
    Vector2d threefive =new Vector2d(3,5);
    Vector2d threefour =new Vector2d(3,4);
    Vector2d tenTen = new Vector2d(10,10);
    Vector2d threeMthree = new Vector2d(3,-3);
    Vector2d twoSeven = new Vector2d(2,7);
    Vector2d twoMone = new Vector2d(2,-1);


    List<Rock> rocks=new ArrayList<>();



    @Test
    public void placeTest(){
        rocks.add(new Rock(threefour));
        rocks.add(new Rock(twozero));
        rocks.add(new Rock(new Vector2d(3,3)));
        rocks.add(new Rock(new Vector2d(-1,-1)));
        IWorldMap map = new UnboundMap(rocks);
        assertTrue(map.place(new Animal(map)));
        assertFalse(map.place(new Animal(map)));
        assertFalse(map.place(new Animal(map,threefour)));
        assertTrue(map.place(new Animal(map, tenTen)));
    }

    @Test
    public void runTest(){
        rocks.add(new Rock(new Vector2d(-4,-4)));
        rocks.add(new Rock(new Vector2d(7,7)));
        rocks.add(new Rock(new Vector2d(3,6)));
        rocks.add(new Rock(new Vector2d(2,0)));
        IWorldMap map = new UnboundMap(rocks);
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        assertTrue(map.isOccupied(twozero));
        assertTrue(map.isOccupied(threeMthree));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        assertTrue(map.isOccupied(twoSeven));
        assertTrue(map.isOccupied(twoMone));
    }

    @Test
    public void canMoveTest(){
        IWorldMap map = new UnboundMap(rocks);
        rocks.add(new Rock(threefour));

        assertFalse(map.canMoveTo(threefour));
        assertTrue(map.canMoveTo(threefive));
        map.place(new Animal(map,tenTen));
        assertFalse(map.canMoveTo(tenTen));
    }

    @Test
    public void isOccupiedTest(){
        rocks.add(new Rock(threefour));
        rocks.add(new Rock(twozero));
        IWorldMap map = new UnboundMap(rocks);

        assertTrue(map.isOccupied(threefour));
        assertFalse(map.isOccupied(tenTen));
        map.place(new Animal(map));
        assertTrue(map.isOccupied(twotwo));
        map.place(new Animal(map,threefive));
        assertTrue(map.isOccupied(threefive));
    }
}

