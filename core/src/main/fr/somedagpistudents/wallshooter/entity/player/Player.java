package fr.somedagpistudents.wallshooter.entity.player;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;

import java.util.Timer;
import java.util.TimerTask;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by djacques on 30/01/17.
 */
public class Player extends MovableEntity {
    private int score = 0;
    private Weapon weapon;
    private Timer time;
    private int PLAYER_Y_SPEED = 100;
    private int PLAYER_X_SPEED = 100;

    public int getScore() {
        return score;
    }

    protected boolean blockedFront = false;


    public Player(float x, float y, float width, float height) {

        super(x, y, width, height);
        this.xSpeed = 2;
        this.ySpeed = 0;
    }

    @Override
    public void update() {
        if(time == null){
            createTimer();
        }
        if(!this.blockedFront) {
            this.x += getXSpeed();
        }else{
            this.blockedFront = false;
        }
        this.y += getYSpeed();
    }

    @Override
    public void contactWith(Object object) {
        if(object instanceof Brick){
            this.blockedFront = true;
        }
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void createTimer(){
        time = new Timer("AddScore");
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                createTimer();
                Player.this.score++;
            }
        },1000);
    }

    public void setYSpeed(float y){
        this.ySpeed = y;
    }

    public void setXSpeed(float x){
        this.xSpeed = x;
    }

    public float getSpeedY(){
        return this.PLAYER_Y_SPEED;
    }

    public float getSpeedX(){
        return this.PLAYER_X_SPEED;
    }
}
