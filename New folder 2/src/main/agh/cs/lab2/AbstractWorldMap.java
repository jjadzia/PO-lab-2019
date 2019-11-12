package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    public Map<Vector2d,Object> elements = new HashMap<>();


    public boolean canMoveTo(Vector2d position){
        return !isOccupied(position);
    }

    public boolean place(Animal animal){
        Vector2d position = animal.getPosition();
        if( canMoveTo(position)) {
            animals.add(animal);
            elements.put(animal.getPosition(),animal);
            return true;
        }
        else throw new IllegalArgumentException(position+" is already occupied or out of reach");
    }

    public void run(MoveDirections[] directions){
        int counter=0;
        if (animals.isEmpty()) return;
        for (MoveDirections i: directions){
            Animal movingAnimal=animals.get(counter%animals.size());
            Vector2d previousPosition=movingAnimal.getPosition();
            movingAnimal.move(i);
            Vector2d currentPosition=movingAnimal.getPosition();

            if(!previousPosition.equals(currentPosition)){
                elements.remove(previousPosition);
                elements.put(currentPosition, movingAnimal);
            }
            counter++;
        }
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position)!=null;
    }

    public Object objectAt(Vector2d position){
        return elements.get(position);
    }
}
