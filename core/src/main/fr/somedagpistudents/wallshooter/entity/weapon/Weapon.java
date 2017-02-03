package fr.somedagpistudents.wallshooter.entity.weapon;

import com.badlogic.gdx.utils.TimeUtils;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.tools.Assets;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin on 1/31/17.
 */
public class Weapon {
    public final static long DEFAULT_FIRE_RATE_MILLIS = 500;
    public final static long DEFAULT_BULLET_DAMAGES = 1;
    public static final float HEAT_REDUCTION_ON_OVERHEAT = 0.42f;
    public static final float HEAT_REDUCTION_ON_NORMAL_HEAT = 1f;

    private long fireRateInMillis;
    private long lastShootTimeInMillis;
    private long damagesPerBullet;
    private boolean allowedToShoot;

    private float heatPercent;
    private boolean blockHeatVariation;

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
        this.blockHeatVariation = false;
    }

    public Weapon(long fireRateInMillis, long damagesPerBullet){
        this.fireRateInMillis = fireRateInMillis;
        this.lastShootTimeInMillis = 0;
        this.damagesPerBullet = damagesPerBullet;
        this.heatPercent = 0;
    }

    public void shoot(float xOrigin, float yOrigin) {
        if(canShoot()){
            this.lastShootTimeInMillis = TimeUtils.millis();
            this.bullets.add(new Bullet(xOrigin, yOrigin, this.damagesPerBullet));
        }
    }

    public void growHeat(){
        if(!this.blockHeatVariation){
            this.heatPercent = this.heatPercent + (float)(this.heatPercent * 0.0084) + (float) 0.05;
            this.heatPercent = roundHeat(this.heatPercent);
            if(this.heatPercent >= 100){
                this.heatPercent = 100;
            }
        }
        else{
            this.reduceHeat();
        }
    }

    public void reduceHeat(){
        if(!this.allowedToShoot){
            blockHeatVariation();
        }
        else{
            this.heatPercent = (this.heatPercent - HEAT_REDUCTION_ON_NORMAL_HEAT);
        }

        if(this.heatPercent < 0){
            this.heatPercent = 0;
        }
    }

    private void blockHeatVariation() {
        this.blockHeatVariation = true;
        this.heatPercent = ((float) (this.heatPercent - HEAT_REDUCTION_ON_OVERHEAT));
        if(this.heatPercent <= 5){
            this.allowedToShoot = true;
            this.blockHeatVariation = false;
        }
    }

    public float roundHeat(float heat){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        Number n = heat;
        Double d = n.doubleValue();
        return (float) Float.parseFloat(df.format(d).replace(',','.'));
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
        this.heatPercent = roundHeat(newHeatPercent);
    }

    public boolean canShoot() {
        if(this.heatPercent >= 100){
            this.allowedToShoot = false;
        }
        if(this.allowedToShoot){
            return TimeUtils.millis() - this.lastShootTimeInMillis >= this.fireRateInMillis;
        }
        return false;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }
}
