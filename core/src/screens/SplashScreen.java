package screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Kingdomino;

public class SplashScreen extends AbstractScreen{
    private Texture splashImg;
    public SplashScreen(Kingdomino game) {
        super(game);
        init();
    }

    private void init() {
        splashImg = new Texture("menu.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
