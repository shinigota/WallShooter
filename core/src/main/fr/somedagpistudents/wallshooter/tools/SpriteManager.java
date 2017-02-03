package fr.somedagpistudents.wallshooter.tools;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import fr.somedagpistudents.wallshooter.entity.Entity;
import fr.somedagpistudents.wallshooter.entity.bonus.Bonus;
import fr.somedagpistudents.wallshooter.entity.player.HorizontalMovement;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.entity.weapon.Bullet;

import java.util.HashMap;

/**
 * Created by benjamin on 2/2/17.
 */
public class SpriteManager {

    private final SpriteBatch spriteBatch;
    private final TextureAtlas bricksAtlas;
    private final HashMap<String, Sprite> sprites;

    public SpriteManager(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        this.bricksAtlas = new TextureAtlas("sprites.txt");
        this.sprites = new HashMap<String, Sprite>();

        this.loadSprites();
    }

    private void loadSprites() {
        loadSprite(SpriteType.PLAYER);
        loadSprite(SpriteType.PLAYER_FORWARD);
        loadSprite(SpriteType.PLAYER_BACKWARD);
        loadSprite(SpriteType.BRICK_RED);
        loadSprite(SpriteType.BRICK_ORANGE);
        loadSprite(SpriteType.BRICK_GREEN);
        loadSprite(SpriteType.BULLET);
    }

    private void loadSprite(String spriteType) {
        this.sprites.put(spriteType, this.bricksAtlas.createSprite(spriteType));
    }

    public void drawPlayer(Player player) {
        HorizontalMovement playerMovement = player.getHorizontalMovement();
        Sprite playerSprite;

        if (playerMovement == HorizontalMovement.BACKWARD)
            playerSprite = this.get(SpriteType.PLAYER_BACKWARD);
        else if (playerMovement == HorizontalMovement.FORWARD)
            playerSprite = this.get(SpriteType.PLAYER_FORWARD);
        else
            playerSprite = this.get(SpriteType.PLAYER);

        this.spriteToEntityBounds(playerSprite, player);
        playerSprite.draw(this.spriteBatch);
    }

    public void drawBrick(Brick brick) {
        Sprite brickSprite;

        float brickLife = brick.getLife();
        if (brickLife <= 3){
            brickSprite = this.get(SpriteType.BRICK_RED);
        }
        else if (brickLife > 3 && brickLife <= 6){
            brickSprite = this.get(SpriteType.BRICK_ORANGE);
        }
        else {
            brickSprite = this.get(SpriteType.BRICK_GREEN);
        }

        this.spriteToEntityBounds(brickSprite, brick);
        brickSprite.draw(this.spriteBatch);
    }


    public void drawBonus(Bonus bonus) {
        Sprite brickSprite;


            brickSprite = this.get(SpriteType.BRICK_RED);

        brickSprite.draw(this.spriteBatch);
    }
    

    public void drawBullet(Bullet bullet) {
        Sprite bulletSprite = this.get(SpriteType.BULLET);

        bulletSprite.setBounds(bullet.getX() - bullet.getWidth(), bullet.getY(), bullet.getWidth() * 2, bullet.getHeight());
        bulletSprite.draw(this.spriteBatch);
    }

    private Sprite get(String spriteType) {
        return this.sprites.get(spriteType);
    }

    private void spriteToEntityBounds(Sprite sprite, Entity entity) {
        sprite.setBounds(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
    }

    public void dispose() {
        this.bricksAtlas.dispose();
    }
}

