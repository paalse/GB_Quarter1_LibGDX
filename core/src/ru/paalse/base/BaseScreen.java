package ru.paalse.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseScreen implements Screen, InputProcessor {
    protected SpriteBatch batch;

    @Override
    public void show() { // Вызывается при показе экрана (обычно в нем идет вся инициализация)
        batch = new SpriteBatch();
        System.out.println("show");
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) { // Вызывается 60 раз в секунду

    }

    @Override
    public void resize(int width, int height) { // Вызывается при изменении размеров экрана
        System.out.println("resize width=" + width + " height=" + height);
    }

    @Override
    public void pause() { // Вызывается при сворачивании экрана
        System.out.println("pause");
    }

    @Override
    public void resume() { // Вызывается при разворачивании экрана
        System.out.println("resume");
    }

    @Override
    public void hide() { // Вызывается при закрытии окна
        System.out.println("hide");
        dispose();
    }

    @Override
    public void dispose() { // Освобождение памяти
        System.out.println("dispose");
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) { // Вызывается при нажатии клавиши
        System.out.println("keyDown keycode=" + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) { // Вызывается при отпускании клавиши
        System.out.println("keyUp keycode=" + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) { // Вызывается между keyDown и keyUp
        System.out.println("keyTyped = character" + character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) { // Нажатие клавиши мыши или тачскрина
        System.out.println("touchDown screenX=" + screenX + " screenY=" + screenY + " pointer=" + pointer + " button=" + button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) { // Отпускание клавиши мыши или тачскрина
        System.out.println("touchUp screenX=" + screenX + " screenY=" + screenY + " pointer=" + pointer + " button=" + button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) { // Нажали кнопку мыши или тачскрин в одном месте протащили и отпустили в другом
        System.out.println("touchDragged screenX=" + screenX + " screenY=" + screenY + " pointer=" + pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {   // Любое движение мыши
        return false;
    }

    @Override
    public boolean scrolled(int amount) { // Скроллинг либо вверх либо вниз, amount показывает направление
        System.out.println("scrolled amount=" + amount);
        return false;
    }
}
