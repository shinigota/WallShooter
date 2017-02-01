package fr.somedagpistudents.wallshooter.entity.wall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.badlogic.gdx.math.MathUtils.random;

/**
 * Created by sbonnan on 30/01/17.
 */
public class Column {
    public static final int POSITION_X = 640;
    public final static int MAX_NB_BRICK = 12;
    private float posX;
    private float speedX;
    private ArrayList<Brick> bricks = new ArrayList<Brick>();

    public Column() {
        posX = POSITION_X;
        speedX = Brick.XSPEED;
        Set<Integer> pos = generatePosition();
        for(int position: pos ) {
            BrickType bt = new BrickType(1);
            int nb = (int) (Math.random() * 10 );
            bt.setBrickTypeLife(nb);
            this.bricks.add(generateBrick(POSITION_X, position, bt));
        }
    }

    public List<Brick> getBricks(){
        return bricks;
    }

    private Set<Integer> generatePosition() {
        HashSet<Integer> pos = new HashSet<Integer>();

        for(int i=0;i<=MAX_NB_BRICK;i++){
            pos.add(random(0,MAX_NB_BRICK));
        }
        return pos;
    }

    private Brick calculPosBrick(int x,int position, BrickType brickType) {
        return new Brick(x, (position * 60) - 360, brickType);
    }
    private Brick generateBrick(int x, int position, BrickType brickType) {
        return new Brick(x, (position * 60) - 360, brickType);
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void destroyBrick(Brick brick){
        this.bricks.remove(brick);
    }

    public void update(){
        this.posX += this.speedX;
        for(Brick brick: this.bricks){
            brick.update();
        }
    }

}
