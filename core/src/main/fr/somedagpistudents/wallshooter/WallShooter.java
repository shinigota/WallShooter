package fr.somedagpistudents.wallshooter;

import com.badlogic.gdx.Game;
import fr.somedagpistudents.wallshooter.screen.GameScreen;
import fr.somedagpistudents.wallshooter.screen.PresentationScreen;
import fr.somedagpistudents.wallshooter.tools.Controller;
import fr.somedagpistudents.wallshooter.tools.SoundManager;
import fr.somedagpistudents.wallshooter.tools.SpriteManager;

public class WallShooter extends Game {
	public final static int SCREEN_WIDTH = 1280;
	public final static int SCREEN_HEIGHT = 720;
	public static final boolean DEBUG_DEFAULT = false;

	private SoundManager soundManager;
	private SpriteManager spriteManager;

    public static GameScreen gameScreen ;

	public static boolean debug;

	@Override
	public void create() {
		WallShooter.debug = DEBUG_DEFAULT;

		this.soundManager = new SoundManager();
		this.spriteManager = new SpriteManager();

		Controller controller = new Controller(this);
		GameScreen gameScreen = new GameScreen(this,controller);
		this.setScreen(new PresentationScreen(this,controller));
	}

	public static void toggleDebug() {
		WallShooter.debug = ! WallShooter.debug;
	}

	@Override
	public void dispose() {
		super.dispose();
		this.soundManager.dispose();
		this.spriteManager.dispose();
	}

	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public SoundManager getSoundManager() {
		return soundManager;
	}
}
