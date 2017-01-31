package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;
import fr.somedagpistudents.wallshooter.tools.ColisionTools;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.util.ArrayList;
import java.util.Iterator;

public class World {
    private ArrayList<Brick> bricks;
    private ArrayList<Bullet> bullets;
    private Player player;
    private Controller controller;


    public World() {
        this.player = new Player(-640, 0, 60, 100);
        this.player.setWeapon(new Weapon());
        this.bullets = new ArrayList<Bullet>();
        this.bricks = new ArrayList<Brick>();
        this.bricks.add(new Brick(500, 0));
        this.bricks.add(new Brick(0, 250));
        this.controller = new Controller();
    }

    public void update() {
        for (Brick brick : this.bricks) {
            this.controller.checkGameState(this.player, brick);
        }

        player.update();

        this.updateBullets();
        this.updateBricks();

        this.checkCollisions();
    }

    private void checkCollisions() {
        Iterator<Bullet> bulletIter = this.bullets.iterator();
        while (bulletIter.hasNext()) {
            boolean removeBullet = false;
            Bullet bullet = bulletIter.next();

            Iterator<Brick> brickIter = this.bricks.iterator();
            while (brickIter.hasNext()) {
                Brick brick = brickIter.next();

                if(ColisionTools.contact(bullet, brick)) {
                    System.out.println("collision");
                    brickIter.remove();
                    removeBullet = true;

                }
            }

            if (removeBullet) {
                bulletIter.remove();
            }
        }
    }

    private void updateBricks() {
        Iterator<Brick> brickIter = this.bricks.iterator();
        while (brickIter.hasNext()) {
            Brick brick = brickIter.next();
            brick.update();
        }
    }
    private void updateBullets() {
        Iterator<Bullet> bulletIter = this.bullets.iterator();
        while (bulletIter.hasNext()) {
            Bullet bullet = bulletIter.next();
            bullet.update();
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

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
    }
}
