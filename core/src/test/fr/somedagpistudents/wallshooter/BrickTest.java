package fr.somedagpistudents.wallshooter;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dopasensei on 31/01/17.
 */
public class BrickTest {
    @Test
    public void BrickIsCreated(){
        Brick b = new Brick(5,5);
        assertNotNull(b);
    }

    @Test
    public void BrickHasGoodCoordinates(){
        Brick b = new Brick(5,5);
        assertEquals(5,b.getX(),0);
        assertEquals(5,b.getY(),0);
    }

    @Test
    public void BrickMovesProperly(){
        Brick b = new Brick(5,5);
        b.update();
        assertEquals(5,b.getX(),0);
        assertEquals(5,b.getY(),0);
    }

    @Test
    public void BrickIsWellDimensioned(){
        Brick b = new Brick(5,5);
        assertEquals(Brick.WIDTH,60,0);
        assertEquals(Brick.HEIGHT,35,0);
    }
}
