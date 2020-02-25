package ru.paalse.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.paalse.base.Sprite;
import ru.paalse.math.Rect;

public class Pic extends Sprite {
    private static final float V_LEN = 0.01f;

    private Vector2 touch;  // Вектор клика мыши
    private Vector2 v;      // Вектор скорости

    public Pic(Texture region) {
        super(new TextureRegion(region));
        touch = new Vector2();
        v = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
    }

    @Override
    public void touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
    }

    @Override
    public void update(float delta) {
        System.out.println("v.len() = " + v.len());
        if (pos.x != touch.x && pos.y != touch.x) {         // Картинка доехала до указанной точки ?
            v.set(touch);
            v.sub(pos);                                     // Вычисляем вектор скорости
            if (v.len() >= V_LEN) {                        // Исключает дрожание картинки при приходе в конечную точку
                pos.add(v.setLength(V_LEN));
            } else {
                pos.set(touch);
            }
        }
    }
}