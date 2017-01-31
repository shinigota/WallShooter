package fr.somedagpistudents.wallshooter.entity;

public class Brick extends Entity {
    public static final float WIDTH  = 60;
    public static final float HEIGHT = 35;

    public Brick(float x, float y) {
        super(x, y, Brick.WIDTH, Brick.HEIGHT);
    }

    @Override
    public void update() {

    }

    @Override
    public void contactWith(Object object) {

    }
}
