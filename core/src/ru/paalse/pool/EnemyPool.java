package ru.paalse.pool;

import com.badlogic.gdx.audio.Sound;

import ru.paalse.base.SpritesPool;
import ru.paalse.math.Rect;
import ru.paalse.sprite.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Sound shootSound;
    private Rect worldBounds;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Sound shootSound, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.shootSound = shootSound;
        this.worldBounds = worldBounds;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, shootSound, worldBounds);
    }
}