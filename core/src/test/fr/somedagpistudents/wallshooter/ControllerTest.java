package fr.somedagpistudents.wallshooter;
import org.junit.Test;
import fr.somedagpistudents.wallshooter.world.World;

import static org.junit.Assert.*;

/**
 * Created by fjude001 on 31/01/17.
 */
public class ControllerTest {
    @Test
    public void worldHasController(){
        World world = new World();
        assertNotNull(world.getController());

    }
}
