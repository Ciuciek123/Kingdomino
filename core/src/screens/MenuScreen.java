package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.mygdx.game.Kingdomino;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;

public class MenuScreen extends AbstractScreen{
    private Texture skinButton;
    private Button fullscreenButton;
    private Texture menuImg;
    private TextureRegion fullscreenButtonTexture;
    public MenuScreen(Kingdomino game) {
        super(game);
        init();
        initFullscreenButton();
    }

    private void initFullscreenButton() {
        fullscreenButton = new Button(new ButtonStyle());
        fullscreenButton.setWidth(256);
        fullscreenButton.setHeight(64);
        fullscreenButton.setX(460);
        fullscreenButton.setY(460);
        fullscreenButton.setDebug(true);
        scene.addActor(fullscreenButton);
        fullscreenButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(fullscreenButton.isPressed()){
                    fullscreenButtonTexture = new TextureRegion(skinButton, 1, 64, 256, 64);
                }
                if(!fullscreenButton.isPressed())
                    fullscreenButtonTexture = new TextureRegion(skinButton, 1,1,256,64);
                return false;
            }
        });


    }
    private void
    private void init(){
        skinButton = new Texture("buttons.png");
        fullscreenButtonTexture = new TextureRegion(skinButton, 1,1,256,64);
        menuImg = new Texture("menu.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(menuImg,0,0);
        spriteBatch.draw(fullscreenButtonTexture, 860,460);
        spriteBatch.end();
    }
}
