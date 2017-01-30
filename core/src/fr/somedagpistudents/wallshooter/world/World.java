package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Player;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class World {
    private ArrayList<Brick> bricks;
    Player p;
    Brick b;
    Controller c;


    public World() {
        this.p = new Player(-640,0,60,100);
        this.bricks = new ArrayList<Brick>();
        this.bricks.add(new Brick(500,0));
        this.bricks.add(new Brick(0,250));
    }

    public void render() {

        this.c.checkGameState(this.p,this.b);

        p.update();

        Iterator<Brick> brickIter = this.bricks.iterator();
        while (brickIter.hasNext()) {
            Brick brick = brickIter.next();
            brick.update();
        }
    }

    public ArrayList<Brick> getBricks() {
        return this.bricks;
    }

    public Player getPlayer() {
        return this.p;

    }
}
