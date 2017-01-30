package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Player;

public class World {
    Player p;
    Brick b;

    public World() {
        this.p = new Player(-640,0,20,30);
        this.b = new Brick(640,0);
    }

    public World render(){
        this.p.update();
        return this;
    }
}
