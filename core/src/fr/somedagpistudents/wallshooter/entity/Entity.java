package fr.somedagpistudents.wallshooter.entity;

/**
 * Created by benjamin on 1/30/17.
 */
public abstract class Entity {
    protected float width;
    protected float height;
    protected float x;
    protected float y;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void update();

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
