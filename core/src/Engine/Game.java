package Engine;

import com.badlogic.gdx.graphics.Texture;
import domino.AreaType;
import domino.Direction;
import domino.Domino;

import java.util.ArrayList;

public class Game {
    private Player p1;
    private Player p2;
    private Token playerToken;
    private int round=0;
    private Token[] queue;
    private Token[] queueHelper;
    private int checkCount=0;

    public void setQueue(int index) {
        queueHelper[index]=playerToken;
    }
    public Token getQueue(int index) {
        return queue[index];
    }



    public void nextRound() {
        round++;
        checkCount=0;
        playerToken=queueHelper[0];
        for(int i=0; i<4 ; i++)
            queue[i]=queueHelper[i];
    }

    public void setCheckCount() {
        if(checkCount<3)
            checkCount++;
    }



    public int getRound() {
        return round;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public AreaType getField(int i, int j){
        if(playerToken==Token.P1)
            return p1.getField(i,j);
        else if(playerToken==Token.P2)
            return p2.getField(i,j);
        return AreaType.BLANK;
    }

    public void setDomino(int x, int y, Domino domino1, Domino domino2, Direction direction){
        if(playerToken==Token.P1)
            p1. setDomino(x,y,domino1,domino2,direction);
        else if(playerToken==Token.P2)
            p2. setDomino(x,y,domino1,domino2,direction);
    }

    public boolean canSetDomino(int x, int y, Direction direction){
        if(playerToken==Token.P1)
            return p1.canSetDomino(x,y,direction);
        else if(playerToken==Token.P2)
            return p2. canSetDomino(x,y,direction);
        return false;
    }

    public Game(){
        init();
        initQueue();
    }

    private void initQueue() {
        queue[0]=(Token.P1);
        queue[1]=(Token.P2);
        queue[2]=(Token.P1);
        queue[3]=(Token.P2);
    }

    public Token getPlayerToken() {
        return playerToken;
    }

    private void init() {
        p1 = new Player();
        p2 = new Player();
        p1.setTexture("Player1.png");
        p2.setTexture("Player2.png");
        playerToken = Token.P1;
        queue = new Token[4];
        queueHelper = new Token[4];
    }
    public Texture getPlayerTexture() {
        if(playerToken==Token.P1)
            return p1.getPlayerImage();
        else if(playerToken==Token.P2)
            return p2.getPlayerImage();
        return p1.getPlayerImage();
    }
    public Texture getPlayer1Texture() {
        return p1.getPlayerImage();
    }
    public Texture getPlayer2Texture() {
        return p2.getPlayerImage();
    }
    public void changePlayer(){
        if(checkCount<3) {
            playerToken = queue[checkCount+1];
        }
//        else
//            nextRound();
    }
}
