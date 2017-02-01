package fr.somedagpistudents.wallshooter.entity.weapon;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.wall.BrickType;
import fr.somedagpistudents.wallshooter.tools.ColisionTools;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by benjamin on 1/31/17.
 */
public class BulletTest {
    @Test
    public void createDefaultBullet() throws Exception {
        Bullet bullet = new Bullet(0, 1, 2, 3, 4);
        assertNotNull(bullet);
        assertEquals(bullet.getX(), 0, 0);
        assertEquals(bullet.getY(), 1, 0);
        assertEquals(bullet.getWidth(), 2, 0);
        assertEquals(bullet.getHeight(), 2, 0);
        assertEquals(bullet.getXSpeed(), 3, 0);
        assertEquals(bullet.getYSpeed(), 4, 0);

    }

    @Test
    public void updateBullet() throws Exception {
        Bullet bullet = new Bullet(0, 10, 20, 20, 0);
        assertEquals(bullet.getX(), 0, 0);
        assertEquals(bullet.getY(), 10, 0);

        bullet.update();
        assertEquals(bullet.getX(), 20, 0);
        assertEquals(bullet.getY(), 10, 0);

        bullet.update();
        assertEquals(bullet.getX(), 40, 0);
        assertEquals(bullet.getY(), 10, 0);
    }

    @Test
    public void bulletCollidesWithBrick() throws Exception {
        Bullet bullet;
        Brick brick;
        BrickType easyBrick = new BrickType(1);

        bullet = new Bullet(0, 0);
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));

        bullet = new Bullet(Brick.WIDTH - Bullet.SIZE, 0);
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));

        bullet = new Bullet(Brick.WIDTH - Bullet.SIZE, Brick.HEIGHT - Bullet.SIZE);
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));

        bullet = new Bullet(0, Brick.HEIGHT - Bullet.SIZE);
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));
    }

    @Test
    public void bulletRemovesBrickHealth() throws Exception{
        Bullet bullet;
        Brick brick;
        BrickType easyBrick = new BrickType(1);

        bullet = new Bullet(Brick.WIDTH - Bullet.SIZE, 0);
        brick = new Brick(0, 0, easyBrick);

        assertEquals(0, brick.getBrickLife(),0);
    }

    @Test
    public void bulletDoesNotCollideWithBrick() throws Exception {
        Bullet bullet;
        Brick brick;
        BrickType easyBrick = new BrickType(1);

        bullet = new Bullet(-Bullet.SIZE - 1, 0);
        brick = new Brick(0, 0, easyBrick);
        assertTrue(! ColisionTools.contact(bullet, brick));

//        bullet = new Bullet(Brick.WIDTH, 0);
//        brick = new Brick(0, 0);
//        assertTrue(ColisionTools.contact(bullet, brick));
//
//        bullet = new Bullet(Brick.WIDTH - Bullet.SIZE, Brick.HEIGHT - Bullet.SIZE);
//        brick = new Brick(0, 0);
//        assertTrue(ColisionTools.contact(bullet, brick));
//
//        bullet = new Bullet(0, Brick.HEIGHT - Bullet.SIZE);
//        brick = new Brick(0, 0);
//        assertTrue(ColisionTools.contact(bullet, brick));
    }
}
