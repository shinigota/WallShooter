package fr.somedagpistudents.wallshooter.entity.wall;

import com.badlogic.gdx.Game;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.MovableEntity;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.tools.Assets;

public class Brick extends MovableEntity {
    public static final float WIDTH  = 60;
    public static final float HEIGHT = 35;
    public static float XSPEED  = -300;
    public static float YSPEED = 0;
    public boolean destructible;
    private float mHealthPoints;
    private float mMoneyOnBreak;


    public Brick(float x, float y, BrickType bt) {
        super(x, y, Brick.WIDTH, Brick.HEIGHT,Brick.XSPEED,Brick.YSPEED);
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
        this.x += (this.XSPEED * delta);
        this.y += (this.YSPEED* delta);

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
