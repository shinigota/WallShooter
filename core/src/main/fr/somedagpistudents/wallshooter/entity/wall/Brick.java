package fr.somedagpistudents.wallshooter.entity.wall;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;

public class Brick extends MovableEntity {
    public static final float DEFAULT_WIDTH = 60;
    public static final float DEFAULT_HEIGHT = 35;
    public static float DEFAULT_XSPEED = -300;
    public static float DEFAULT_YSPEED = 0;
    public boolean destructible;
    private float mHealthPoints;
    private float mMoneyOnBreak;


    public Brick(float x, float y, BrickType bt) {
        super(x, y, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT,Brick.DEFAULT_XSPEED,Brick.DEFAULT_YSPEED);
        this.mHealthPoints = bt.getLife();
        this.mMoneyOnBreak = bt.getMoney();
        this.destructible=bt.isDestructible();
    }

    public float getLife(){
        return mHealthPoints;
    }

    public void setLife(float newBrickLife){
        this.mHealthPoints = newBrickLife;
    }

    public float getMoney(){
        return this.mMoneyOnBreak;
    }


    @Override

    public void update(float delta) {
        this.x += (this.DEFAULT_XSPEED * delta);
        this.y += (this.DEFAULT_YSPEED * delta);

    }

    @Override
    public void onCollision(Object object, float delta) {

    }

    public boolean isDestructible() {
        return destructible;
    }

    public void destroyBrick(Wall wall){
        wall.removeBrick(this);
    }

    public Brick hit(Bullet bullet) {
        if(this.isDestructible()){
            this.setLife(this.getLife() - bullet.getDamages());
            if(this.getLife() <= 0){
                return this;
            }
        }
        return null;
    }
}
