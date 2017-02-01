package fr.somedagpistudents.wallshooter.entity.wall;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sbonnan on 31/01/17.
 */
public class Wall {
    private List<Column> columns = new ArrayList<Column>();

    public Wall() {
        this.addColumn();
    }

    private void addColumn() {
        this.columns.add(new Column());
    }

    public void update(){
        Iterator<Column> columnIterator = this.columns.iterator();
        Column column;
        while (columnIterator.hasNext()) {
            column = columnIterator.next();
            if(column.getPosX() < (Column.POSITION_X*-1)-Brick.WIDTH){
                columnIterator.remove();
            }else {
                column.update();
            }
        }

        if(canGenerateColumn()){
            this.addColumn();
        }
    }

    public ArrayList<Brick> getAllBricks(){
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        for(Column column : columns){
            bricks.addAll(column.getBricks());
        }
        return  bricks;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void removeBrick(Brick brick) {
        for(Column column : this.columns) {
            column.getBricks().remove(brick);
        }
    }

    public boolean canGenerateColumn() {
        if(this.columns.get(columns.size()-1).getPosX()+Brick.WIDTH <= Column.POSITION_X){
            return true;
        }
        return false;
    }
}
