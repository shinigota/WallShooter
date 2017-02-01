package fr.somedagpistudents.wallshooter.entity.wall;

/**
 * Created by dopasensei on 01/02/17.
 */
public class BrickType {
    private float mBrickTypeLife;

    public BrickType(float brickLife){
        this.mBrickTypeLife = brickLife;
    }

    public float getBrickTypeLife(){
        return this.mBrickTypeLife;
    }

    public void setBrickTypeLife(float brickTypeLife){
        this.mBrickTypeLife = brickTypeLife;
    }
}
