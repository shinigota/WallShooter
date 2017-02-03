package fr.somedagpistudents.wallshooter.entity.bonus;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;

import static fr.somedagpistudents.wallshooter.entity.wall.Brick.XSPEED;
import static fr.somedagpistudents.wallshooter.entity.wall.Brick.YSPEED;

public class Bonus extends MovableEntity {
    public static final float WIDTH  = 60;
    public static final float HEIGHT = 35;
    private static int typeBonus;


    public static int getTypeBonus() {
        return typeBonus;
    }

    public Bonus(float x, float y, BonusType bt) {
        super(x, y, Brick.WIDTH, Brick.HEIGHT, XSPEED, YSPEED);
        this.setTypeBonus(bt.getType());

    }

    public static void setTypeBonus(int typeBonus) {
        Bonus.typeBonus = typeBonus;
    }


    @Override

    public void update(float delta) {
        this.x += (XSPEED* delta);
        this.y += (YSPEED* delta);

    }

    @Override
    public void onCollision(Object object, float delta) {

    }
}
