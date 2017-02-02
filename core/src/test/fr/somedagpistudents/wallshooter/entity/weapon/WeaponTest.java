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
        assertEquals(weapon.getBullets().size(), 0, 0);
        weapon.shoot(0, 1);
        assertEquals(weapon.getBullets().size(), 1, 0);
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

    @Test
    public void defaultWeaponHasDamages(){
        Weapon weapon = new Weapon();
        assertEquals(weapon.getDamagesPerBullet(),1,0);
    }

    @Test
    public void customWeaponHasDamages(){
        Weapon weapon = new Weapon(Weapon.DEFAULT_FIRE_RATE_MILLIS,2);
        assertEquals(weapon.getDamagesPerBullet(),2,0);
    }

    @Test
    public void heatCannotGrowTooMuch(){
        Weapon weapon = new Weapon();
        weapon.setHeatPercent(114);
        weapon.growHeat();
        assertEquals(100,weapon.getHeatPercent(),0);
    }

    @Test
    public void heatCannotReduceTooLow(){
        Weapon weapon = new Weapon();
        weapon.setHeatPercent(-2);
        weapon.reduceHeat();
        assertEquals(0,weapon.getHeatPercent(),0);
    }

    @Test
    public void heatReducesProperlyWithOverheat(){
        Weapon weapon = new Weapon();
        float newHealPercent = 110f;
        weapon.setHeatPercent(newHealPercent);
        weapon.shoot(0,0);
        weapon.reduceHeat();
        assertEquals(newHealPercent - Weapon.HEAT_REDUCTION_ON_OVERHEAT, weapon.getHeatPercent(),0);
    }

    @Test
    public void heatReducesProperlyWithoutOverheat(){
        Weapon weapon = new Weapon();
        float newHeatPercent = 80f;
        weapon.setHeatPercent(newHeatPercent);
        weapon.reduceHeat();
        assertEquals(newHeatPercent - Weapon.HEAT_REDUCTION_ON_NORMAL_HEAT, weapon.getHeatPercent(),0);
    }
}
