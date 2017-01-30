package fr.somedagpistudents.wallshooter.entity;

/**
 * Created by djacques on 30/01/17.
 */
public class Player extends MovableEntity{

    protected int score = 0;


    public Player(float x, float y, float width, float height) {

        super(x, y, width, height);
        this.xSpeed = 2;
        this.ySpeed = 0;
    }

    @Override
    public void update() {
        this.x = getX()+getXSpeed();
        this.y = getY()+getYSpeed();
    }
}
