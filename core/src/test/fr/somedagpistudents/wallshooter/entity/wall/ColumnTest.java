package fr.somedagpistudents.wallshooter.entity.wall;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * Created by sbonnan on 31/01/17.
 */
public class ColumnTest {
/*
    @Test
    public void checkColumnSize() {

        Column column = new Column(640,new int[]{0,2,6,12});
        assertEquals(4, column.bricks.size());
    }

    @Test
    public void checkFirstBrick() throws Exception {
        Column column = new Column(640,new int[]{0,2,6,12});
        assertThat(column.getBrickPos(12).getY(), is(360.0F));
    }

    @Test
    public void checkLastBrick() throws Exception {
        Column column = new Column(640,new int[]{0,2,6,12});
        assertThat(column.getBrickPos(0).getY(), is(-360.0F));
    }
*/

    @Test
    public void columnPosX() throws Exception {
        Column column = new Column();
        assertEquals(column.getPosX(), Column.POSITION_X, 0);
    }

    @Test
    public void columnSpeedX() throws Exception {
        Column column = new Column();
        assertEquals(column.getSpeedX(), Brick.XSPEED, 0);
    }

    @Test
    public void validateColumn() throws Exception {
        Column column = new Column();
        Set<Integer> pos = new HashSet<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12));
        column.validColumn(pos);
    }
}
