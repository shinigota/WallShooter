package fr.somedagpistudents.wallshooter.entity.wall;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;

public class Brick extends MovableEntity {
    public static final float WIDTH  = 60;
    public static final float HEIGHT = 35;
    public static final float XSPEED  = -8;
    public static final float YSPEED = 0;

    private float mHealthPoints;

    public Brick(float x, float y, BrickType bt) {
        super(x, y, Brick.WIDTH, Brick.HEIGHT,Brick.XSPEED,Brick.YSPEED);
        this.mHealthPoints = bt.getBrickTypeLife();
    }

    public float getBrickLife(){
        return mHealthPoints;
    }

    public void setBrickLife(float newBrickLife){
        this.mHealthPoints = newBrickLife;
    }

    @Override
    public void update() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }

    @Override
    public void onCollision(Object object) {

    }
}
