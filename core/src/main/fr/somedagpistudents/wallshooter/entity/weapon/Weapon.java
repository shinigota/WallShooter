package fr.somedagpistudents.wallshooter.entity.weapon;

import com.badlogic.gdx.utils.TimeUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by benjamin on 1/31/17.
 */
public class Weapon {
    public final static float DEFAULT_FIRE_RATE_MILLIS = 500;

    private float fireRateInMillis;
    private float lastShootTimeInMillis;

    public Weapon() {
        this(Weapon.DEFAULT_FIRE_RATE_MILLIS);
    }

    public Weapon(float fireRateInMillis) {
        this.fireRateInMillis = fireRateInMillis;
        this.lastShootTimeInMillis = 0;
    }

    public Bullet shoot() {
        this.lastShootTimeInMillis = TimeUtils.millis();
        return new Bullet();
    }
    public float getFireRateInMillis() {
        return fireRateInMillis;
    }

    public boolean canShoot() {
        return TimeUtils.millis() - this.lastShootTimeInMillis >= this.fireRateInMillis;
    }
}
