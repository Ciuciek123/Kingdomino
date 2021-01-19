package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Kingdomino;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
//import domino.dominoTexture;

public class MenuScreen extends AbstractScreen{
    private Texture skinButton;
    private Button exitButton;
    private Texture menuImg;
    private TextureRegion exitButtonTexture;
//    dominoTexture domino = new dominoTexture();
    public MenuScreen(Kingdomino game) {
        super(game);
        init();
        initFullscreenButton();
    }

    private void initFullscreenButton() {
        exitButton = new Button(new ButtonStyle());
        exitButton.setWidth(256);
        exitButton.setHeight(64);
        exitButton.setX(860);
        exitButton.setY(460);
        exitButton.setDebug(true);
        scene.addActor(exitButton);
        exitButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(exitButton.isPressed()) {
                    exitButtonTexture = new TextureRegion(skinButton, 1, 64, 256, 64);
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
    private void init(){
        skinButton = new Texture("exitButton.png");
        exitButtonTexture = new TextureRegion(skinButton, 1,1,256,64);
        menuImg = new Texture("menu.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(menuImg,0,0);
        spriteBatch.draw(exitButtonTexture, 860,460);
//        spriteBatch.draw(domino.getDominoTexture(0),500,500 );
        spriteBatch.end();
    }
}
