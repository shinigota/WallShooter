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

        WallShooter game = new WallShooter();
        WallShooter wallshooter = new WallShooter();
        Controller controller = new Controller(wallshooter);
        World world = new World(controller, game);
        assertNotNull(controller);


    }

    public void playerCantLeaveScreen() throws Exception{
    }
}
