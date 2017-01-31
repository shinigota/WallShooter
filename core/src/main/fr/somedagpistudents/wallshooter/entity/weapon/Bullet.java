package fr.somedagpistudents.wallshooter.entity.weapon;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;

/**
 * Created by benjamin on 1/31/17.
 */
public class Bullet extends MovableEntity {
    public final static float SIZE = 10;
    public final static float X_SPEED = 10;
    public final static float Y_SPEED = 0;

    public Bullet(float x, float y, float size, float xSpeed, float ySpeed) {
        super(x, y, size, xSpeed, ySpeed);
    }

    public Bullet(float x, float y) {
        this(x, y, Bullet.SIZE, Bullet.X_SPEED, Bullet.Y_SPEED);
    }

    @Override
    public void update() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }

    @Override
    public void onCollision(Object object) {
//        throw new UnsupportedOperationException();
    }
}
