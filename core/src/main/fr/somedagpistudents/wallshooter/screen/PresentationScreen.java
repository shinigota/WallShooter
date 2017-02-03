
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
    private int SIZE_TITLE_WIDTH = 600;
    private int SIZE_TITLE_HEIGHT = 200;
    private String[] txtButton = new String[]{"PLAY : PRESS SPACE", "TUTO : PRESS T", "OPTION", "QUITTER"};
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
        boolean isPressed = Gdx.input.isKeyPressed(Input.Keys.SPACE);
        if(isPressed){
            this.wallShooter.setScreen(new GameScreen(this.wallShooter, this.controller));
            this.controller.start();
        }
        isPressed = Gdx.input.isKeyPressed(Input.Keys.T);
        if(isPressed){
            this.wallShooter.setScreen(new GameScreen(this.wallShooter, this.controller));
            this.controller.startTuto();
        }


    }

    private void drawHUD() {
        this.drawRect();
        this.drawText();
/*
        String str = this.
                controller.
                displayGameStateText();
*/
        //font.draw(spritebatch, strMenu1, txtPosX(),txtPosY(3,3));
        /*font.draw(spritebatch, strMenu2, txtPosX(),txtPosY(2,3));
        font.draw(spritebatch, strMenu3, txtPosX(),txtPosY(1,3));
        int nb = 3;*/
        /*
        final int steps = 200;
        Color rgbColor = new Color();
        for(int i = 0; i < steps; i++){
            Color.argb8888ToColor(rgbColor, java.awt.Color.HSBtoRGB(1.0f * i / steps, 1, 1));
            shaperenderer.rect(490, 360, 50, 50, 300, 50, 1, 1, i * 360 / steps, rgbColor, rgbColor, rgbColor, rgbColor);
        }
        */




    }

    public void drawTitle(){
        this.bricksAtlas = new TextureAtlas("sprites.txt");
        Sprite titleSprite = this.bricksAtlas.createSprite(TITLE);
        spritebatch.begin();
        titleSprite.draw(spritebatch);
        spritebatch.end();
        this.bricksAtlas.dispose();
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
    }
}