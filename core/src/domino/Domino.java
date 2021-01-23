package domino;

enum AreaType{
    FOREST,
    FARMLAND,
    LAKE,
    MEADOW,
    SWAMP,
    MINE
}

public class Domino {
    private final AreaType[] field;
    public Domino(AreaType type1, AreaType type2){
        field = new AreaType[2];
        field[0]=type1;
        field[1]=type2;
    }

    public AreaType[] getField() {
        return field;
    }
}
