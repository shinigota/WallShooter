package fr.somedagpistudents.wallshooter.entity.wall;

import java.util.ArrayList;

/**
 * Created by sbonnan on 30/01/17.
 */
public class Column {
    private ArrayList<Brick> bricks = new ArrayList<Brick>();


    public Column(int x, int[] pos) {
        for(int position: pos ) {
            BrickType bt = new BrickType(1);
            int nb = (int) (Math.random() * 3 );
            switch (nb){
                case 0:
                    bt.setBrickTypeLife(1);
                    break;
                case 1:
                    bt.setBrickTypeLife(2);
                    break;
                case 2:
                    bt.setBrickTypeLife(3);
                    break;
            }
            this.bricks.add(calculPosBrick(x, position,bt));
        }
    }

    private Brick calculPosBrick(int x,int position, BrickType brickType){
        return new Brick(x, (position*60)-360,brickType);
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
