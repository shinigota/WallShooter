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
import fr.somedagpistudents.wallshooter.entity.Player;

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

        this.camera.position.set(0,  0 , 0);
        this.camera.update();
    }

    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.camera.position.add(WallShooter.CAM_X_SPEED, 0, 0);
        this.camera.update();

        ArrayList<Brick> bricks = this.world.getBricks();
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

        Player p = world.getPlayer();
        this.shapeRenderer.rect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
        this.shapeRenderer.end();

        this.spriteBatch.begin();

        this.spriteBatch.end();
    }

    public void dispose() {
        spriteBatch.dispose();
    }
}
