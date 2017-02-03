package fr.somedagpistudents.wallshooter.entity.wall;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sbonnan on 31/01/17.
 */
public class Wall {
    private List<Column> columns = new ArrayList<Column>();
    private int difficulty = 0;

    public Wall() {
        this.addColumn();
    }

    private void addColumn() {
        this.columns.add(new Column(difficulty));
    }

    public void update(float delta){
        Iterator<Column> columnIterator = this.columns.iterator();
        Column column;
        while (columnIterator.hasNext()) {
            column = columnIterator.next();
            if(column.getPosX() < (Column.POSITION_X*-1)-Brick.WIDTH){
                columnIterator.remove();
            }else {
                column.update(delta);
            }
        }

        if(canGenerateColumn()){
            this.addColumn();
        }
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty(){
        return difficulty;
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
        if(this.columns.get(columns.size()-1).getPosX()+Brick.WIDTH <= Column.POSITION_X-5)
        {
            return true;
        }
        return false;
    }
}
