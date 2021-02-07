package screens;

import Engine.Game;
import Engine.Token;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Kingdomino;
import domino.DominoTiles;
import domino.DominoTilesView;
import Area.RandGenerator;

public class PlayScreen extends AbstractScreen{
    private RandGenerator dominoTiles = new RandGenerator();
    private Button exitButton;
    private Button chooseButton[];
    private DominoTilesView dominoView;
    private DominoTiles oneDomino;
    private Texture skinExitButton;
    private TextureRegion exitButtonTexture;
    private Texture area;
    private Game game;
    public PlayScreen(Kingdomino game) {
        super(game);
        init();
        initExitButton();
        initChooseButtons();
    }

    private void initChooseButtons() {
        chooseButton = new Button[4];
        for (int i = 0; i <4; i++) {
            chooseButton[i] = new Button(new Button.ButtonStyle());
            chooseButton[i].setHeight(127);
            chooseButton[i].setWidth(255);
            chooseButton[i].setX(1400);
            chooseButton[i].setY(600-i*150);
            chooseButton[i].setDebug(true);
            scene.addActor(chooseButton[i]);
            final int finalI = i;
            chooseButton[i].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    oneDomino.setIsChoose(game.getPlayerToken(), dominoTiles.getRandTiles(finalI));
                    game.changePlayer();
                };
            });
        }
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
        if(game.getCheckCount()==0)
        dominoTiles.randomizeChooseArea(game.getRound()*4);
        spriteBatch.draw(dominoView.domino[dominoTiles.getRandTiles(0)].getTexture(),1400,600);
        spriteBatch.draw(dominoView.domino[dominoTiles.getRandTiles(1)].getTexture(),1400,450);
        spriteBatch.draw(dominoView.domino[dominoTiles.getRandTiles(2)].getTexture(),1400,300);
        spriteBatch.draw(dominoView.domino[dominoTiles.getRandTiles(3)].getTexture(),1400,150);
        for (int i = 0; i <4; i++) {
            if(oneDomino.getIsChoose(dominoTiles.getRandTiles(i)) == Token.P1)
                spriteBatch.draw(game.getPlayer1Texture(),1400,600-i*150);
            if(oneDomino.getIsChoose(dominoTiles.getRandTiles(i)) == Token.P2)
                spriteBatch.draw(game.getPlayer2Texture(),1400,600-i*150);
        }
        if(game.getCheckCount()==3)
        dominoTiles.clearHelper();
    }
    private void init() {

        game = new Game();
        oneDomino = new DominoTiles();
        dominoView = new DominoTilesView();
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
