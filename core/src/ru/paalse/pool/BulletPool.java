package ru.paalse.pool;

import ru.paalse.base.SpritesPool;
import ru.paalse.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
