package Area;

import domino.AreaType;
import domino.Direction;
import domino.Domino;

public class PlayArea {
    private Domino[][] playerTable;
    private boolean[][] isEmpty;

    public Domino getPlayerTable(int x, int y) {
        return playerTable[x][y];
    }

    public PlayArea(){
        playerTable = new Domino[7][7];
        isEmpty = new boolean[7][7];
        init();
    }

    private void init(){
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                playerTable[i][j] = new Domino(AreaType.BLANK, 0);
                isEmpty[i][j]=true;
            }
        //TODO: Do something with this
        playerTable[3][3]=new Domino(AreaType.PLAYER,0);
    }

    public AreaType getField(int i,int j){
        return playerTable[i][j].getField();
    }

    public void setPlayerTable(int x, int y, Domino domino){
        playerTable[x][y]=domino;
    }

    public boolean isEmptyStatus(int x, int y, Direction direction){
        if(direction==Direction.LEFT) return isEmpty[x][y]&&isEmpty[x-1][y];
        if(direction==Direction.DOWN) return isEmpty[x][y]&&isEmpty[x][y-1];
        if(direction==Direction.RIGHT) return isEmpty[x][y]&&isEmpty[x+1][y];
        if(direction==Direction.UP) return isEmpty[x][y]&&isEmpty[x][y+1];
        return false;
    }
    public void setIsEmpty(int i, int j){
        isEmpty[i][j]=false;
    }

}
