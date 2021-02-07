package domino;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class DominoTilesView {
    private Texture skinDomino;
    public DominoTexture[] domino;

    public DominoTilesView() {
        init();
    }

    private void init() {
        skinDomino = new Texture("front.jpg");
        domino = new DominoTexture[48];
        int temp = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                if (j * 255 == 0) {
                    domino[temp] = new DominoTexture(new TextureRegion(skinDomino, 1, i * 127, 255, 127));
                } else if (i * 127 == 0)
                    domino[temp] = new DominoTexture(new TextureRegion(skinDomino, j * 255, 1, 255, 127));
                else domino[temp] = new DominoTexture(new TextureRegion(skinDomino, j * 255, i * 127, 255, 127));
                temp++;
            }
        }
        for(int i=0;i<48;i++){
            domino[i].x=1200;
            domino[i].y=1;
        }
    }
}
