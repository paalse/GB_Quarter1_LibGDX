package ru.paalse.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.paalse.base.Sprite;
import ru.paalse.math.Rect;

public class MessageGameOver extends Sprite {

    public MessageGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.09f);
        setBottom(0.05f);
    }
}
