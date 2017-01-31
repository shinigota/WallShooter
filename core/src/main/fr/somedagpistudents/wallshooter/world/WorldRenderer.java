package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.util.ArrayList;
import java.util.Iterator;

public class WorldRenderer implements InputProcessor{
    private Controller controller;
    private World world;

    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;

    private BitmapFont font;

    public WorldRenderer(World world) {
        this.world = world;

        this.camera = new OrthographicCamera(WallShooter.SCREEN_WIDTH, WallShooter.SCREEN_HEIGHT);
        this.spriteBatch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();

        this.camera.position.set(0,  0 , 0);
        this.controller= (Controller) world.getController();

        this.font = new BitmapFont();
        this.camera.update();
    }

    public void render() {
        this.clearScreen();

        this.refreshCamera();

        this.drawDebug();
        this.drawTextures();
    }

    private void refreshCamera() {
        this.camera.position.add(WallShooter.CAM_X_SPEED, 0, 0);
        this.camera.update();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void drawTextures() {
        this.spriteBatch.begin();

        // String str=this.controller.displayGameStateText();
        // font.draw(spriteBatch, str, this.camera.position.x+10, 10);

        this.spriteBatch.end();
    }


    private void drawDebug() {
        this.shapeRenderer.setProjectionMatrix(this.camera.combined);
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);


        this.debugBricks();
        this.debugPlayer();

        this.shapeRenderer.end();
    }

    private void debugPlayer() {
        Player p = world.getPlayer();
        this.shapeRenderer.setColor(Color.BLUE);
        this.shapeRenderer.rect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
    }

    private void debugBricks() {
        ArrayList<Brick> bricks = this.world.getBricks();
        Iterator<Brick> brickIter = bricks.iterator();

        this.shapeRenderer.setColor(Color.RED);
        while (brickIter.hasNext()) {
            Brick brick = brickIter.next();
            this.shapeRenderer.rect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        }
    }

    public void dispose() {
        spriteBatch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
