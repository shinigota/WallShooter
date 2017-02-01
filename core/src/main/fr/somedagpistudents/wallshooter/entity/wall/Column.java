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
    private static final int POSITION_X = 640;
    public final static int MAX_NB_BRICK = 12;
    private ArrayList<Brick> bricks = new ArrayList<Brick>();

    public Column() {
        Set<Integer> pos = generatePosition();
        for(int position: pos ) {
            this.bricks.add(generateBrick(POSITION_X, position));
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

    private Brick generateBrick(int x, int position){
        return new Brick(x, (position*60)-360);
    }

    public void destroyBrick(Brick brick){
        this.bricks.remove(brick);
    }

    public void update(){
        for(Brick brick: this.bricks){
            brick.update();
        }
    }

}
