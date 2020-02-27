package ru.paalse.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.paalse.base.ScaledButton;
import ru.paalse.math.Rect;

public class ButtonExit extends ScaledButton {

    private static final float PADDING = 0.05f;

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setRight(worldBounds.getRight() - PADDING);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
