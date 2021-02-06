package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Kingdomino;

public class PlayScreen extends AbstractScreen{
    private Button exitButton;
    private Texture skinExitButton;
    private TextureRegion exitButtonTexture;
    private Texture area;
    public PlayScreen(Kingdomino game) {
        super(game);
        init();
        initExitButton();
    }

    private void initExitButton() {
        exitButton = new Button(new Button.ButtonStyle());
        exitButton.setWidth(256);
        exitButton.setHeight(64);
        exitButton.setX(1600);
        exitButton.setY(1000);
        exitButton.setDebug(true);
        scene.addActor(exitButton);
        exitButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(exitButton.isPressed()) {
                    exitButtonTexture = new TextureRegion(skinExitButton, 1, 64, 256, 64);
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            Gdx.app.exit();
                        }
                    },0.25F);
                }
                return false;
            }
        });
    }

    private void init() {
        skinExitButton = new Texture("exitButton.png");
        exitButtonTexture = new TextureRegion(skinExitButton, 1,1,256,64);
        area = new Texture("playArea.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(exitButtonTexture,1600,1000);
        spriteBatch.draw(area,1,1);
        spriteBatch.end();
    }
}
