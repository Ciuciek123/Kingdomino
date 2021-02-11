package domino;


public class Domino {
    private final AreaType field;
    private final int crownCount;

    public Domino(AreaType type, int crown){
        field=type;
        crownCount = crown;
    }

    public AreaType getField() {
        return field;
    }

    public int getCrownCount() {
        return crownCount;
    }
}
