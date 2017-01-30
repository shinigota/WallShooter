package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Player;

public class World {
    Player p;
    Brick b1;
    Brick b2;

    public World() {
        this.p = new Player(-640,0,20,30);
        this.b1 = new Brick(640,0);
        this.b2 = new Brick(320,100);
    }

    public World render(){
        this.p.update();
        return this;
    }
}
