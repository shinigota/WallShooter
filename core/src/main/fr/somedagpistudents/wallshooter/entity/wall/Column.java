package fr.somedagpistudents.wallshooter.entity.wall;

import com.badlogic.gdx.math.MathUtils;

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
    private ArrayList<Brick> bricks = new ArrayList<Brick>();

    public Column(int difficulty) {
        posX = POSITION_X;
        Set<Integer> pos;
        if(difficulty < MAX_BRICK_IN) {
            Brick.XSPEED = -100 * (difficulty+1);
            pos = generatePosition(difficulty);
        }else{
            Brick.XSPEED = -100 * MAX_BRICK_IN;
            pos = generatePosition(MAX_BRICK_IN);
        }
        for(int position: pos ) {
            BrickType bt = new BrickType((int) (Math.random() * 10), 10, MathUtils.random(1,5) != 3);

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

    public void update(float delta){
        this.posX += (Brick.XSPEED*delta);
        for(Brick brick: this.bricks){
            brick.update(delta);
        }
    }

    public float getSpeedX() {
        return Brick.XSPEED;
    }
}
