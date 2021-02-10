package Engine;

import com.badlogic.gdx.graphics.Texture;
import domino.Direction;
import domino.Domino;

public class Game {
    private Player p1;
    private Player p2;
    private Token playerToken;
    private int round=0;

    public void nextRound() {
        round++;
        checkCount=0;
    }

    public void setCheckCount() {
        if(checkCount<5)
            checkCount++;
    }

    private int checkCount=0;
    public int getRound() {
        return round;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public void setDomino(int x, int y, Domino domino1, Domino domino2, Direction direction){
        if(playerToken==Token.P1)
            p1. setDomino(x,y,domino1,domino2,direction);
        else if(playerToken==Token.P2)
            p2. setDomino(x,y,domino1,domino2,direction);
    }

    public Game(){
        init();
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
    }

    public Texture getPlayer1Texture() {
        return p1.getPlayerImage();
    }
    public Texture getPlayer2Texture() {
        return p2.getPlayerImage();
    }
    public void changePlayer(){
        if(playerToken == Token.P1)
            playerToken=Token.P2;
        else
            playerToken=Token.P1;
    }
}
