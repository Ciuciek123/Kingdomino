package screens;

import Engine.Game;
import Engine.Token;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Kingdomino;
import domino.AreaType;
import domino.DominoTiles;
import domino.DominoTilesView;
import Area.RandGenerator;

import java.util.ArrayList;

public class PlayScreen extends AbstractScreen{
    private RandGenerator generator = new RandGenerator();
    private Button exitButton;
    private Button chooseButton[];
    private Button nextRoundButton;
    private TextureRegion nextRoundButtonTexture;
    private DominoTilesView dominoView;
    private DominoTiles oneDomino;
    private Texture skinButton;
    private TextureRegion exitButtonTexture;
    private Texture area;
    private Game game;
    private int actuallyChoose;
    private ArrayList<Integer> dominoOnArea;
    public PlayScreen(Kingdomino game) {
        super(game);
        init();
        initExitButton();
        initChooseButtons();
        initNextRoundButton();
    }

    private void initNextRoundButton() {
        nextRoundButton = new Button(new Button.ButtonStyle());
        nextRoundButton.setWidth(256);
        nextRoundButton.setHeight(64);
        nextRoundButton.setX(1000);
        nextRoundButton.setY(1000);
        nextRoundButton.setDebug(true);
        scene.addActor(nextRoundButton);
        nextRoundButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(game.getRound()<11&&game.getCheckCount()==3) {
                    game.nextRound();
                    generator.clearHelper();
                    generator.randomizeChooseArea(game.getRound()*4);
                }
            };
        });
    }

    private void initChooseButtons() {
        chooseButton = new Button[4];
        for (int i = 0; i <4; i++) {
            chooseButton[i] = new Button(new Button.ButtonStyle());
            chooseButton[i].setHeight(127);
            chooseButton[i].setWidth(255);
            chooseButton[i].setX(1200);
            chooseButton[i].setY(600-i*150);
            chooseButton[i].setDebug(true);
            scene.addActor(chooseButton[i]);
            final int finalI = i;
            chooseButton[i].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(oneDomino.isNOBODY(generator.getRandTiles(finalI))){
                        game.setQueue(finalI);
                        oneDomino.setWhoHave(game.getQueue(game.getCheckCount()), generator.getRandTiles(finalI));
                        dominoView.domino[generator.getRandTiles(finalI)].y=1;
                        dominoView.domino[generator.getRandTiles(finalI)].x=1;
                        actuallyChoose = generator.getRandTiles(finalI);
                        dominoOnArea.add(actuallyChoose);
                        oneDomino.setWhoHave(game.getQueue(game.getCheckCount()),actuallyChoose);
                    }
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

    private void chooseArea(){
        for (int i = 0; i <4; i++) {
            if(oneDomino.getWhoHave(generator.getRandTiles(i)) ==Token.NOBODY){
                dominoView.domino[generator.getRandTiles(i)].y=600-i*150;
                spriteBatch.draw(dominoView.domino[generator.getRandTiles(i)].getTexture(),dominoView.domino[generator.getRandTiles(i)].x,dominoView.domino[generator.getRandTiles(i)].y);
            }
            if(oneDomino.getWhoHave(generator.getRandTiles(i)) == Token.P1)
                spriteBatch.draw(game.getPlayer1Texture(),1200,600-i*150);
            if(oneDomino.getWhoHave(generator.getRandTiles(i)) == Token.P2)
                spriteBatch.draw(game.getPlayer2Texture(),1200,600-i*150);
        }
    }

    private void drawPlayerArea(){
        for(int row=0;row<7;row++)
            for(int col=0;col<7;col++){
                if(game.getField(row,col)== AreaType.PLAYER)
                    spriteBatch.draw(game.getPlayerTexture(),row*127,col*127);
            }
        for(int i=0; i<dominoOnArea.size();i++){
            if(game.getPlayerToken()==Token.P1&&oneDomino.getWhoHave(dominoOnArea.get(i))==Token.P1)
                 spriteBatch.draw(dominoView.domino[dominoOnArea.get(i)].getTexture(),dominoView.domino[dominoOnArea.get(i)].x,dominoView.domino[dominoOnArea.get(i)].y);
            if(game.getPlayerToken()==Token.P2&&oneDomino.getWhoHave(dominoOnArea.get(i))==Token.P2)
                spriteBatch.draw(dominoView.domino[dominoOnArea.get(i)].getTexture(),dominoView.domino[dominoOnArea.get(i)].x,dominoView.domino[dominoOnArea.get(i)].y);
        }

    }

    private void init() {
        dominoOnArea = new ArrayList<>();
        game = new Game();
        oneDomino = new DominoTiles();
        dominoView = new DominoTilesView();
        skinButton = new Texture("exitButton.png");
        exitButtonTexture = new TextureRegion(skinButton, 1,1,256,64);
        nextRoundButtonTexture = new TextureRegion(skinButton, 1,1,256,64);
        area = new Texture("playArea.png");
        generator.randomizeChooseArea(game.getRound()*4);
    }


    private void update(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            dominoView.domino[actuallyChoose].y+=127;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            dominoView.domino[actuallyChoose].x-=127;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            dominoView.domino[actuallyChoose].y-=127;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            dominoView.domino[actuallyChoose].x+=127;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            if((game.canSetDomino((dominoView.domino[actuallyChoose].x-1)/127,(dominoView.domino[actuallyChoose].y-1)/127, oneDomino.getDirection(actuallyChoose)))) {
                game.setDomino((dominoView.domino[actuallyChoose].x - 1) / 127, (dominoView.domino[actuallyChoose].y - 1) / 127, oneDomino.getDomino(actuallyChoose, 0), oneDomino.getDomino(actuallyChoose, 1), oneDomino.getDirection(actuallyChoose));
                game.changePlayer();
                game.setCheckCount();
            }
        }
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        spriteBatch.begin();
        spriteBatch.draw(exitButtonTexture,1600,1000);
        spriteBatch.draw(nextRoundButtonTexture,1000,1000);
        drawPlayerArea();
        chooseArea();
        spriteBatch.draw(area,1,1);
        spriteBatch.end();
    }
}
