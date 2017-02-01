package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.InputProcessor;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import static com.badlogic.gdx.Input.Keys.*;

/**
 * Created by dopasensei on 31/01/17.
 */
public class InputController implements ActionListener, InputProcessor{

    private World mWorld;
    private Player mPlayer;
    private int mLateralSpeed;
    private int mVerticalSpeed;
    private Map<String, Integer> mKeyMap;

    public InputController(World w, int vSpeed, int lSpeed){
        this.mWorld = w;
        this.mPlayer = w.getPlayer();
        this.mLateralSpeed = lSpeed;
        this.mVerticalSpeed = vSpeed;
        this.mKeyMap = new HashMap<String, Integer>();

        this.mKeyMap.put("Z",0);
        this.mKeyMap.put("Q",0);
        this.mKeyMap.put("S",0);
        this.mKeyMap.put("D",0);
    }

    @Override
    public boolean keyDown(int keycode) {

        Controller c = (Controller) this.mWorld.getController();

        if(keycode == R){


            System.out.println("Event de relaunch du jeu");
        }

        if(keycode == Z){
            this.mKeyMap.put("Z",1);
            this.mPlayer.setYSpeed(this.mVerticalSpeed);
        }

        if(keycode == Q){
            this.mKeyMap.put("Q",1);
            this.mPlayer.setXSpeed(this.mLateralSpeed * -1);
        }

        if(keycode == S){
            this.mKeyMap.put("S",1);
            this.mPlayer.setYSpeed(this.mVerticalSpeed * -1);
        }

        if(keycode == D){
            this.mKeyMap.put("D",1);
            this.mPlayer.setXSpeed(this.mLateralSpeed);
        }

        if(keycode == SPACE){
            this.mPlayer.toggleShoot(true);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Z){
            this.mKeyMap.put("Z",0);
            if(this.mKeyMap.get("S") != 1){
                this.mPlayer.setYSpeed(0);
            }
        }

        if(keycode == S){
            this.mKeyMap.put("S",0);
            if(this.mKeyMap.get("Z") != 1){
                this.mPlayer.setYSpeed(0);
            }
        }

        if(keycode == Q){
            this.mKeyMap.put("Q",0);
            if(this.mKeyMap.get("D") != 1){
                this.mPlayer.setXSpeed(0);
            }
        }

        if(keycode == D){
            this.mKeyMap.put("D",0);
            if(this.mKeyMap.get("Q") != 1){
                this.mPlayer.setXSpeed(0);
            }
        }

        if(keycode == SPACE) {
            this.mPlayer.toggleShoot(false);
        }

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
