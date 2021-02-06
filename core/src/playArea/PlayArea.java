package playArea;

import domino.AreaType;
import domino.Domino;

public class PlayArea {
    private Domino[][] playerTable;
    public PlayArea(){
        playerTable = new Domino[7][7];
        init();
    }
    private void init(){
        for(int i=0;i<7;i++)
            for(int j=0;j<7;j++)
                playerTable[i][j] = new Domino(AreaType.BLANK,0);
    }
}
