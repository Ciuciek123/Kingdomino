package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Kingdomino;

public abstract class AbstractScreen implements Screen {
    protected Kingdomino game;
    protected Stage scene;
    private OrthographicCamera camera;
    protected SpriteBatch spriteBatch;

    public AbstractScreen(Kingdomino game){
        this.game = game;
        createCamera();
        scene = new Stage(new StretchViewport(Kingdomino.width,Kingdomino.height, camera));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(scene);


    }
    private void createCamera(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Kingdomino.width,Kingdomino.height);
        camera.update();
    }

    @Override
    public void show() { }

    @Override
    public void render(float delta) {
        createScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void createScreen() {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void resize(int width, int height) { }
}
