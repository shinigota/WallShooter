package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Entity;

import java.util.ArrayList;
import java.util.Iterator;

public class WorldRenderer {
    private World world;

    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;

    public WorldRenderer(World world) {
        this.world = world;
        this.camera = new OrthographicCamera(WallShooter.SCREEN_WIDTH, WallShooter.SCREEN_HEIGHT);
        this.spriteBatch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();

        this.camera.position.set(WallShooter.SCREEN_WIDTH / 2, WallShooter.SCREEN_HEIGHT / 2, 0);
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ArrayList<Brick> bricks = this.world.getBricks();
//        this.camera.position.set(WallShooter.SCREEN_WIDTH / 2, WallShooter.SCREEN_HEIGHT / 2, 0);
        this.spriteBatch.setProjectionMatrix(this.camera.combined);
        this.shapeRenderer.setProjectionMatrix(this.camera.combined);

        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        this.shapeRenderer.setColor(Color.RED);

        Iterator<Brick> brickIter = bricks.iterator();
        while (brickIter.hasNext()) {
            Brick brick = brickIter.next();

            this.shapeRenderer.rect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        }

        this.shapeRenderer.setColor(Color.BLUE);
//        this.shapeRenderer.rect(0, 0, Brick.WIDTH, Brick.HEIGHT * 2);
        this.shapeRenderer.end();

        this.spriteBatch.begin();

        this.spriteBatch.end();
    }

    public void dispose() {
        spriteBatch.dispose();
    }
}
