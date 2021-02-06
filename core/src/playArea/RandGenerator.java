package playArea;

import java.util.ArrayList;
import java.util.Collections;

public class RandGenerator {
    private ArrayList<Integer> randTiles;
    public RandGenerator(){
    init();
    }
    private void init(){
        randTiles = new ArrayList<>();
        for(int i=0;i<48;i++)
            randTiles.add(i);
        Collections.shuffle(randTiles);
    }
    public int getRandTiles(int i){
        return randTiles.get(i);
    }
}
