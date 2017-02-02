package fr.somedagpistudents.wallshooter.entity.player;

import fr.somedagpistudents.wallshooter.entity.Entity;
import fr.somedagpistudents.wallshooter.entity.MovableEntity;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;

import java.util.Timer;
import java.util.TimerTask;
import fr.somedagpistudents.wallshooter.tools.ColisionTools;

/**
 * Created by djacques on 30/01/17.
 */
public class Player extends MovableEntity{
    private int score = 0;
    private int lives = 0;
    private Weapon weapon;
    private Timer time;
    private boolean isShooting;
    private boolean isDead=false;


    private boolean colisionXRight = false;
    private float speedcolisionXRight;
    private float colisionXRightPos;

    private boolean colisionXLeft = false;
    private float speedcolisionXLeft;
    private float colisionXLeftPos;

    private boolean colisionYBottom = false;
    private float speedcolisionYBottom;
    private float colisionYBottomPos;

    private boolean colisionYTop = false;
    private float speedcolisionYTop;
    private float colisionYTopPos;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height, 0, 0);
        this.isShooting = false;
    }

    @Override
    public void update(float delta) {
        if(this.isShooting)
            weapon.growHeat();
        else
            weapon.reduceHeat();

        if(this.canShoot()) {
            weapon.shoot(this.x+ this.width / 2, this.y + this.height / 2);
        }

        if(time == null){
            createTimer();
        }
        if(colisionXRight || colisionXLeft) {
            if(colisionXRight) {
                colisionXRight = false;
                if (xSpeed*delta  > 0) {
                    this.x = colisionXRightPos;
                    //this.x += (speedcolisionXRight*delta);
                } else {
                    this.x += ((getXSpeed() + speedcolisionXRight)*delta);
                }
            }
            if(colisionXLeft) {
                colisionXLeft = false;
                if (xSpeed*delta < 0) {
                    this.x += (speedcolisionXLeft*delta);
                }else{
                    this.x += (getXSpeed()*delta);
                }
            }
        }else {
            this.x += (getXSpeed()*delta);
        }
        if(colisionYBottom || colisionYTop){
            if(colisionYBottom) {
                colisionYBottom = false;
                if (ySpeed*delta  < 0) {
                    this.y = colisionYBottomPos;
                    //this.y += (speedcolisionYBottom*delta);
                } else {
                    this.y += (getYSpeed()*delta);
                }
            }
            if(colisionYTop){
                colisionYTop = false;
                if (ySpeed*delta  > 0) {
                    this.y = colisionYTopPos;
                    //this.y += (speedcolisionYTop*delta);
                } else {
                    this.y += (getYSpeed()*delta);
                }
            }
        }else {
            this.y += (getYSpeed()*delta);
        }
    }

    private boolean canShoot() {

        return this.weapon.canShoot() && this.isShooting;
    }

    @Override
    public void onCollision(Object object) {
        if(object instanceof Brick){
            if(ColisionTools.contactRightLeft(this, (Entity) object)){
                this.colisionXRight = true;
                this.speedcolisionXRight = ((Brick)object).getXSpeed();
                this.colisionXRightPos = ((Brick) object).getX() - this.width - 1;
            }
            if(ColisionTools.contactLeftRight(this, (Entity) object)){
                this.colisionXLeft = true;
                this.speedcolisionXLeft = ((Brick)object).getXSpeed();
                this.colisionXLeftPos = ((Brick) object).getX() + ((Brick) object).getWidth() +1;
            }
            if(ColisionTools.contactBottomTop(this, (Entity) object)){
                colisionYBottom = true;
                speedcolisionYBottom = 0;
                this.colisionYBottomPos = ((Brick) object).getY() + ((Brick) object).getHeight() + 1;
            }
            if(ColisionTools.contactTopBottom(this,(Entity) object)){
                colisionYTop = true;
                speedcolisionYTop = 0;
                this.colisionYTopPos = ((Brick) object).getY() - this.height - 1;
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
                if(!Player.this.isDead) {
                    createTimer();
                    Player.this.score++;
                }
            }
        },1000);
    }

    public void setYSpeed(float y){
        this.ySpeed = y;
    }

    public void setXSpeed(float x){
        this.xSpeed = x;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setShooting(boolean isShooting) {
        this.isShooting = isShooting;
    }

    public void stop() {
        this.xSpeed = 0;
        this.ySpeed = 0;
        this.isShooting = false;
        this.isDead = true;
    }
}
