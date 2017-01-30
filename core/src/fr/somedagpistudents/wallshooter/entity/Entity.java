package fr.somedagpistudents.wallshooter.entity;

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

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }
}
