package fr.somedagpistudents.wallshooter.world;

import com.badlogic.gdx.math.MathUtils;
import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.bonus.Bonus;
import fr.somedagpistudents.wallshooter.entity.bonus.BonusType;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Wall;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;
import fr.somedagpistudents.wallshooter.entity.weapon.Weapon;
import fr.somedagpistudents.wallshooter.tools.Assets;
import fr.somedagpistudents.wallshooter.tools.ColisionTools;
import fr.somedagpistudents.wallshooter.tools.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {
    private WallShooter game;
    private Wall wall;
    private Player player;
    private Controller controller;
    private ArrayList<Bonus> bonusList;


    public World(Controller controller, WallShooter game) {
        this.game = game;
            bonusList=new ArrayList<Bonus>() ;
        this.controller = controller;


        this.wall = new Wall();

        this.player = new Player(-640, 0, 40, 80);
        this.player.setWeapon(new Weapon(100));

    }

    public void update(float delta) {
        controller.update(this.player,wall.getAllBricks());

        if (controller.getGamestate().equals("gameplay")){
            playGame(delta);
        }
        else if(controller.getGamestate().equals("tuto")){
            playTuto(delta);

        }
    }

    private void playGame(float delta) {
        //Brick.DEFAULT_XSPEED=-800;
        if(player.canShoot()) {
            this.game.getSoundManager().playSound(Assets.SOUND_LASER);
        }
        player.update(delta);
        wall.update(delta);
        wall.setDifficulty(player.getScore()/10);
        this.updateBullets(delta);
        this.checkCollisions();
        this.checkCollisionsPlayer(delta);
    }
    private void playTuto(float delta) {
        Brick.DEFAULT_XSPEED =-200;

        this.checkCollisions();
        this.checkCollisionsPlayer(delta);

        player.update(delta);
        wall.update(delta);
        wall.setDifficulty(player.getScore()/10);
        this.updateBullets(delta);
    }

    private void checkCollisionsPlayer(float delta) {
        Iterator<Brick> brickIterator = wall.getAllBricks().iterator();
        while (brickIterator.hasNext()) {
            Brick brick = brickIterator.next();
            ColisionTools.contactMoove(player, brick,delta);

        }
        Iterator<Bonus> bonusIterator = this.getAllBonus().iterator();
        while (bonusIterator.hasNext()) {
            Bonus bonus = bonusIterator.next();
            if( ColisionTools.contact(player, bonus)==true){
                bonusIterator.remove();
            }
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
                    if(brick.hit(bullet) != null){
                        player.setMoney(player.getMoney() + brick.getMoney());
                        game.getSoundManager().playSound(Assets.SOUND_EXPLOSION);
                        brick.destroyBrick(wall);

//                        if(MathUtils.random(1,7) == 3){
//                            bonusList.add(new Bonus( bullet.getX(),bullet.getY(), new BonusType(MathUtils.random(2, 2 + wall.getDifficulty()))));
//                        }

                    }
                    removeBullet = true;
                }
            }

            if (removeBullet) {
                bulletIter.remove();

            }
        }
    }

    private void updateBullets(float delta) {
        Iterator<Bullet> bulletIter = this.getBullets().iterator();
        while (bulletIter.hasNext()) {
            Bullet bullet = bulletIter.next();
            bullet.update(delta);
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

    public ArrayList<Bonus> getAllBonus() {

        return this.bonusList;
    }
}
