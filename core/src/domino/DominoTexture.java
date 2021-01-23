package domino;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DominoTexture {
    private Texture skinDomino;
    private TextureRegion[] dominoTexture;
    public DominoTexture(){
        init();
    }

    private void init() {
        skinDomino = new Texture("front.jpg");
        dominoTexture = new TextureRegion[48];
        int temp =0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                if(j*255==0)
                    dominoTexture[temp] = new TextureRegion(skinDomino, 1, i*127, 255, 127);
                else if(i*127==0)
                    dominoTexture[temp] = new TextureRegion(skinDomino, j*255, 1, 255, 127);
                else
                    dominoTexture[temp] = new TextureRegion(skinDomino, j*255, i*127, 255, 127);
                temp++;
                System.out.println(temp);
            }
        }
    }


    public TextureRegion getDominoTexture(int dominoIdx) {
        return dominoTexture[dominoIdx];
    }
}
