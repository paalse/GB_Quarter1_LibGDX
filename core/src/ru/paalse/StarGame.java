package ru.paalse;

import com.badlogic.gdx.Game;
import ru.paalse.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
