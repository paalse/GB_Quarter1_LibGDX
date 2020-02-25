package ru.paalse.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.paalse.base.BaseScreen;
import ru.paalse.math.Rect;
import ru.paalse.sprite.Background;
import ru.paalse.sprite.Pic;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private  Texture bg;

    private Background background;
    private Pic pic;



    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/bg.png");

        background = new Background(bg);
        pic = new Pic(img);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 0.9f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        pic.update(delta);

        batch.begin();
        background.draw(batch);
        pic.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        bg.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        pic.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pic.touchDown(touch, pointer, button);
        return false;
    }
}