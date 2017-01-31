package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.util.ArrayList;
import java.util.Iterator;

public class WorldRenderer{
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
        this.drawDebug();
        this.drawTextures();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void drawTextures() {
        this.spriteBatch.begin();

        this.drawHUD();

        this.spriteBatch.end();
    }

    private void drawHUD() {
        String str = this.controller.displayGameStateText();
        if (controller.getGamestate()=="gameplay"){
        font.draw(spriteBatch, "Score : "+this.controller.getPlayerScore(), this.camera.position.x+10, 10);
        font.draw(spriteBatch, "Lives: "+this.controller.getPlayerLives(), this.camera.position.x+10+128, 10);}
        else
            font.draw(spriteBatch, str, this.camera.position.x+10, 10);

    }


    private void drawDebug() {
        this.shapeRenderer.setProjectionMatrix(this.camera.combined);
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);


        this.debugBricks();
        this.debugBullets();
        this.debugPlayer();

        this.shapeRenderer.end();
    }

    private void debugBullets() {
        ArrayList<Bullet> bullets = world.getBullets();
        Iterator<Bullet> bulletIter = bullets.iterator();

        this.shapeRenderer.setColor(Color.YELLOW);
        while (bulletIter.hasNext()) {
            Bullet bullet = bulletIter.next();
            this.shapeRenderer.rect(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
        }
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

}
