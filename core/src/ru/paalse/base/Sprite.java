package ru.paalse.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.paalse.math.Rect;

public abstract class Sprite extends Rect {
    protected float angle;             // Угол поворота
    protected float scale = 1f;        // Масштаб объекта
    protected TextureRegion[] regions;  // Массив текстур
    protected int frame;               // Текущая текстура из массива текстур

    public Sprite(TextureRegion region) {
        if (region == null) {
            throw new RuntimeException("Не задана текстура");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    /*
    Метод отрисовки спрайта
     */
    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }

    // Метод для установки ширины по высоте
    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth()/(float)regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    // Метод изменения спрайта при изменении размеров экрана
    public void resize(Rect worldBounds){};

    public void touchDown(Vector2 touch, int pointer, int button){};

    public void touchUp(Vector2 touch, int pointer, int button){};

    public void touchDragged(Vector2 touch, int pointer){};

    public void update(float delta){};

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
