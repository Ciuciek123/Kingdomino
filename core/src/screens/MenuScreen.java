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
    private Button exitButton;
    private Button playButton;
    private Texture menuImg;
    private Texture skinExitButton;
    private Texture skinPlayButton;
    private TextureRegion playButtonTexture;
    private TextureRegion exitButtonTexture;
//    dominoTexture domino = new dominoTexture();
    public MenuScreen(Kingdomino game) {
        super(game);
        init();
        initExitButton();
        initPlayButton();
    }

    private void initPlayButton() {
        playButton = new Button(new ButtonStyle());
        playButton.setWidth(256);
        playButton.setHeight(64);
        playButton.setX(460);
        playButton.setY(460);
        playButton.setDebug(true);
        scene.addActor(playButton);
        playButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if (playButton.isPressed()) {
                    playButtonTexture = new TextureRegion(skinPlayButton, 1, 64, 256, 64);
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            game.setScreen(new PlayScreen(game));
                        }
                    }, 0.25F);
                }
                return false;
            }
        });
    }

    private void initExitButton() {
        exitButton = new Button(new ButtonStyle());
        exitButton.setWidth(256);
        exitButton.setHeight(64);
        exitButton.setX(960);
        exitButton.setY(460);
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
    private void init(){
        skinExitButton = new Texture("exitButton.png");
        exitButtonTexture = new TextureRegion(skinExitButton, 1,1,256,64);
        skinPlayButton = new Texture("playButton.png");
        playButtonTexture = new TextureRegion(skinPlayButton, 1,1,256,64);
        menuImg = new Texture("menu.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(menuImg,0,0);
        spriteBatch.draw(exitButtonTexture, 960,460);
        spriteBatch.draw(playButtonTexture, 460,460);
//        spriteBatch.draw(domino.getDominoTexture(0),500,500 );
        spriteBatch.end();
    }
}
