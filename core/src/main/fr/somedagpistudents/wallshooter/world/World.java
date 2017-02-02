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
import java.util.List;

import static fr.somedagpistudents.wallshooter.entity.wall.Brick.XSPEED;

public class World {
    private Wall wall;
    private Player player;
    private Controller controller;

    public World(Controller controller) {

        BrickType easyBrick = new BrickType(3);
        BrickType mediumBrick = new BrickType(6);
        BrickType hardBrick = new BrickType(9);
        Brick.XSPEED=-2;

        this.wall = new Wall();

        this.player = new Player(-640, 0, 40, 80);

        this.player.setWeapon(new Weapon(100));
        this.controller = controller;
    }

    public void update() {
        controller.update(this.player,wall.getAllBricks());

        if (controller.getGamestate().equals("gameplay")){
            playGame();
        }
        else if(controller.getGamestate().equals("tuto")){
            playTuto();

        }




    }

    private void playGame() {
        player.update();
        wall.update();
        wall.setDifficulty(player.getScore()/10);
        this.updateBullets();
        this.checkCollisions();
        this.checkCollisionsPlayer();
    }
    private void playTuto() {
        Brick.XSPEED=-2;
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
        Iterator<Bullet> bulletIter = this.getBullets().iterator();
        while (bulletIter.hasNext()) {
            boolean removeBullet = false;
            Bullet bullet = bulletIter.next();

            Iterator<Brick> brickIter = this.wall.getAllBricks().iterator();
            while (brickIter.hasNext()) {
                Brick brick = brickIter.next();

                if(ColisionTools.contact(brick, bullet)) {
                    brick.setBrickLife(brick.getBrickLife() - bullet.getDamages());
                    if(brick.getBrickLife() <= 0){
                        this.wall.removeBrick(brick);
                    }
                    removeBullet = true;

                }
            }

            if (removeBullet) {
                bulletIter.remove();
            }
        }
    }

    private void updateBullets() {
        Iterator<Bullet> bulletIter = this.getBullets().iterator();
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

    public Controller getController() {
        return this.controller;
    }

    public List<Bullet> getBullets() {
        return this.player.getWeapon().getBullets();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
