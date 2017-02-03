package fr.somedagpistudents.wallshooter.entity.bonus;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;

import fr.somedagpistudents.wallshooter.entity.MovableEntity;

import static fr.somedagpistudents.wallshooter.entity.wall.Brick.DEFAULT_XSPEED;
import static fr.somedagpistudents.wallshooter.entity.wall.Brick.DEFAULT_YSPEED;

public class Bonus extends MovableEntity {
    public static final float DEFAULT_WIDTH = 35;
    public static final float DEFAULT_HEIGHT = 35;
    private static int typeBonus;


    public static int getTypeBonus() {
        return typeBonus;
    }

    public Bonus(float x, float y, BonusType bt) {
        super(x, y, DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT, DEFAULT_XSPEED, DEFAULT_YSPEED);
        this.setTypeBonus(bt.getType());

    }

    public static void setTypeBonus(int typeBonus) {
        Bonus.typeBonus = typeBonus;
    }


    @Override

    public void update(float delta) {
        this.x += (DEFAULT_XSPEED * delta);
        this.y += (DEFAULT_YSPEED * delta);

    }

    @Override
    public void onCollision(Object object, float delta) {

    }
}
