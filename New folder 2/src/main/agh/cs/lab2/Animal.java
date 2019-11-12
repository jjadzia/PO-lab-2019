package agh.cs.lab2;


public class Animal {
    private MapDirections orientation = MapDirections.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap ownMap;

    Animal(){
    }
    Animal(IWorldMap map){
        this.ownMap=map;
    }

    Animal(IWorldMap map, Vector2d position) {
        this.ownMap = map;
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }
    public MapDirections getOrientation(){
        return this.orientation;
    }


    public String toString() {
        return this.orientation.toChar();
    }

    public void move(MoveDirections direction){

        Vector2d forwardPosition = this.orientation.toUnitVector().add(this.position);
        Vector2d backwardPosition = this.orientation.toUnitVector().opposite().add(this.position);

        boolean canMoveForward = this.ownMap.canMoveTo(forwardPosition);
        boolean canMoveBackwards = this.ownMap.canMoveTo(backwardPosition);

        if(direction.equals(MoveDirections.FORWARD) && canMoveForward ) this.position=forwardPosition;
        else if (direction.equals(MoveDirections.BACKWARD) && canMoveBackwards) this.position=backwardPosition;
        else if ( direction.equals(MoveDirections.LEFT) ) this.orientation=this.orientation.previous();
        else if ( direction.equals(MoveDirections.RIGHT) ) this.orientation=this.orientation.next();

    }
}
