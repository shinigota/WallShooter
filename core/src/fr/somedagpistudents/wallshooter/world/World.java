package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Player;
import fr.somedagpistudents.wallshooter.tools.Controller;

public class World {
    Player p;
    Brick b;
    Controller c;

    public World() {
        this.p = new Player(-640,0,20,30);
        this.b = new Brick(640,0,20,15);
        this.c = new Controller();

    }

    public World render(){
        this.p.update();
        this.c.checkGameState(this.p,this.b);
        return this;
    }
}
