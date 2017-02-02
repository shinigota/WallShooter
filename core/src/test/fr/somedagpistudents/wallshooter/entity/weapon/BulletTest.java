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
        Weapon weapon = new Weapon();
        Bullet bullet = new Bullet(0, 1, 2, 3, 4, weapon.getDamagesPerBullet());
        assertNotNull(bullet);
        assertEquals(bullet.getX(), 0, 0);
        assertEquals(bullet.getY(), 1, 0);
        assertEquals(bullet.getWidth(), 2, 0);
        assertEquals(bullet.getHeight(), 2, 0);
        assertEquals(bullet.getXSpeed(), 3, 0);
        assertEquals(bullet.getYSpeed(), 3, Bullet.MAX_Y_RAND);
    }

    @Test
    public void updateBullet() throws Exception {
        Weapon weapon = new Weapon();
        Bullet bullet = new Bullet(0, 10, 20, 20, 0, weapon.getDamagesPerBullet());
        assertEquals(bullet.getX(), 0, 0);
        assertEquals(bullet.getY(), 10, 0);

        bullet.update(1);
        assertEquals(bullet.getX(), 20, 0);
        assertEquals(bullet.getY(), 10, Bullet.MAX_Y_RAND);

        bullet.update(1);
        assertEquals(bullet.getX(), 40, 0);
        assertEquals(bullet.getY(), 10, Bullet.MAX_Y_RAND);
    }

    @Test
    public void bulletCollidesWithBrick() throws Exception {
        Bullet bullet;
        Brick brick;
        BrickType easyBrick = new BrickType(1, 10);
        Weapon weapon = new Weapon();

        bullet = new Bullet(0, 0, weapon.getDamagesPerBullet());
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));

        bullet = new Bullet(Brick.WIDTH - Bullet.SIZE, 0, weapon.getDamagesPerBullet());
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));

        bullet = new Bullet(Brick.WIDTH - Bullet.SIZE, Brick.HEIGHT - Bullet.SIZE, weapon.getDamagesPerBullet());
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));

        bullet = new Bullet(0, Brick.HEIGHT - Bullet.SIZE, weapon.getDamagesPerBullet());
        brick = new Brick(0, 0, easyBrick);
        assertTrue(ColisionTools.contact(bullet, brick));
    }


    @Test
    public void bulletDoesNotCollideWithBrick() throws Exception {
        Bullet bullet;
        Brick brick;
        BrickType easyBrick = new BrickType(1, 10);
        Weapon weapon = new Weapon();

        bullet = new Bullet(-Bullet.SIZE - 1, 0, weapon.getDamagesPerBullet());
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

    @Test
    public void bulletHasWeaponDamages(){
        Weapon weapon = new Weapon();
        weapon.shoot(0,0);
        assertEquals(weapon.getDamagesPerBullet(),weapon.getBullets().get(0).getDamages(),0);
    }


    @Test
    public void bulletRemovesBrickHealth() throws Exception{
        Weapon weapon = new Weapon();
        weapon.shoot(0,0);
        Bullet bullet = weapon.getLastBullet();
        BrickType easyBrick = new BrickType(1, 10);
        Brick brick = new Brick(0, 0, easyBrick);
        brick.setLife(brick.getLife()-bullet.getDamages());

        assertEquals(0, brick.getLife(),0);
    }
}
