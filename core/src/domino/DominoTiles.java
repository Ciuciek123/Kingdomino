package domino;

import Engine.Token;

public class DominoTiles {
    private Domino[][] dominoTiles;
    private Token whoHave[];

    public Token getIsChoose(int index) {
        return whoHave[index];
    }

    public DominoTiles(){
        dominoTiles = new Domino[48][2];
        whoHave = new Token[48];
        initWhoHave();
        initDomino();
    }

    private void initWhoHave() {
        for(int i=0;i<48;i++)
            whoHave[i]=Token.NOBODY;
    }

    private void initDomino(){
        //Domino nr.1
        dominoTiles[0][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[0][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.2
        dominoTiles[1][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[1][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.3
        dominoTiles[2][0] = new Domino(AreaType.FOREST, 0);
        dominoTiles[2][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.4
        dominoTiles[3][0] = new Domino(AreaType.FOREST, 0);
        dominoTiles[3][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.5
        dominoTiles[4][0] = new Domino(AreaType.FOREST, 0);
        dominoTiles[4][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.6
        dominoTiles[5][0] = new Domino(AreaType.FOREST, 0);
        dominoTiles[5][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.7
        dominoTiles[6][0] = new Domino(AreaType.LAKE, 0);
        dominoTiles[6][1] = new Domino(AreaType.LAKE, 0);
        //Domino nr.8
        dominoTiles[7][0] = new Domino(AreaType.LAKE, 0);
        dominoTiles[7][1] = new Domino(AreaType.LAKE, 0);
        //Domino nr.9
        dominoTiles[8][0] = new Domino(AreaType.LAKE, 0);
        dominoTiles[8][1] = new Domino(AreaType.LAKE, 0);
        //Domino nr.10
        dominoTiles[9][0] = new Domino(AreaType.MEADOW, 0);
        dominoTiles[9][1] = new Domino(AreaType.MEADOW, 0);
        //Domino nr.11
        dominoTiles[10][0] = new Domino(AreaType.MEADOW, 0);
        dominoTiles[10][1] = new Domino(AreaType.MEADOW, 0);
        //Domino nr.12
        dominoTiles[11][0] = new Domino(AreaType.SWAMP, 0);
        dominoTiles[11][1] = new Domino(AreaType.SWAMP, 0);
        //Domino nr.13
        dominoTiles[12][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[12][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.14
        dominoTiles[13][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[13][1] = new Domino(AreaType.LAKE, 0);
        //Domino nr.15
        dominoTiles[14][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[14][1] = new Domino(AreaType.MEADOW, 0);
        //Domino nr.16
        dominoTiles[15][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[15][1] = new Domino(AreaType.SWAMP, 0);
        //Domino nr.17
        dominoTiles[16][0] = new Domino(AreaType.FOREST, 0);
        dominoTiles[16][1] = new Domino(AreaType.LAKE, 0);
        //Domino nr.18
        dominoTiles[17][0] = new Domino(AreaType.FOREST, 0);
        dominoTiles[17][1] = new Domino(AreaType.MEADOW, 0);
        //Domino nr.19
        dominoTiles[18][0] = new Domino(AreaType.FARMLAND, 1);
        dominoTiles[18][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.20
        dominoTiles[19][0] = new Domino(AreaType.FARMLAND, 1);
        dominoTiles[19][1] = new Domino(AreaType.LAKE, 0);
        //Domino nr.21
        dominoTiles[20][0] = new Domino(AreaType.FARMLAND, 1);
        dominoTiles[20][1] = new Domino(AreaType.MEADOW, 0);
        //Domino nr.22
        dominoTiles[21][0] = new Domino(AreaType.FARMLAND, 1);
        dominoTiles[21][1] = new Domino(AreaType.SWAMP, 0);
        //Domino nr.23
        dominoTiles[22][0] = new Domino(AreaType.FARMLAND, 1);
        dominoTiles[22][1] = new Domino(AreaType.MINE, 0);
        //Domino nr.24
        dominoTiles[23][0] = new Domino(AreaType.FOREST, 1);
        dominoTiles[23][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.25
        dominoTiles[24][0] = new Domino(AreaType.FOREST, 1);
        dominoTiles[24][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.26
        dominoTiles[25][0] = new Domino(AreaType.FOREST, 1);
        dominoTiles[25][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.27
        dominoTiles[26][0] = new Domino(AreaType.FOREST, 1);
        dominoTiles[26][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.28
        dominoTiles[27][0] = new Domino(AreaType.FOREST, 1);
        dominoTiles[27][1] = new Domino(AreaType.LAKE, 0);
        //Domino nr.29
        dominoTiles[28][0] = new Domino(AreaType.FOREST, 1);
        dominoTiles[28][1] = new Domino(AreaType.MEADOW, 0);
        //Domino nr.30
        dominoTiles[29][0] = new Domino(AreaType.LAKE, 1);
        dominoTiles[29][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.31
        dominoTiles[30][0] = new Domino(AreaType.LAKE, 1);
        dominoTiles[30][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.32
        dominoTiles[31][0] = new Domino(AreaType.LAKE, 1);
        dominoTiles[31][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.33
        dominoTiles[32][0] = new Domino(AreaType.LAKE, 1);
        dominoTiles[32][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.34
        dominoTiles[33][0] = new Domino(AreaType.LAKE, 1);
        dominoTiles[33][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.35
        dominoTiles[34][0] = new Domino(AreaType.LAKE, 1);
        dominoTiles[34][1] = new Domino(AreaType.FOREST, 0);
        //Domino nr.36
        dominoTiles[35][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[35][1] = new Domino(AreaType.MEADOW, 1);
        //Domino nr.37
        dominoTiles[36][0] = new Domino(AreaType.LAKE, 0);
        dominoTiles[36][1] = new Domino(AreaType.MEADOW, 1);
        //Domino nr.38
        dominoTiles[37][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[37][1] = new Domino(AreaType.SWAMP, 1);
        //Domino nr.39
        dominoTiles[38][0] = new Domino(AreaType.MEADOW, 0);
        dominoTiles[38][1] = new Domino(AreaType.SWAMP, 1);
        //Domino nr.40
        dominoTiles[39][0] = new Domino(AreaType.MINE, 1);
        dominoTiles[39][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.41
        dominoTiles[40][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[40][1] = new Domino(AreaType.MEADOW, 2);
        //Domino nr.42
        dominoTiles[41][0] = new Domino(AreaType.LAKE, 0);
        dominoTiles[41][1] = new Domino(AreaType.MEADOW, 2);
        //Domino nr.43
        dominoTiles[42][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[42][1] = new Domino(AreaType.SWAMP, 2);
        //Domino nr.44
        dominoTiles[43][0] = new Domino(AreaType.MEADOW, 0);
        dominoTiles[43][1] = new Domino(AreaType.SWAMP, 2);
        //Domino nr.45
        dominoTiles[44][0] = new Domino(AreaType.MINE, 2);
        dominoTiles[44][1] = new Domino(AreaType.FARMLAND, 0);
        //Domino nr.46
        dominoTiles[45][0] = new Domino(AreaType.SWAMP, 0);
        dominoTiles[45][1] = new Domino(AreaType.MINE, 2);
        //Domino nr.47
        dominoTiles[46][0] = new Domino(AreaType.SWAMP, 0);
        dominoTiles[46][1] = new Domino(AreaType.MINE, 2);
        //Domino nr.48
        dominoTiles[47][0] = new Domino(AreaType.FARMLAND, 0);
        dominoTiles[47][1] = new Domino(AreaType.MINE, 3);
    }
    public boolean setIsChoose(Token p,int index){
        if(whoHave[index]!=Token.P1&& whoHave[index]!=Token.P2){
        whoHave[index]=p;
        return true;
        }
        return false;
    }
}
