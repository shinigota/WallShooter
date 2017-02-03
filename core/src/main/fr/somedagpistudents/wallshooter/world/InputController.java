package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.InputProcessor;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.player.HorizontalMovement;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import static com.badlogic.gdx.Input.Keys.*;
import static java.lang.System.exit;

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

        if(mWorld.getController().getGamestate().equals("gameplay")||mWorld.getController().getGamestate().equals("tuto")) {

            if (keycode == R) {
                System.out.println("Event de relaunch du jeu");
            }

            if(keycode == T){
                System.out.println("Launch game");
            }

            if (keycode == Z) {
                this.mKeyMap.put("Z", 1);
                this.mPlayer.setYSpeed(this.mVerticalSpeed);
            }

            if (keycode == Q) {
                this.mKeyMap.put("Q", 1);
                this.mPlayer.setXSpeed(this.mLateralSpeed * -1f);
                this.mPlayer.setHorizontalMovement(HorizontalMovement.BACKWARD);
            }

            if (keycode == S) {
                this.mKeyMap.put("S", 1);
                this.mPlayer.setYSpeed(this.mVerticalSpeed * -1f);
            }

            if (keycode == D) {
                this.mKeyMap.put("D", 1);
                this.mPlayer.setXSpeed(this.mLateralSpeed);
                this.mPlayer.setHorizontalMovement(HorizontalMovement.FORWARD);
            }

            if(keycode == SPACE) {
                this.mPlayer.setShooting(true);
            }

            if(keycode == F1){
                WallShooter.toggleDebug();
            }
        }else{
            if (mWorld.getController().getGamestate().equals( "gameover" )&& keycode == R)
                mWorld.getController().restart();
            if(mWorld.getController().getGamestate().equals("gamestart") && keycode == R)
                mWorld.getController().start();

        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(mWorld.getController().getGamestate().equals("gameplay")
                || mWorld.getController().getGamestate().equals("tuto")
                )

        {
            if (keycode == Z) {
                this.mKeyMap.put("Z", 0);
                if (this.mKeyMap.get("S") != 1) {
                    this.mPlayer.setYSpeed(0);
                } else {
                    this.mPlayer.setYSpeed(this.mVerticalSpeed * -1);
                }
            }

            if (keycode == S) {
                this.mKeyMap.put("S", 0);
                if (this.mKeyMap.get("Z") != 1) {
                    this.mPlayer.setYSpeed(0);
                } else {
                    this.mPlayer.setYSpeed(this.mVerticalSpeed);
                }
            }

            if (keycode == Q) {
                this.mKeyMap.put("Q", 0);
                if (this.mKeyMap.get("D") != 1) {
                    this.mPlayer.setXSpeed(0);
                    this.mPlayer.setHorizontalMovement(HorizontalMovement.NONE);
                } else {
                    this.mPlayer.setXSpeed(this.mLateralSpeed);
                    this.mPlayer.setHorizontalMovement(HorizontalMovement.FORWARD);
                }
            }

            if (keycode == D) {
                this.mKeyMap.put("D", 0);
                if (this.mKeyMap.get("Q") != 1) {
                    this.mPlayer.setXSpeed(0);
                    this.mPlayer.setHorizontalMovement(HorizontalMovement.NONE);
                } else {
                    this.mPlayer.setXSpeed(this.mLateralSpeed * -1);
                    this.mPlayer.setHorizontalMovement(HorizontalMovement.BACKWARD);
                }
            }

            if (keycode == SPACE) {
                this.mPlayer.setShooting(false);
            }
            if (keycode == ESCAPE) {
                exit(0);
            }

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
