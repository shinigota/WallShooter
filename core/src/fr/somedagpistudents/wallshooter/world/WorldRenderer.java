package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
    private World world;
    private SpriteBatch batch;
    private Texture img;

    public WorldRenderer(World world) {
        this.world = world;
        batch = new SpriteBatch();
    }

    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }
}
