package fr.somedagpistudents.wallshooter.entity.weapon;

import com.badlogic.gdx.utils.TimeUtils;
import fr.somedagpistudents.wallshooter.entity.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
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
    private boolean allowedToShoot;

    private float heatPercent;

    private List<Bullet> bullets;

    public Weapon() {
        this(DEFAULT_FIRE_RATE_MILLIS);
    }

    public Weapon(long fireRateInMillis) {
        this.bullets = new ArrayList<Bullet>();
        this.fireRateInMillis = fireRateInMillis;
        this.lastShootTimeInMillis = 0;
        this.damagesPerBullet = DEFAULT_BULLET_DAMAGES;
        this.heatPercent = 0;
        this.allowedToShoot = true;
    }

    public Weapon(long fireRateInMillis, long damagesPerBullet){
        this.fireRateInMillis = fireRateInMillis;
        this.lastShootTimeInMillis = 0;
        this.damagesPerBullet = damagesPerBullet;
        this.heatPercent = 0;
    }

    public void shoot(float xOrigin, float yOrigin) {
        if(this.getHeatPercent() >= 100){
            this.allowedToShoot = false;
        }
            if(this.allowedToShoot){
                this.lastShootTimeInMillis = TimeUtils.millis();
                this.bullets.add(new Bullet(xOrigin, yOrigin, this.damagesPerBullet));
            }

    }

    public void growHeat(){
        this.heatPercent = this.heatPercent + (float)(this.heatPercent * 0.0084) + (float) 0.05;
        if(this.heatPercent >= 100){
            this.heatPercent = 100;
        }
    }

    public void reduceHeat(){
        if(!this.allowedToShoot){
            this.heatPercent = ((float) (this.heatPercent - 0.75));
            if(this.heatPercent <= 5){
                this.allowedToShoot = true;
            }
        }
        else{
            this.heatPercent = ((float) (this.heatPercent - 2));
        }

        if(this.heatPercent < 0){
            this.heatPercent = 0;
        }
    }

    public Bullet getLastBullet(){
        return this.bullets.get(this.bullets.size()-1);
    }

    public long getFireRateInMillis() {
        return fireRateInMillis;
    }

    public long getDamagesPerBullet(){
        return this.damagesPerBullet;
    }

    public float getHeatPercent() {
        return this.heatPercent;
    }

    public void setHeatPercent(float newHeatPercent){
        this.heatPercent = newHeatPercent;
    }

    public boolean canShoot() {
        return TimeUtils.millis() - this.lastShootTimeInMillis >= this.fireRateInMillis;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }
}
