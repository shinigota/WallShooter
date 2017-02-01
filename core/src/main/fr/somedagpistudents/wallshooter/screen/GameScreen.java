package fr.somedagpistudents.wallshooter.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.tools.Controller;
import fr.somedagpistudents.wallshooter.world.InputController;
import fr.somedagpistudents.wallshooter.world.World;
import fr.somedagpistudents.wallshooter.world.WorldRenderer;

/**
 * Created by benjamin on 2/1/17.
 */
public class GameScreen implements Screen {

    public final static int CAM_X_SPEED = 2;

    private WallShooter wallShooter;

    private Controller controller;
    private InputController inputController;
    private World world;
    private WorldRenderer worldRenderer;

    public GameScreen(WallShooter wallShooter,Controller controller) {
        this.wallShooter = wallShooter;
        this.controller = controller;
        this.world = new World(controller);

        this.worldRenderer = new WorldRenderer(this.world);

        this.inputController = new InputController(this.world,3,3);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.inputController);
    }

    @Override
    public void render(float delta) {
        this.world.update();
        this.worldRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
//        this.worldRenderer.updateCameraViewport(width, height);
    }

    @Override
    public void pause() {
        // Used for Android
    }

    @Override
    public void resume() {
        // Used for Android
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.worldRenderer.dispose();
    }

    public WorldRenderer getWorldRenderer() {
        return worldRenderer;
    }
    public World getWorld() {
        return this.world;
    }
}
