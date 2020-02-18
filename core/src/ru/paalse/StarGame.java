package ru.paalse;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion region;
	
	@Override
	public void create () { // Отвечает за инициализацию
		batch = new SpriteBatch();
		img = new Texture("star_sky.jpg"); // Загрузка текстуры из папки assets
	}

	@Override
	public void render () { // Отвечает за периоодическую отрисовку текстур
		Gdx.gl.glClearColor(0, 0, 0, 1); // Установка фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);				 	// Очистка экрана
		batch.begin();
		batch.draw(img,0,0, 1440, 2960);
		batch.end();
	}
	
	@Override
	public void dispose () { // Отвечает за очистку памяти от текстур
		batch.dispose();
		img.dispose();
	}
}
