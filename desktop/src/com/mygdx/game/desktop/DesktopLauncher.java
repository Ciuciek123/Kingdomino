package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Kingdomino;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Kingdomino.gameName;
		config.width = Kingdomino.width;
		config.height = Kingdomino.height;

		new LwjglApplication(new Kingdomino(), config);
	}
}
