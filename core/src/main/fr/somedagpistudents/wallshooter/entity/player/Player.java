package fr.somedagpistudents.wallshooter.entity.player;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;

/**
 * Created by djacques on 30/01/17.
 */
public class Player extends MovableEntity {
    private int score = 0;
    private Weapon weapon;
    protected boolean blockedFront = false;


    public Player(float x, float y, float width, float height) {

        super(x, y, width, height);
        this.xSpeed = 2;
        this.ySpeed = 0;
    }

    @Override
    public void update() {
        if(!this.blockedFront) {
            this.x += getXSpeed();
        }else{
            this.blockedFront = false;
        }
        this.y += getYSpeed();
    }

    @Override
    public void contactWith(Object object) {
        if(object instanceof Brick){
            this.blockedFront = true;
        }
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
