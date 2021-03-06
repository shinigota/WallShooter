
package fr.somedagpistudents.wallshooter.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.tools.Controller;
import fr.somedagpistudents.wallshooter.tools.SpriteManager;
import fr.somedagpistudents.wallshooter.tools.SpriteType;

import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_HEIGHT;
import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_WIDTH;
import static java.lang.System.exit;

/**
 * Created by sbonnan on 01/02/17.
 */
public class PresentationScreen implements Screen {

    private final WallShooter wallShooter;
    private final ShapeRenderer shaperenderer;
    private SpriteBatch spritebatch;
    private Controller controller;
    private int SIZE_BUTTON_WIDTH = 300;
    private int SIZE_BUTTON_HEIGHT = 100;
    private String[] txtButton = new String[]{"PLAY : press ENTER", "TUTO : press T", "QUITTER : press ECHAP"};
    private BitmapFont font = new BitmapFont();
    private TextureAtlas bricksAtlas;
    public static final String TITLE = "title";


    public PresentationScreen(WallShooter wallShooter,Controller controller){

        this.wallShooter = wallShooter;
        this.spritebatch=new SpriteBatch();
        this.shaperenderer=new ShapeRenderer();
        this.controller=controller;
        font=new BitmapFont();

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        this.drawTitle();
        this.drawHUD();
        boolean isPressed = Gdx.input.isKeyPressed(Input.Keys.ENTER);
        if(isPressed){
            this.wallShooter.setScreen(new GameScreen(this.wallShooter, this.controller));
            this.controller.start();
        }
        isPressed = Gdx.input.isKeyPressed(Input.Keys.T);
        if(isPressed){
            this.wallShooter.setScreen(new GameScreen(this.wallShooter, this.controller));
            this.controller.startTuto();
        }
        isPressed = Gdx.input.isKeyPressed(Input.Keys.ESCAPE);
        if(isPressed){
            Gdx.app.exit();
        }
    }

    private void drawHUD() {
        this.drawRect();
        this.drawText();
    }

    public void drawTitle(){
        this.bricksAtlas = new TextureAtlas("sprites.txt");
        Sprite titleSprite = this.bricksAtlas.createSprite(TITLE);
        spritebatch.begin();
        titleSprite.draw(spritebatch);
        spritebatch.end();
    }

    public void drawRect(){
        this.shaperenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = txtButton.length;i>0;i--) {

            shaperenderer.setColor(Color.WHITE);
            shaperenderer.rect(buttonPosX(), buttonPosY(i, txtButton.length), SIZE_BUTTON_WIDTH, SIZE_BUTTON_HEIGHT);
        }
        this.shaperenderer.end();
    }

    public void drawText(){

        this.spritebatch.begin();

        for(int i = txtButton.length;i>0;i--) {
            font.setColor(Color.BLACK);
            GlyphLayout layout = new GlyphLayout(font, txtButton[i-1]);
            // or for non final texts: layout.setText(font, text);

            float fontX = buttonPosX() + (SIZE_BUTTON_WIDTH - layout.width) / 2;
            int position = txtButton.length-i+1;
            float fontY = buttonPosY(position, txtButton.length) + (SIZE_BUTTON_HEIGHT + layout.height) / 2;

            font.draw(spritebatch, layout, fontX, fontY);
        }
        this.spritebatch.end();
    }

    public int buttonPosX(){
        return (SCREEN_WIDTH/2)-SIZE_BUTTON_WIDTH/2;
    }

    public int buttonPosY(int position, int nb){

        int deltaBetween = 10;
        int cadreMenu = (nb*SIZE_BUTTON_HEIGHT) + (nb * deltaBetween);
        int sizeScreenMenu = SCREEN_HEIGHT-cadreMenu;
        int y = SCREEN_HEIGHT-(sizeScreenMenu/2)-(SIZE_BUTTON_HEIGHT*(nb-position+1))-(nb-position)*deltaBetween;
        return y;
    }




    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.bricksAtlas.dispose();
    }
}