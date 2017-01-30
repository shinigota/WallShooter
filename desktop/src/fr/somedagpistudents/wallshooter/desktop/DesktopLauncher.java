package fr.somedagpistudents.wallshooter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.somedagpistudents.wallshooter.WallShooter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width  = WallShooter.SCREEN_WIDTH;
		config.height = WallShooter.SCREEN_HEIGHT;
		new LwjglApplication(new WallShooter(), config);
	}
}
