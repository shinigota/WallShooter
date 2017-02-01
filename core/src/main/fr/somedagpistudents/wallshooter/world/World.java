package fr.somedagpistudents.wallshooter.world;

import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.BrickType;
import fr.somedagpistudents.wallshooter.entity.wall.Wall;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;
import fr.somedagpistudents.wallshooter.tools.ColisionTools;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.util.ArrayList;
import java.util.Iterator;

public class World {
    private ArrayList<Brick> bricks;
    private ArrayList<Bullet> bullets;
    private Wall wall;
    private Player player;
    private Controller controller;

    public World() {

    }




    public World(Controller controller) {
        BrickType easyBrick = new BrickType(1);
        BrickType mediumBrick = new BrickType(2);
        BrickType hardBrick = new BrickType(3);

        this.wall = new Wall();

        this.player = new Player(-640, 0, 60, 100);
        this.player.setWeapon(new Weapon());
        this.bullets = new ArrayList<Bullet>();
        this.bricks = new ArrayList<Brick>();

        this.bricks.add(new Brick(500, -100, easyBrick));
        this.bricks.add(new Brick(0, 250, mediumBrick));
        this.bricks.add(new Brick(900, 250, hardBrick));
        this.bricks.add(new Brick(500, 100, hardBrick));
        this.bricks.add(new Brick(800, -100, hardBrick));
        this.controller = controller;


    }

    public void update() {

        controller.update(this.player,wall.getAllBricks());
        player.update();
        wall.update();

        this.updateBullets();

        this.checkCollisions();
        this.checkCollisionsPlayer();
    }

    private void checkCollisionsPlayer() {
        Iterator<Brick> brickIterator = wall.getAllBricks().iterator();
        while (brickIterator.hasNext()) {
            Brick brick = brickIterator.next();
            ColisionTools.contact(player, brick);
        }
    }

    private void checkCollisions() {
        Iterator<Bullet> bulletIter = this.bullets.iterator();
        while (bulletIter.hasNext()) {
            boolean removeBullet = false;
            Bullet bullet = bulletIter.next();

            Iterator<Brick> brickIter = this.wall.getAllBricks().iterator();
            while (brickIter.hasNext()) {
                Brick brick = brickIter.next();

                if(ColisionTools.contact(brick, bullet)) {
                    System.out.println("collision");
                    this.wall.removeBrick(brick);
//                    brickIter.remove();
                    removeBullet = true;

                }
            }

            if (removeBullet) {
                bulletIter.remove();
            }
        }
    }

    private void updateBricks() {
        Iterator<Brick> brickIter = wall.getAllBricks().iterator();
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
        return this.wall.getAllBricks();
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
