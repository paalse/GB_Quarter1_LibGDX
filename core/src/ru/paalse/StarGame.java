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
		img = new Texture("badlogic.jpg"); // Загрузка текстуры из папки assets
		region = new TextureRegion(img, 20,25,100,50);
	}

	@Override
	public void render () { // Отвечает за периоодическую отрисовку текстур
		Gdx.gl.glClearColor(1, 0.5f, 0, 1); // Установка фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);				 	// Очистка экрана
		batch.begin();
		batch.setColor(0.1f,0.9f, 0.5f, 0.9f);
		batch.draw(img,0,0);
		batch.setColor(0.6f,0.3f, 0.2f, 0.3f);
		batch.draw(region, 200,200);
		batch.end();
	}
	
	@Override
	public void dispose () { // Отвечает за очистку памяти от текстур
		batch.dispose();
		img.dispose();
	}
}
