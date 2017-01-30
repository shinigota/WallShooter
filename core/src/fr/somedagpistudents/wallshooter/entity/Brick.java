package fr.somedagpistudents.wallshooter.entity;

public class Brick extends Entity {
    public static final float WIDTH  = 2;
    public static final float HEIGHT = 2;
    public static final float BRICK_WIDTH = 60;
    public static final float BRICK_HEIGHT = 35;

    public Brick(float x, float y) {
        super(x, y, BRICK_WIDTH, BRICK_HEIGHT);
    }

    @Override
    public void update() {

    }
}
