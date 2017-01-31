package fr.somedagpistudents.wallshooter.entity.wall;

import java.util.ArrayList;

/**
 * Created by sbonnan on 30/01/17.
 */
public class Column {
    private ArrayList<Brick> bricks = new ArrayList<Brick>();


    public Column(int x, int[] pos) {
        for(int position: pos ) {
            this.bricks.add(calculPosBrick(x, position));
        }
    }

    private Brick calculPosBrick(int x,int position){
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
