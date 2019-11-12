package agh.cs.lab2;


public enum MapDirections {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        switch(this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
            default: return "";
        }
    }

    public String toChar(){
        switch(this) {
            case NORTH:
                return "^";
            case SOUTH:
                return "v";
            case WEST:
                return "<";
            case EAST:
                return ">";
            default: return "";
        }
    }

    public MapDirections next(){
        switch(this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            default: return NORTH;
        }
    }
    public MapDirections previous(){
        switch(this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
            default: return NORTH;
        }
    }

    public Vector2d toUnitVector(){
        switch(this) {
            case NORTH:
                return new Vector2d(0,1);
            case SOUTH:
                return new Vector2d(0,-1);
            case WEST:
                return new Vector2d(-1,0);
            case EAST:
                return new Vector2d(1,0);
            default: return new Vector2d(0,0);
        }
    }
}