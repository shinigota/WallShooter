
package fr.somedagpistudents.wallshooter.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.tools.Controller;

import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_HEIGHT;
import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_WIDTH;

/**
 * Created by sbonnan on 01/02/17.
 */
public class PresentationScreen implements Screen {

    private final WallShooter wallShooter;
    private BitmapFont font;
    private SpriteBatch spritebatch;
    private Controller controller;

    public PresentationScreen(WallShooter wallShooter,Controller controller){
        this.wallShooter = wallShooter;
        this.spritebatch=new SpriteBatch();
        this.controller=controller;
        font=new BitmapFont();

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        this.spritebatch.begin();
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


        this.spritebatch.end();


    }

    private void drawHUD() {
        String str = this.
                controller.
                displayGameStateText();

        font.draw(spritebatch, str, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);

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