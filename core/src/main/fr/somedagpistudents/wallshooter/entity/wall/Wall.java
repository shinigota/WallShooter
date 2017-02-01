package fr.somedagpistudents.wallshooter.entity.wall;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbonnan on 31/01/17.
 */
public class Wall {
    private List<Column> columns = new ArrayList<Column>();

    public Wall() {
      this.columns.add(new Column());
    }

    public void update(){
        for(Column column: this.columns){
            column.update();
        }
    }

    public ArrayList<Brick> getAllBricks(){
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        for(Column column : columns){
            bricks.addAll(column.getBricks());
        }
        return  bricks;
    }
}
