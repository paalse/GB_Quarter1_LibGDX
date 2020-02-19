package ru.paalse.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.paalse.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private Vector2 touch;  // Вектор нажатия клавиши
    private Vector2 v;      // Вектор скорости
    private Vector2 pos;    // Вектор позиции

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg"); // Загрузка текстуры из папки assets
        touch = new Vector2();
        v = new Vector2();
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1); // Установка фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);                // Очистка экрана

        if (pos.x != touch.x && pos.y != touch.x) {         // Картинка доехала до указанной точки ?
            v.set(touch);
            v.sub(pos);                                     // Вычисляем вектор скорости
            if (v.len() >= 1) {                             // Исключает дрожание картинки при приходе в конечную точку
                pos.add(v.nor());
            } else {
                pos.set(touch);
            }
        }

        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("------------------------------------------");
        System.out.println("touch.x=" + touch.x + " touch.y=" + touch.y);
        return false;
    }
}