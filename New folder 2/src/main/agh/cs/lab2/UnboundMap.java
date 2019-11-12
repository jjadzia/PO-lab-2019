package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class UnboundMap extends AbstractWorldMap{
    private List<Rock> rocks;
    private List<Animal> animals;

    UnboundMap(){
        animals = new ArrayList<>();
        rocks = new ArrayList<>();
    }
    UnboundMap(List<Rock> rocks){
        this();
        this.rocks=rocks;
        for(Rock i: rocks) elements.put(i.getPosition(), i);
    }

    public String toString(){
        Vector2d end, begin;
        if( !animals.isEmpty() ) {
            end=animals.get(0).getPosition();
            begin=animals.get(0).getPosition();
        }
        else if( !rocks.isEmpty() ) {
            end=rocks.get(0).getPosition();
            begin=rocks.get(0).getPosition();
        }
        else return "";
        for(Animal an: animals){
            end=an.getPosition().upperRight(end);
            begin=an.getPosition().lowerLeft(begin);
        }
        for(Rock r: rocks){
            end=r.getPosition().upperRight(end);
            begin=r.getPosition().lowerLeft(begin);
        }

        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(begin, end);

    }
}
