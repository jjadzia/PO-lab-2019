package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {

        String[] args1 = new String[]{"f","b","r", "f", "f", "f","r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        try {
            MoveDirections[] directions = new OptionsParser().parse(args1);
            List<Rock> rocks=new ArrayList<>();
            rocks.add(new Rock(new Vector2d(-4,-4)));
            rocks.add(new Rock(new Vector2d(7,7)));
            rocks.add(new Rock(new Vector2d(3,6)));
            rocks.add(new Rock(new Vector2d(2,0)));

            IWorldMap map = new UnboundMap(rocks);
            System.out.println(map);
            map.place(new Animal(map,new Vector2d(3,4)));
            System.out.println(map);
            map.run(directions);
            System.out.println(map);
            map.place(new Animal(map,new Vector2d(3,4)));
            map.run(directions);
            System.out.println(map);
        }
        catch (IllegalArgumentException err){
            System.out.println(err);
        }
    }
}
