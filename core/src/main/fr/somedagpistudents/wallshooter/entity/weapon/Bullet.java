package fr.somedagpistudents.wallshooter.entity.weapon;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;

import static com.badlogic.gdx.math.MathUtils.random;

/**
 * Created by benjamin on 1/31/17.
 */
public class Bullet extends MovableEntity {
    public final static float SIZE = 10;
    public final static float X_SPEED = 30;
    public final static float Y_SPEED = 0;

    public final static float MAX_Y_RAND = 2.5f;
    public final static float Y_RAND_SCALE = 100f;


    private float bulletDamages;

    public Bullet(float x, float y, float size, float xSpeed, float ySpeed, float bulletDamages) {
        super(x, y, size, xSpeed, ySpeed);
        this.setRandomYSpeed();
        this.bulletDamages = bulletDamages;
    }

    public Bullet(float x, float y, float bulletDamages) {
        this(x, y, Bullet.SIZE, Bullet.X_SPEED, Bullet.Y_SPEED,bulletDamages);
    }

    public float getDamages(){
        return this.bulletDamages;
    }

    @Override
    public void update() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }

    @Override
    public void onCollision(Object object) {
        
    }

    private void setRandomYSpeed() {
        this.ySpeed += (float) ( random(0, MAX_Y_RAND * Y_RAND_SCALE) ) / Y_RAND_SCALE -  (MAX_Y_RAND)/ 2f;
    }
}
