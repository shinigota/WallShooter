package fr.somedagpistudents.wallshooter.entity.weapon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
}
