package fr.somedagpistudents.wallshooter.entity;

public abstract class MovableEntity extends Entity {
    protected float xSpeed;
    protected float ySpeed;

    public MovableEntity(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public float getXSpeed() {
        return this.xSpeed;
    }

    public float getYSpeed() {
        return this.ySpeed;
    }
}
