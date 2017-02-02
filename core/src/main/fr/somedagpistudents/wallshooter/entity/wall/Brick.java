package fr.somedagpistudents.wallshooter.entity.wall;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;

public class Brick extends MovableEntity {
    public static final float WIDTH  = 60;
    public static final float HEIGHT = 35;
    public static float XSPEED  = -300;
    public static final float YSPEED = 0;

    private float mHealthPoints;
    private float mMoneyOnBreak;


    public Brick(float x, float y, BrickType bt) {
        super(x, y, Brick.WIDTH, Brick.HEIGHT,Brick.XSPEED,Brick.YSPEED);
        this.mHealthPoints = bt.getLife();
        this.mMoneyOnBreak = bt.getMoney();
    }

    public float getLife(){
        return mHealthPoints;
    }

    public void setLife(float newBrickLife){
        this.mHealthPoints = newBrickLife;
    }

    public float getMoney(){
        return this.mMoneyOnBreak;
    }


    @Override

    public void update(float delta) {
        this.x += (this.xSpeed * delta);
        this.y += (this.ySpeed* delta);

    }

    @Override
    public void onCollision(Object object) {

    }
}
