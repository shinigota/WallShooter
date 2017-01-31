package fr.somedagpistudents.wallshooter.entity.wall;

import java.util.ArrayList;

/**
 * Created by sbonnan on 30/01/17.
 */
public class Column {
    ArrayList<Brick> bricks = new ArrayList<Brick>();


    public Column(int x, int[] pos) {
        for(int position: pos ) {
            this.bricks.add(calculPosBrick(x, position));
        }
    }


    Brick calculPosBrick(int x,int position){
        return new Brick(x, (position*60)-360);
    }

    public int getPosBrick(Brick brick){
        return (int) (brick.getY()+360)/60;
    }

    public Brick getBrickPos(int pos){
        for(int i =0;i<this.bricks.size();i++){
            if(getPosBrick(this.bricks.get(i)) == pos){
                return this.bricks.get(i);
            }
        }
        return null;
    }

    public int getIdBrick(Brick brick){
        //return this.bricks;
        for(int i = 0; i<this.bricks.size(); i++){
            if(this.bricks.get(i).equals(brick)){
                return i;
            }
        }
        return -1;
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
