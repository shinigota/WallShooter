package fr.somedagpistudents.wallshooter.entity.wall;

import org.junit.Test;

import java.util.*;

import static com.badlogic.gdx.math.MathUtils.random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by sbonnan on 31/01/17.
 */
public class WallTest {
    @Test
    public void canGetColumns() throws Exception {
        Wall wall = new Wall();
        //wall.getColumn();
       // wall.columns.size();
        //assertThat(wall.columns, new Column());
    }

    @Test
    public void nbBrick() throws Exception {
        Wall wall = new Wall() {};

        Set<Column> columns = new HashSet<Column>();

    }

    @Test
    public void validPosColumn() throws Exception {
        Wall wall = new Wall();
        List<Column> columns = wall.getColumns();
        assertEquals(Column.POSITION_X,columns.get(0).getPosX(), 0);
        assertFalse(wall.canGenerateColumn());

        columns.get(0).setPosX(Column.POSITION_X-Brick.WIDTH);
        assertTrue(wall.canGenerateColumn());
    }
}
