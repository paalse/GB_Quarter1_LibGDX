package ru.paalse.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс для пулов спрайтов
 *
 * @param <T>
 */
public abstract class SpritesPool<T extends Sprite> {

    private final List<T> activeObjects = new ArrayList<>();

    private final List<T> freeObjects = new ArrayList<>();

    protected abstract T newObject();

    public T obtain() {
        T object;
        if (freeObjects.isEmpty()) {
            object = newObject();
        } else {
            object = freeObjects.remove(freeObjects.size() - 1);
        }
        activeObjects.add(object);
        System.out.println(getClass().getName() + " active/free: " + activeObjects.size() + "/" + freeObjects.size());
        return object;
    }

    /**
     * Обновление всех активных спрайтов
     *
     * @param delta
     */
    public void updateActiveSprites(float delta) {
        for (Sprite sprite : activeObjects) {
            if (!sprite.isDestroyed()) {
                sprite.update(delta);
            }
        }
    }

    /**
     * Отрисовка всех активных спрайтов
     *
     * @param batch
     */
    public void drawActiveSprites(SpriteBatch batch) {
        for (Sprite sprite : activeObjects) {
            if (!sprite.isDestroyed()) {
                sprite.draw(batch);
            }
        }
    }

    /**
     * Освобождение всех разрушенных объектов
     */
    public void freeAllDestroyedActiveObjects() {
        for (int i = 0; i < activeObjects.size(); i++) {
            T sprite = activeObjects.get(i);
            if (sprite.isDestroyed()) {
                free(sprite);
                i--;
                sprite.flushDestroy();
            }
        }
    }

    public void dispose() {
        activeObjects.clear();
        freeObjects.clear();
    }

    public List<T> getActiveObjects() {
        return activeObjects;
    }

    /**
     * Освобождение объектов
     *
     * @param object
     */
    private void free(T object) {
        if (activeObjects.remove(object)) {
            freeObjects.add(object);
        }
        System.out.println(getClass().getName() + " active/free: " + activeObjects.size() + "/" + freeObjects.size());
    }
}
