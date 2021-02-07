package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Kingdomino;
import domino.DominoTexture;
import playArea.RandGenerator;

public class PlayScreen extends AbstractScreen{
    private RandGenerator dominoTiles = new RandGenerator();
    private Button exitButton;
    private DominoTexture dominoView;
    private int round = 0 ;
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
    private void chooseArea(){
        dominoTiles.randomizeChooseArea(round*4);
        spriteBatch.draw(dominoView.getDominoTexture(dominoTiles.getRandTiles(0)),1400,600);
        spriteBatch.draw(dominoView.getDominoTexture(dominoTiles.getRandTiles(1)),1400,450);
        spriteBatch.draw(dominoView.getDominoTexture(dominoTiles.getRandTiles(2)),1400,300);
        spriteBatch.draw(dominoView.getDominoTexture(dominoTiles.getRandTiles(3)),1400,150);
        dominoTiles.clearHelper();
    }
    private void init() {
       // dominoTiles.randomizeChooseArea(round*4);
        dominoView = new DominoTexture();
        skinExitButton = new Texture("exitButton.png");
        exitButtonTexture = new TextureRegion(skinExitButton, 1,1,256,64);
        area = new Texture("playArea.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(exitButtonTexture,1600,1000);
        chooseArea();
        spriteBatch.draw(area,1,1);
        spriteBatch.end();
    }
}
