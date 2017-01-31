package fr.somedagpistudents.wallshooter.entity.player;

import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by benjamin on 1/31/17.
 */
public class PlayerTest {
    @Test
    public void playerHasWeapon() throws Exception {
        Player player = new Player(0, 0, 10, 10);
        assertNull(player.getWeapon());
        player.setWeapon(new Weapon());
        assertNotNull(player.getWeapon());
    }
}
