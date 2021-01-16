package screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Kingdomino;

public class MenuScreen extends AbstractScreen{

    private Texture menuImg;
    public MenuScreen(Kingdomino game) {
        super(game);
        init();
    }
    private void init(){
        menuImg = new Texture("menu.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(menuImg,0,0);
        spriteBatch.end();
    }
}
