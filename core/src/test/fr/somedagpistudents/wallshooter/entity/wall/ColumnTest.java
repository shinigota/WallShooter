package fr.somedagpistudents.wallshooter.entity.wall;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by sbonnan on 31/01/17.
 */
public class ColumnTest {

    @Test
    public void calculPositionBrickTest() {

        Column column = new Column();
        assertEquals(column.bricks.get(0).getY(),360,0);
        assertEquals(column.bricks.get(12).getY(),-360,0);
    }

}
