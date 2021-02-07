package Engine;

import Area.PlayArea;
import com.badlogic.gdx.graphics.Texture;

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
}
