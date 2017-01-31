package fr.somedagpistudents.wallshooter.entity.wall;

import fr.somedagpistudents.wallshooter.entity.Entity;
import fr.somedagpistudents.wallshooter.entity.MovableEntity;

public class Brick extends MovableEntity {
    public static final float WIDTH  = 60;
    public static final float HEIGHT = 35;
    public static final float XSPEED  = -2;
    public static final float YSPEED = 0;

    public Brick(float x, float y) {
        super(x, y, Brick.WIDTH, Brick.HEIGHT,Brick.XSPEED,Brick.YSPEED);
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
