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
        BrickType easyBrick = new BrickType(1);
        Brick b = new Brick(5,5,easyBrick);
        assertNotNull(b);
    }

    @Test
    public void BrickHasGoodCoordinates() throws Exception  {
        BrickType easyBrick = new BrickType(1);
        Brick b = new Brick(5,5,easyBrick);
        assertEquals(5,b.getX(),0);
        assertEquals(5,b.getY(),0);
    }

    @Test
    public void BrickMovesProperly() throws Exception  {
        BrickType easyBrick = new BrickType(1);
        Brick b = new Brick(5,5,easyBrick);
        //b.update();
        assertEquals(5+b.getXSpeed(),b.getX(),0);
        assertEquals(5+b.getYSpeed(),b.getY(),0);
    }

    @Test
    public void BrickIsWellDimensioned() throws Exception  {
        BrickType easyBrick = new BrickType(1);
        Brick b = new Brick(5,5,easyBrick);
        assertEquals(Brick.WIDTH,60,0);
        assertEquals(Brick.HEIGHT,35,0);
    }

    @Test
    public void BrickHasCorrectLife() throws Exception{
        BrickType easyBrick = new BrickType(1);
        Brick b = new Brick(5,5,easyBrick);
        assertEquals(1,b.getBrickLife(),0);
    }
}
