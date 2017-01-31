package fr.somedagpistudents.wallshooter.entity.wall;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sbonnan on 31/01/17.
 */
public class BrickTest {

    @Test
    public void createBrickTest() throws Exception {

    }

    @Test
    public void BrickIsCreated() throws Exception  {
        Brick b = new Brick(5,5);
        assertNotNull(b);
    }

    @Test
    public void BrickHasGoodCoordinates() throws Exception  {
        Brick b = new Brick(5,5);
        assertEquals(5,b.getX(),0);
        assertEquals(5,b.getY(),0);
    }

    @Test
    public void BrickMovesProperly() throws Exception  {
        Brick b = new Brick(5,5);
        b.update();
        assertEquals(5,b.getX(),0);
        assertEquals(5,b.getY(),0);
    }

    @Test
    public void BrickIsWellDimensioned() throws Exception  {
        Brick b = new Brick(5,5);
        assertEquals(Brick.WIDTH,60,0);
        assertEquals(Brick.HEIGHT,35,0);
    }
}
