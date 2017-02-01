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
    public final static int MAX_NB_BRICK = 16;
    public final static int MAX_BRICK_IN = 8;
    private float posX;
    private float speedX;
    private ArrayList<Brick> bricks = new ArrayList<Brick>();

    public Column(int difficulty) {
        posX = POSITION_X;
        speedX = Brick.XSPEED;
        Set<Integer> pos;
        if(difficulty < MAX_BRICK_IN) {
            pos = generatePosition(difficulty);
        }else{
            pos = generatePosition(MAX_BRICK_IN);
        }
        for(int position: pos ) {
            BrickType bt = new BrickType(1);
            int nb = (int) (Math.random() * 10);
            bt.setBrickTypeLife(nb);
            this.bricks.add(generateBrick(POSITION_X, position, bt));
        }
    }

    public boolean validColumn(Set<Integer> pos){
        if (pos.size() == MAX_NB_BRICK){
            for(int position : pos){
                if( position < 0 || MAX_NB_BRICK< position) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public List<Brick> getBricks(){
        return bricks;
    }

    private Set<Integer> generatePosition(int difficulty) {
        HashSet<Integer> pos = new HashSet<Integer>();

        for(int i=0;i<=difficulty;i++){
            pos.add(random(0,MAX_NB_BRICK));
        }
        return pos;
    }

    private Brick generateBrick(int x, int position, BrickType brickType) {
        return new Brick(x, (position * (Brick.HEIGHT+5))- 340, brickType);
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

    public float getSpeedX() {
        return speedX;
    }
}
