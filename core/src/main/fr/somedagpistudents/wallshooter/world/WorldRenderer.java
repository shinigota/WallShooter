package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WorldRenderer{

    private Controller controller;
    private World world;

    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;
    private ShapeRenderer debugShapeRenderer;
    private ShapeRenderer shapeRenderer;

    public BitmapFont font;

    private TextureAtlas bricksAtlas;

    private HashMap<String, Sprite> sprites;

    public WorldRenderer(World world) {
        this.world = world;

        this.camera = new OrthographicCamera(WallShooter.SCREEN_WIDTH, WallShooter.SCREEN_HEIGHT);
        this.spriteBatch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        this.debugShapeRenderer = new ShapeRenderer();

        this.camera.position.set(0,  0 , 0);
        this.controller= (Controller) world.getController();

        this.font = new BitmapFont();

        this.bricksAtlas = new TextureAtlas("sprites.txt");
        this.sprites = new HashMap<String, Sprite>();
        this.sprites.put("player", this.bricksAtlas.createSprite("player"));
        this.sprites.put("bullet", this.bricksAtlas.createSprite("bullet"));
        this.sprites.put("neon_red", this.bricksAtlas.createSprite("neon_red"));
        this.sprites.put("neon_orange", this.bricksAtlas.createSprite("neon_orange"));
        this.sprites.put("neon_green", this.bricksAtlas.createSprite("neon_green"));

        this.camera.update();
    }

    public void render() {
        this.clearScreen();
        this.drawGame();
        if (WallShooter.debug) {
            this.drawDebug();
        }
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void drawGame() {
        this.spriteBatch.setProjectionMatrix(this.camera.combined);
        this.spriteBatch.begin();
        this.drawBullets();
        this.drawPlayer();
        this.drawBricks();
        this.drawHUD();
        this.spriteBatch.end();

        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        this.shapeRenderer.setProjectionMatrix(this.camera.combined);
        this.drawHeatBar();
        this.shapeRenderer.end();
    }

    private void drawDebug() {
        this.spriteBatch.setProjectionMatrix(this.camera.combined);
        this.spriteBatch.begin();
        this.debugPlayerPosition();
        this.spriteBatch.end();

        this.debugShapeRenderer.setProjectionMatrix(this.camera.combined);
        this.debugShapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        this.debugBricks();
        this.debugBullets();
        this.debugPlayer();
        this.debugShapeRenderer.end();
    }

    private void drawBullets() {
        Sprite bulletSprite = this.sprites.get("bullet");
        for(Bullet bullet : this.world.getBullets()) {
            bulletSprite.setBounds(bullet.getX() - bullet.getWidth(), bullet.getY(), bullet.getWidth() * 2, bullet.getHeight());
            bulletSprite.draw(spriteBatch);
        }
    }

    private void drawPlayer() {
        Player player = world.getPlayer();
        Sprite playerSprite = this.sprites.get("player");
        playerSprite.setBounds(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        playerSprite.draw(spriteBatch);

    }

    private void drawBricks() {
        for (Brick brick : this.world.getBricks()) {
            float brickLife = brick.getBrickLife();
            Sprite brickSprite;
            if (brickLife <= 3){
                brickSprite = this.sprites.get("neon_red");
            }
            else if (brickLife > 3 && brickLife <= 6){
                brickSprite = this.sprites.get("neon_orange");
            }
            else {
                brickSprite = this.sprites.get("neon_green");
            }
            brickSprite.setBounds(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
            brickSprite.draw(this.spriteBatch);
        }
    }

    private void drawHUD() {
        String str = this.controller.displayGameStateText();
        if (controller.getGamestate()=="gameplay") {
            font.draw(spriteBatch, "Score : "+this.controller.getPlayerScore(), this.camera.position.x - this.camera.viewportWidth / 2 + 10,  20 - this.camera.viewportHeight / 2);
            font.draw(spriteBatch, "Lives: "+this.controller.getPlayerLives(), this.camera.position.x - this.camera.viewportWidth / 2 + 10 + 128, 20 - this.camera.viewportHeight / 2);
            font.draw(spriteBatch, "Heat: ", this.camera.position.x - this.camera.viewportWidth / 2 + 10 + 256, 20 - this.camera.viewportHeight / 2);
        }
        else {
            font.draw(spriteBatch, str, this.camera.position.x, this.camera.position.y);
        }

    }

    private void drawHeatBar(){
        this.shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        if(this.controller.getPlayer().getWeapon().getHeatPercent() <= 50){
            this.shapeRenderer.setColor(0, 1, 0, 1);
        }
        else if(this.controller.getPlayer().getWeapon().getHeatPercent() <= 80){
            this.shapeRenderer.setColor(1, 0.35f, 0, 1);
        }
        else{
            this.shapeRenderer.setColor(1, 0, 0, 1);
        }

        this.shapeRenderer.rect(this.camera.position.x - this.camera.viewportWidth / 2 + 10 + 305, 5 - this.camera.viewportHeight / 2, this.controller.getPlayer().getWeapon().getHeatPercent()*2, 20);
    }

    private void debugPlayerPosition()    {

        //displays player's position

        Player p = world.getPlayer();
        //round position x and y
        int x= (int) p.getX();
        int y= (int) p.getY();
        //casts positions
        String str_x= String.valueOf(x);
        String str_y= String.valueOf(y);

        //displays position
        this.font.draw(this.spriteBatch,"x  :  "+str_x,x,y-16);
        this.font.draw(this.spriteBatch,"y  :  "+str_y,x,y);
    }

    private void  debugBullets() {
        List<Bullet> bullets = world.getBullets();
        Iterator<Bullet> bulletIter = bullets.iterator();

        this.debugShapeRenderer.setColor(Color.YELLOW);
        while (bulletIter.hasNext()) {
            Bullet bullet = bulletIter.next();
            this.debugShapeRenderer.rect(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
        }
    }

    private void debugPlayer() {
        Player p = world.getPlayer();
        this.debugShapeRenderer.setColor(Color.BLUE);
        this.debugShapeRenderer.rect(p.getX(), p.getY(), p.getWidth(), p.getHeight());

    }

    private void debugBricks() {
        ArrayList<Brick> bricks = this.world.getBricks();
        Iterator<Brick> brickIter = bricks.iterator();


        while (brickIter.hasNext()) {
            Brick brick = brickIter.next();
            int brickLife = Math.round(brick.getBrickLife());
            if(brickLife <= 3){
                this.debugShapeRenderer.setColor(Color.RED);
            }
            else if(brickLife > 3 && brickLife <= 6){
                    this.debugShapeRenderer.setColor(Color.ORANGE);
                }
                else{
                    this.debugShapeRenderer.setColor(Color.GREEN);
                }

            this.debugShapeRenderer.rect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        }
    }

    public void dispose() {
        spriteBatch.dispose();
        debugShapeRenderer.dispose();
        bricksAtlas.dispose();
        font.dispose();
    }

    public void updateCameraViewport(float width, float height) {
        this.camera.setToOrtho(false, width, height);
        this.camera.update();
    }
}
