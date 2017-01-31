package fr.somedagpistudents.wallshooter.entity;

public abstract class MovableEntity extends Entity {
    protected float xSpeed;
    protected float ySpeed;

    public MovableEntity(float x, float y, float width, float height, float xSpeed, float ySpeed) {
        super(x, y, width, height);

        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovableEntity(float x, float y, float size, float xSpeed, float ySpeed) {
        this(x, y, size, size, xSpeed, ySpeed);
    }

    public float getXSpeed() {
        return this.xSpeed;
    }

    public float getYSpeed() {
        return this.ySpeed;
    }

}
