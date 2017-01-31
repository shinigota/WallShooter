package fr.somedagpistudents.wallshooter.entity.wall;

import java.util.ArrayList;

/**
 * Created by sbonnan on 30/01/17.
 */
public class Column {
    ArrayList<Brick> bricks = new ArrayList<Brick>();
    static int x = 640;


    public Column() {
        this.bricks.add(calculPosBrick(x,12));
        this.bricks.add(calculPosBrick(x,11));
        this.bricks.add(calculPosBrick(x,10));
        this.bricks.add(calculPosBrick(x,9));
        this.bricks.add(calculPosBrick(x,8));
        this.bricks.add(calculPosBrick(x,7));
        this.bricks.add(calculPosBrick(x,6));
        this.bricks.add(calculPosBrick(x,5));
        this.bricks.add(calculPosBrick(x,4));
        this.bricks.add(calculPosBrick(x,3));
        this.bricks.add(calculPosBrick(x,2));
        this.bricks.add(calculPosBrick(x,1));
        this.bricks.add(calculPosBrick(x,0));
    }

    public Brick calculPosBrick(int x,int position){
        return new Brick(x, (position*60)-360);
    }



}
