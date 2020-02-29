package ru.paalse.pool;

import ru.paalse.base.SpritesPool;
import ru.paalse.sprite.Bullet;

/**
 * Пул для пуль
 */
public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
