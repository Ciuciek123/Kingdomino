package domino;


public class Domino {
    private final AreaType field;
    private final int crownCount;
    private Direction direction;
    private int areaPosX;
    private int areaPosY;
    public Domino(AreaType type, int crown){
        field=type;
        crownCount = crown;
        areaPosX=4;
        areaPosY=4;
        direction = Direction.RIGHT;
    }

    public AreaType getField() {
        return field;
    }
    public void setPos(int x, int y){
        areaPosX=x;
        areaPosY=y;
    }
    public Direction getDirection(){
        return direction;
    }
    public int getCrownCount() {
        return crownCount;
    }
}
