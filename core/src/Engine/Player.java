package Engine;

import Area.PlayArea;
import com.badlogic.gdx.graphics.Texture;
import domino.AreaType;
import domino.Direction;
import domino.Domino;

public class Player{
    private Texture playerImage;
    int points = 0;
    PlayArea playerArea = new PlayArea();
    public Player() {

    }
    public void setTexture(String image){
        playerImage = new Texture(image);
    }

    public Texture getPlayerImage() {
        return playerImage;
    }

    public void setDomino(int x, int y, Domino domino1, Domino domino2, Direction direction){
        if(playerArea.isEmptyStatus(x,y,direction)&&direction==Direction.LEFT) {
            playerArea.setPlayerTable(x,y,domino1);
            playerArea.setPlayerTable(x+1,y,domino2);
        }
        if(playerArea.isEmptyStatus(x,y,direction)&&direction==Direction.DOWN) {
            playerArea.setPlayerTable(x,y,domino1);
            playerArea.setPlayerTable(x,y-1,domino2);
        }
        if(playerArea.isEmptyStatus(x,y,direction)&&direction==Direction.RIGHT) {
            playerArea.setPlayerTable(x,y,domino1);
            playerArea.setPlayerTable(x-1,y,domino2);
        }
        if(playerArea.isEmptyStatus(x,y,direction)&&direction==Direction.UP) {
            playerArea.setPlayerTable(x,y,domino1);
            playerArea.setPlayerTable(x,y+1,domino2);
        }
    }
}
