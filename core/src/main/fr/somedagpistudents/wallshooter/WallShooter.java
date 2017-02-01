package fr.somedagpistudents.wallshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import fr.somedagpistudents.wallshooter.screen.GameScreen;
import fr.somedagpistudents.wallshooter.tools.Controller;
import fr.somedagpistudents.wallshooter.world.InputController;
import fr.somedagpistudents.wallshooter.world.World;
import fr.somedagpistudents.wallshooter.world.WorldRenderer;

public class WallShooter extends Game {
	public final static int SCREEN_WIDTH = 1280;
	public final static int SCREEN_HEIGHT = 720;

	@Override
	public void create() {
		GameScreen gameScreen = new GameScreen(this);
		this.setScreen(gameScreen);
	}
}
