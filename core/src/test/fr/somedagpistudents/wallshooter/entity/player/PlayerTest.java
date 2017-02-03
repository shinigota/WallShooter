package fr.somedagpistudents.wallshooter.entity.player;

import fr.somedagpistudents.wallshooter.entity.bonus.Bonus;
import fr.somedagpistudents.wallshooter.entity.bonus.BonusType;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by benjamin on 1/31/17.
 */
public class PlayerTest {
    @Test
    public void playerHasWeapon() throws Exception {
        Player player = new Player(0, 0, 10, 10);
        //Player's weapon is now set at creation
        //assertNull(player.getWeapon());
        //player.setWeapon(new Weapon());
        assertNotNull(player.getWeapon());
    }
    @Test
    public void playerCollidesGetsBonus() throws Exception {
        Player player = new Player(0,0,0,0);
        Bonus bonus = new Bonus(0,0,new BonusType(3));
        assertNotEquals(player.typeBonus,bonus.getTypeBonus());
        player.onCollision(bonus,0);
        assertEquals(player.typeBonus,bonus.getTypeBonus());
    }
    @Test
  public void playerShotsMultipeBonus() throws Exception {
        Player player = new Player(0,0,10,10);
        Bonus bonus = new Bonus(0,0,new BonusType(3));
        player.onCollision(bonus,0);
        player.shoot();

        bonus = new Bonus(0,0,new BonusType(0));
        player.onCollision(bonus,0);

    }



}
