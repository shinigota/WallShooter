package fr.somedagpistudents.wallshooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.screen.GameScreen;
import fr.somedagpistudents.wallshooter.tools.Controller;
import org.junit.Test;
import fr.somedagpistudents.wallshooter.world.World;

import static org.junit.Assert.*;

/**
 * Created by fjude001 on 31/01/17.
 */
public class ControllerTest {
    @Test
    public void worldHasController() throws Exception  {
        World world = new World(new Controller(new GameScreen(new WallShooter())));
        assertNotNull(world.getController());

    }

    public void playerCantLeaveScreen() throws Exception{
       // Player player = new Player(0,0);




    }
}
