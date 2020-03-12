package ru.paalse.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.paalse.math.Rect;
import ru.paalse.pool.BulletPool;
import ru.paalse.pool.ExplosionPool;
import ru.paalse.sprite.Bullet;
import ru.paalse.sprite.Explosion;

public class Ship extends Sprite {

    protected Vector2 v;
    protected Vector2 v0;

    protected Rect worldBounds;

    protected BulletPool bulletPool;
    protected ExplosionPool explosionPool;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletV;
    protected Vector2 bulletPos;
    protected float bulletHeight;
    protected int damage;

    protected float reloadInterval;
    protected float reloadTimer;

    protected Sound shootSound;

    protected int hp;

    public Ship() {
    }

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (getTop() < worldBounds.getTop()) {      // Стреляем только когда корабль залетел на экран
            reloadTimer += delta;
            if (reloadTimer >= reloadInterval) {
                reloadTimer = 0f;
                shoot();
            }
        }
    }

    public void dispose() {
        shootSound.dispose();
    }

    @Override
    public void destroy() {
        super.destroy();
        boom();
    }

    protected void shoot() {
        shootSound.play();
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, bulletPos, bulletV, bulletHeight, worldBounds, damage);
    }

    protected void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(getHeight(), pos);
    }
}
