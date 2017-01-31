package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.InputProcessor;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.badlogic.gdx.Input.Keys.*;

/**
 * Created by dopasensei on 31/01/17.
 */
public class InputController implements ActionListener, InputProcessor{

    private World mWorld;
    private Player mPlayer;
    private int mLateralSpeed;
    private int mVerticalSpeed;

    public InputController(World w, int vSpeed, int lSpeed){
        this.mWorld = w;
        this.mPlayer = w.getPlayer();
        this.mLateralSpeed = lSpeed;
        this.mVerticalSpeed = vSpeed;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Z){
            this.mPlayer.setYSpeed(this.mVerticalSpeed);
        }

        if(keycode == Q){
            this.mPlayer.setXSpeed(this.mLateralSpeed * -1);
        }

        if(keycode == S){
            this.mPlayer.setYSpeed(this.mVerticalSpeed * -1);
        }

        if(keycode == D){
            this.mPlayer.setXSpeed(this.mLateralSpeed);
        }

        if(keycode == SPACE){
            Weapon weapon = this.mPlayer.getWeapon();
            if(weapon.canShoot()) {
                Bullet bullet = weapon.shoot(this.mPlayer.getX() + this.mPlayer.getWidth() / 2, this.mPlayer.getY() + this.mPlayer.getHeight() / 2);
                this.mWorld.addBullet(bullet);
            }
        }

        System.out.println("Key down !");
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        this.mPlayer.setYSpeed(0);
        this.mPlayer.setXSpeed(0);

        System.out.println("Key up !");
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
