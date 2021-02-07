package Area;

import java.util.ArrayList;
import java.util.Collections;

public class RandGenerator {
    private ArrayList<Integer> randTiles;
    private ArrayList<Integer> randTilesHelper;
    public RandGenerator(){
    init();
    }
    private void init(){
        randTiles = new ArrayList<>();
        for(int i=0;i<48;i++)
            randTiles.add(i);
        Collections.shuffle(randTiles);
    }
    public void randomizeChooseArea(int i){
        randTilesHelper = new ArrayList<>();
        randTilesHelper.add(randTiles.get(i));
        randTilesHelper.add(randTiles.get(i+1));
        randTilesHelper.add(randTiles.get(i+2));
        randTilesHelper.add(randTiles.get(i+3));
        Collections.sort(randTilesHelper);
    }
    public int getRandTiles(int i){
        return randTilesHelper.get(i);
    }
    public void clearHelper(){
        randTilesHelper.clear();
    }
}
