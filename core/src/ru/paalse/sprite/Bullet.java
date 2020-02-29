package ru.paalse.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.paalse.base.Sprite;
import ru.paalse.math.Rect;

/**
 * Класс описывает объект "Пуля"
 */
public class Bullet extends Sprite {

    private Rect worldBounds;   // Границы игрового мира
    private final Vector2 v;    // Вектор скорости
    private int damage;         // Урон который пуля сможет наносить
    private Sprite owner;       // Владелец пули

    public Bullet() {
        regions = new TextureRegion[1];
        v = new Vector2();
    }

    /**
     * Метод установки параметров
     *
     * @param owner - владелец пули
     * @param region - регион для пули
     * @param pos0 - вектор начальной позиции
     * @param v0 - начальная скорость
     * @param height - размер пули
     * @param worldBounds - границы мира
     * @param damage - урон который пуля может наносить
     */
     public void set(
            Sprite owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds,
            int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    @Override
    public void update(float delta) {
        this.pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    public int getDamage() {
        return damage;
    }

    public Sprite getOwner() {
        return owner;
    }
}
