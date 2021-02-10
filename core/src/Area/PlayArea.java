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
        //TODO: Do somting with dis
        playerTable[4][4]=new Domino(AreaType.PLAYER,0);
    }

    public void setPlayerTable(int x, int y, Domino domino){
        playerTable[x][y]=domino;
    }

//    public void setDomino(int x, int y, Domino domino1, Domino domino2, Direction direction){
//        if(isEmptyStatus(x,y,direction)&&direction==Direction.LEFT) {
//            playerTable[x][y] = domino1;
//            playerTable[x+1][y] = domino2;
//        }
//        if(isEmptyStatus(x,y,direction)&&direction==Direction.DOWN) {
//            playerTable[x][y] = domino1;
//            playerTable[x][y-1] = domino2;
//        }
//        if(isEmptyStatus(x,y,direction)&&direction==Direction.RIGHT) {
//            playerTable[x][y] = domino1;
//            playerTable[x-1][y] = domino2;
//        }
//        if(isEmptyStatus(x,y,direction)&&direction==Direction.UP) {
//            playerTable[x][y] = domino1;
//            playerTable[x][y+1] = domino2;
//        }
//    }

    public boolean isEmptyStatus(int x, int y, Direction direction){
        if(direction==Direction.LEFT) return isEmpty[x][y]&&isEmpty[x+1][y];
        if(direction==Direction.DOWN) return isEmpty[x][y]&&isEmpty[x][y-1];
        if(direction==Direction.RIGHT) return isEmpty[x][y]&&isEmpty[x-1][y];
        if(direction==Direction.UP) return isEmpty[x][y]&&isEmpty[x][y+1];
        return false;
    }

}
