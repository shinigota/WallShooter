package fr.somedagpistudents.wallshooter.entity.wall;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dopasensei on 01/02/17.
 */
public class BrickTypeTest {
    @Test
    public void createBrickTypeTest() throws Exception {
        BrickType bt = new BrickType(2);
        assertNotNull(bt);
    }

    @Test
    public void brickTypeHasLifeTest() throws Exception{
        BrickType bt = new BrickType(2);
        assertEquals(2,bt.getBrickTypeLife(),0);
    }
}
