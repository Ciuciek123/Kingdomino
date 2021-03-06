package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Kingdomino;

public class SplashScreen extends AbstractScreen{
    private Texture splashImg;
    public SplashScreen(final Kingdomino game) {
        super(game);
        init();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 1.5F);
    }

    private void init() {
        splashImg = new Texture("splash.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
