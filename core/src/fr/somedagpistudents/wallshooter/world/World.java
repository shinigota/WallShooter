package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class World {
    private ArrayList<Brick> bricks;
    Player p;

    public World() {
        this.p = new Player(-640,0,60,100);
        this.bricks = new ArrayList<Brick>();
        this.bricks.add(new Brick(0,0));
    }

    public void render() {
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
