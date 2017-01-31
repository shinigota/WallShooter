package fr.somedagpistudents.wallshooter.entity.weapon;

import com.badlogic.gdx.utils.TimeUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by benjamin on 1/31/17.
 */
public class Weapon {
    public final static long DEFAULT_FIRE_RATE_MILLIS = 500;

    private long fireRateInMillis;
    private long lastShootTimeInMillis;

    public Weapon() {
        this(Weapon.DEFAULT_FIRE_RATE_MILLIS);
    }

    public Weapon(long fireRateInMillis) {
        this.fireRateInMillis = fireRateInMillis;
        this.lastShootTimeInMillis = 0;
    }

    public Bullet shoot(float xOrigin, float yOrigin) {
        this.lastShootTimeInMillis = TimeUtils.millis();
        return new Bullet(xOrigin, yOrigin);
    }
    public long getFireRateInMillis() {
        return fireRateInMillis;
    }

    public boolean canShoot() {
        return TimeUtils.millis() - this.lastShootTimeInMillis >= this.fireRateInMillis;
    }
}
