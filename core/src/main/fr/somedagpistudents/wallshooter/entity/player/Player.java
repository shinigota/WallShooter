package fr.somedagpistudents.wallshooter.entity.player;

import fr.somedagpistudents.wallshooter.entity.Entity;
import fr.somedagpistudents.wallshooter.entity.MovableEntity;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;

import java.util.Timer;
import java.util.TimerTask;
import com.badlogic.gdx.InputProcessor;
import fr.somedagpistudents.wallshooter.tools.ColisionTools;

/**
 * Created by djacques on 30/01/17.
 */
public class Player extends MovableEntity {
    private int score = 0;
    private int lives = 0;
    private Weapon weapon;
    private Timer time;
    private int PLAYER_Y_SPEED = 10;
    private int PLAYER_X_SPEED = 100;


    private boolean colisionXRight = false;
    private float speedcolisionXRight;

    private boolean colisionXLeft = false;
    private float speedcolisionXLeft;

    private boolean colisionYBottom = false;
    private float speedcolisionYBottom;

    private boolean colisionYTop = false;
    private float speedcolisionYTop;

    public Player(float x, float y, float width, float height) {

        super(x, y, width, height, 0, 0);
    }

    @Override
    public void update() {
        if(time == null){
            createTimer();
        }
        if(colisionXRight || colisionXLeft) {
            if(colisionXRight) {
                colisionXRight = false;
                if (xSpeed > 0) {
                    this.x += speedcolisionXRight;
                } else {
                    this.x += getXSpeed() + speedcolisionXRight;
                }
            }
            if(colisionXLeft) {
                colisionXLeft = false;
                if (xSpeed < 0) {
                    this.x += speedcolisionXLeft;
                }else{
                    this.x += getXSpeed();
                }
            }
        }else {
            this.x += getXSpeed();
        }
        if(colisionYBottom || colisionYTop){
            if(colisionYBottom) {
                colisionYBottom = false;
                if (ySpeed < 0) {
                    this.y += speedcolisionYBottom;
                } else {
                    this.y += getYSpeed();
                }
            }
            if(colisionYTop){
                colisionYTop = false;
                if (ySpeed > 0) {
                    this.y += speedcolisionYTop;
                } else {
                    this.y += getYSpeed();
                }
            }
        }else {
            this.y += getYSpeed();
        }
    }

    @Override
    public void onCollision(Object object) {
        if(object instanceof Brick){
            if(ColisionTools.contactRightLeft(this, (Entity) object)){
                this.colisionXRight = true;
                this.speedcolisionXRight = ((Brick)object).getXSpeed();
            }
            if(ColisionTools.contactLeftRight(this, (Entity) object)){
                this.colisionXLeft = true;
                this.speedcolisionXLeft = ((Brick)object).getXSpeed();
            }
            if(ColisionTools.contactBottomTop(this, (Entity) object)){
                colisionYBottom = true;
                speedcolisionYBottom = 0;
            }
            if(ColisionTools.contactTopBottom(this,(Entity) object)){
                colisionYTop = true;
                speedcolisionYTop = 0;
            }
        }
    }

    public int getScore() {
        return score;
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
