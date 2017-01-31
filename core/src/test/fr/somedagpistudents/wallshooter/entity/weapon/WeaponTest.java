package fr.somedagpistudents.wallshooter.entity.weapon;

import fr.somedagpistudents.wallshooter.entity.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by benjamin on 1/31/17.
 */
public class WeaponTest {
    @Test
    public void constructDefaultWeapon() {
        Weapon weapon = new Weapon();
        assertNotNull(weapon);
        assertEquals(weapon.getFireRateInMillis(), Weapon.DEFAULT_FIRE_RATE_MILLIS, 0);
    }

    @Test
    public void constructComplexWeapon() {
        Weapon weapon = new Weapon(54);
        assertNotNull(weapon);
        assertEquals(weapon.getFireRateInMillis(), 54, 0);
    }

    @Test
    public void bulletCreatedOnShoot() {
        Weapon weapon = new Weapon();
        Bullet bullet = weapon.shoot();
        assertNotNull(bullet);
    }

    @Test
    public void canShoot() {
        Weapon weapon1 = new Weapon();
        assertTrue(weapon1.canShoot());
        weapon1.shoot();
        assertFalse(weapon1.canShoot());

        Weapon weapon2 = new Weapon(0);
        assertTrue(weapon2.canShoot());
        weapon2.shoot();
        assertTrue(weapon2.canShoot());

    }

}
