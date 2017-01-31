package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.util.ArrayList;
import java.util.Iterator;

public class World {
    private ArrayList<Brick> bricks;
    private Player player;
    private Controller controller;


    public World() {
        this.player = new Player(-640, 0, 60, 100);
        this.bricks = new ArrayList<Brick>();
        this.bricks.add(new Brick(500, 0));
        this.bricks.add(new Brick(0, 250));
        this.controller = new Controller();
    }

    public void update() {
        this.controller.checkGameState(this.player, this.bricks.get(0));

        player.update();

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
        return this.player;
    }

    public Object getController() {
        return this.controller;
    }
}
