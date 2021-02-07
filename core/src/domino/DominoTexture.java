package domino;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class DominoTexture extends Rectangle {
    private TextureRegion texture;
    DominoTexture(TextureRegion texture){
        this.texture = texture;
    }

    public TextureRegion getTexture() {
        return texture;
    }
}
