package com.molamosmucho.gluglu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.ApplicationAdapter;

public class GlugluMikelAngelo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;

	Texture mikelAngeloLoading;
	float mikelAngeloLoadingWidth;
	float mikelAngeloLoadingHeight;

	Texture mikelAngelo;
	float mikelAngeloWidth;
	float mikelAngeloHeight;

	// Game logic
	int gameState = 0;
	float gravity = 2;
	// Position and speed
	float posY;
	float velY;

	Music bgMusic;
	Sound soundLoading;

	@Override
	public void create () {
		batch = new SpriteBatch();

		background = new Texture("bg.gif");

		// MikelAngeloLoading + propiedades
		mikelAngeloLoading = new Texture("mikelangelo.png");
		mikelAngeloLoadingWidth = mikelAngeloLoading.getWidth();
		mikelAngeloLoadingHeight = mikelAngeloLoading.getHeight();

		mikelAngelo = new Texture("cachamessi.png");
		mikelAngeloWidth = mikelAngelo.getWidth();
		mikelAngeloHeight = mikelAngelo.getHeight();

		posY = ((Gdx.graphics.getHeight() - mikelAngeloHeight)/2);

		bgMusic = Gdx.audio.newMusic(Gdx.files.internal("bgmusic.mp3"));
		// bgMusic.play();
	}

	@Override
	public void render () {
		// Gamestate [0 = parado, 1
		if(gameState != 0){
			if(Gdx.input.justTouched()) {
				velY = -30;
			}
			velY += gravity;
			posY -= velY;
		} else {
			// TODO: Loading screen goes here
			// Start the game
			if(Gdx.input.justTouched()){
				gameState = 1;
			}
		}

		batch.begin();

		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// LOADING
		/*
		float mikelAngeloX = (Gdx.graphics.getWidth() - mikelAngeloLoadingWidth)/2;
		float mikelAngeloY = (Gdx.graphics.getHeight() - mikelAngeloLoadingHeight)/2;
		batch.draw(mikelAngeloLoading, mikelAngeloX, mikelAngeloY, mikelAngeloLoadingWidth, mikelAngeloLoadingHeight);
		*/

		// Draw mikelAngelo
		float mikelAngeloPlayingX = (Gdx.graphics.getWidth()/4 - mikelAngeloWidth/2);
		batch.draw(mikelAngelo, mikelAngeloPlayingX, posY, mikelAngeloWidth, mikelAngeloHeight);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
