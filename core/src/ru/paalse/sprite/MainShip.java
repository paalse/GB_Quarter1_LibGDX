package ru.paalse.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.paalse.base.Sprite;
import ru.paalse.math.Rect;
import ru.paalse.math.Rnd;

public class MainShip extends Sprite {

    private static final float MAIN_SHIP_HEIGHT = 0.1f; // Масштаб корабля
    private static final float V_LEN = 0.01f;   // Смещение вектора скорости корабля
    private static final float Y_OFFSET = -0.43f;   // Смещение положения корабля по оси Y

    private final Vector2 v;        // Вектор скорости корабля
    private Rect worldBounds;

    private Vector2 touch;          // Вектор нажатия кнопки мыши

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship").split(atlas.findRegion("main_ship").getRegionWidth() / 2, atlas.findRegion("main_ship").getRegionHeight())[0][0]); // Выделение половины региона
        v = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(MAIN_SHIP_HEIGHT);      // Изменение масштаба корабля
        pos.set(0, Y_OFFSET);                       // Установка начальной позиции корабля
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        v.x = touch.x;
        v.y = Y_OFFSET;
        v.sub(pos);                                    // Вычисляем вектор скорости
        if (v.len() >= V_LEN)  {                        // Исключает дрожание картинки при приходе в конечную точку
            pos.add(v.setLength(V_LEN));
         } else {
            v.x = touch.x;
            v.y = Y_OFFSET;
        }
    }

    @Override
    public void touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
    }
}
