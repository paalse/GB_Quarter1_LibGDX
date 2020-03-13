package ru.paalse.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.paalse.base.ScaledButton;
import ru.paalse.math.Rect;
import ru.paalse.screen.GameScreen;

public class ButtonNewGame extends ScaledButton {

    private GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.04f);
        setTop(-0.1f);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}