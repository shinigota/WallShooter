package fr.somedagpistudents.wallshooter.entity.weapon;

import com.badlogic.gdx.utils.TimeUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by benjamin on 1/31/17.
 */
public class Weapon {
    public final static long DEFAULT_FIRE_RATE_MILLIS = 500;
    public final static long DEFAULT_BULLET_DAMAGES = 1;

    private long fireRateInMillis;
    private long lastShootTimeInMillis;
    private long damagesPerBullet;

    public Weapon() {

        this.fireRateInMillis = DEFAULT_FIRE_RATE_MILLIS;
        this.lastShootTimeInMillis = 0;
        this.damagesPerBullet = DEFAULT_BULLET_DAMAGES;
    }

    public Weapon(long fireRateInMillis) {
        this.fireRateInMillis = fireRateInMillis;
        this.lastShootTimeInMillis = 0;
        this.damagesPerBullet = DEFAULT_BULLET_DAMAGES;

    }

    public Weapon(long fireRateInMillis, long damagesPerBullet){
        this.fireRateInMillis = fireRateInMillis;
        this.lastShootTimeInMillis = 0;
        this.damagesPerBullet = damagesPerBullet;
    }

    public Bullet shoot(float xOrigin, float yOrigin) {
        this.lastShootTimeInMillis = TimeUtils.millis();
        return new Bullet(xOrigin, yOrigin, this.damagesPerBullet);
    }
    public long getFireRateInMillis() {
        return fireRateInMillis;
    }

    public long getDamagesPerBullet(){
        return this.damagesPerBullet;
    }

    public boolean canShoot() {
        return TimeUtils.millis() - this.lastShootTimeInMillis >= this.fireRateInMillis;
    }
}
