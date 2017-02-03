package fr.somedagpistudents.wallshooter.entity.wall;

/**
 * Created by dopasensei on 01/02/17.
 */
public class BrickType {
    private float mLife;
    private float mMoney;
    private boolean destructible;

    public BrickType(float brickLife, float brickMoney, boolean brickDestructible){
        this.mLife = brickLife;
        this.mMoney = brickMoney;
        this.destructible = brickDestructible;
    }

    public float getLife(){
        return this.mLife;
    }

    public void setLife(float brickTypeLife){
        this.mLife = brickTypeLife;
    }

    public void setMoney(float money){
        this.mMoney = money;
    }

    public float getMoney(){
        return this.mMoney;
    }

    public boolean isDestructible() {
        return this.destructible;
    }
}
