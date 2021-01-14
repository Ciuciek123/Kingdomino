package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.SplashScreen;

public class Kingdomino extends Game {
	public static final String gameName = "Kingdomino";
	public static final int width = 1920;
	public static final int height = 1080;
	private boolean paused;


	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	/*
	Getters and Setters
	  */
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

}
