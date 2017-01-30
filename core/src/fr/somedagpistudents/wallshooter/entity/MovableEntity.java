package fr.somedagpistudents.wallshooter.entity;

public abstract class MovableEntity extends Entity {
    protected float xSpeed;
    protected float ySpeed;

    public MovableEntity(float x, float y) {
        super(x, y);
    }

    public float getXSpeed() {
        return this.xSpeed;
    }

    public float getYSpeed() {
        return this.ySpeed;
    }
}
