package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fr.somedagpistudents.wallshooter.entity.Player;
import org.junit.Test;

/**
 * Created by djacques on 31/01/17.
 */
public class ColisionToolsTest {
    @Test
    public void contactTest(){
        Brick brick = new Brick(0, 0);
        Brick brick2 = new Brick(0, 0);
        assertTrue(ColisionTools.contact(brick,brick2));
    }

    @Test
    public void noContactTest(){
        Brick brick = new Brick(0, 0);
        Brick brick2 = new Brick(500, 500);
        assertFalse(ColisionTools.contact(brick,brick2));
    }
}
