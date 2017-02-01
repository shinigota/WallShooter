package fr.somedagpistudents.wallshooter.entity.wall;

import org.junit.Test;

import java.util.*;

import static com.badlogic.gdx.math.MathUtils.random;
import static org.junit.Assert.assertEquals;
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

        columns.

        int[] tab = wall.generatePosition();

        assertTrue(tab.length >= 0 && tab.length <= 12);
    }

}
