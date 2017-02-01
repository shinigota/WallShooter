package fr.somedagpistudents.wallshooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import org.junit.Test;
import fr.somedagpistudents.wallshooter.world.World;

import static org.junit.Assert.*;

/**
 * Created by fjude001 on 31/01/17.
 */
public class ControllerTest {
    @Test
    public void worldHasController() throws Exception  {
        World world = new World();
        assertNotNull(world.getController());

    }

    public void playerCantLeaveScreen() throws Exception{
       // Player player = new Player(0,0);




    }
}
