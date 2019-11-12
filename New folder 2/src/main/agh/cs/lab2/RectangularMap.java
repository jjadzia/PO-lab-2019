package agh.cs.lab2;


class RectangularMap extends AbstractWorldMap{
    private Vector2d furthest;
    private final Vector2d closest = new Vector2d(0,0);


    RectangularMap(int width, int height){
        this.furthest=new Vector2d(width, height);
    }

    public boolean canMoveTo(Vector2d position){
        return position.follows(this.closest) && position.precedes(this.furthest) && super.canMoveTo(position);
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(closest, furthest);
    }

}
