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
        BrickType easyBrick = new BrickType(1);
        Brick brick = new Brick(0, 0, easyBrick);
        Brick brick2 = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(brick,brick2));
    }

    @Test
    public void noContactTest(){
        BrickType easyBrick = new BrickType(1);
        Brick brick = new Brick(0, 0, easyBrick);
        Brick brick2 = new Brick(500, 500, easyBrick);
        assertFalse(ColisionTools.contact(brick,brick2));
    }
}
