package fr.somedagpistudents.wallshooter.entity.wall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbonnan on 31/01/17.
 */
public class Wall {
    public final static int MAX_NB_BRICK = 12;
    private List<Column> columns = new ArrayList<Column>();

    public Wall() {
      //  this.columns.add(new Column(640,rand));
    }

    public void update(){
        for(Column column: this.columns){
            column.update();
        }
    }


}
