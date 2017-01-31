package fr.somedagpistudents.wallshooter.entity.weapon;

import fr.somedagpistudents.wallshooter.entity.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by benjamin on 1/31/17.
 */
public class WeaponTest {
    @Test
    public void constructDefaultWeapon() throws Exception {
        Weapon weapon = new Weapon();
        assertNotNull(weapon);
        assertEquals(weapon.getFireRateInMillis(), Weapon.DEFAULT_FIRE_RATE_MILLIS, 0);
    }

    @Test
    public void constructComplexWeapon() throws Exception {
        Weapon weapon = new Weapon(54);
        assertNotNull(weapon);
        assertEquals(weapon.getFireRateInMillis(), 54, 0);
    }

    @Test
    public void bulletCreatedOnShoot() throws Exception {
        Weapon weapon = new Weapon();
        Bullet bullet = weapon.shoot(0, 1);
        assertNotNull(bullet);
        assertEquals(bullet.getX(), 0, 0);
        assertEquals(bullet.getY(), 1, 0);
    }

    @Test
    public void canShoot() throws Exception {
        Weapon weapon1 = new Weapon();
        assertTrue(weapon1.canShoot());
        weapon1.shoot(0, 0);
        assertFalse(weapon1.canShoot());

        Weapon weapon2 = new Weapon(0);
        assertTrue(weapon2.canShoot());
        weapon2.shoot(0, 0);
        assertTrue(weapon2.canShoot());
    }

}
