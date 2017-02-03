package fr.somedagpistudents.wallshooter.tools;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.wall.BrickType;
import org.junit.Test;

/**
 * Created by djacques on 31/01/17.
 */
public class ColisionToolsTest {
    @Test
    public void contactTest(){
        BrickType easyBrick = new BrickType(1, 10, true);
        Brick brick = new Brick(0, 0, easyBrick);
        Brick brick2 = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(brick,brick2));
    }

    @Test
    public void noContactTest(){
        BrickType easyBrick = new BrickType(1, 10, true);
        Brick brick = new Brick(0, 0, easyBrick);
        Brick brick2 = new Brick(500, 500, easyBrick);
        assertFalse(ColisionTools.contact(brick,brick2));
    }

    @Test
    public void collisionWorks() throws Exception {
        assertTrue(ColisionTools.collision(10.0f, 10.0f, 0f));
        assertTrue(ColisionTools.collision(10.0f, 1.0f, 10f));
        assertFalse(ColisionTools.collision(10.0f, 1.0f, 1f));

    }
}
