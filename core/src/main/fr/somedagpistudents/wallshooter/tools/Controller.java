package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.world.World;

import java.util.ArrayList;

import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_HEIGHT;
import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_WIDTH;

/**
 * Created by fjude001 on 30/01/17.
 */
public class Controller {
    private final World world;
    String gamestate,str,t;



    public Controller(World world){
        this.gamestate="gameplay";
        this.world=world;
    }

    public int getPlayerScore(Player player){
        return player.getScore();


    }
    public void checkGameState(Player player){


        if ((player.getX()<-SCREEN_WIDTH/2))
        {
            if (player.getXSpeed()<0)
                player.setXSpeed(0);
            if ((player.getX()<-player.getWidth()-SCREEN_WIDTH/2))
            gamestate="gameover";
        }
        if ((player.getX()>SCREEN_WIDTH/2-player.getWidth()))
        {
            if (player.getXSpeed()>0)
                player.setXSpeed(0);
        }
        if ((player.getY()>SCREEN_HEIGHT/2-player.getHeight()))
        {
            if (player.getYSpeed()>0)
                player.setYSpeed(0);
        }
        if ((player.getY()<-SCREEN_HEIGHT/2))
        {
            if (player.getYSpeed()<0)
                player.setYSpeed(0);
        }


    }
    public String displayGameStateText(){

        if (gamestate=="gamestart"){
            str="WALLSHOOTER \n Press start";

        }
        if (gamestate=="gameplay"){
            str="WALLSHOOTER \n Press start";

        }

        if (gamestate=="gameover"){
            str="You Died.";
        }

    return(str);


    }


    public String getGamestate() {
        return this.gamestate;
    }

    public int getPlayerScore() {
       return this.world.getPlayer().getScore();
    }
    public int getPlayerLives() {
        return this.world.getPlayer().getLives();
    }

    public void decreaseLife(Player player ){
            if (gamestate=="gameplay"){
        player.setLives(player.getLives()-1);
                gamestate="gameover";
            }
    }
    public void update(Player player, ArrayList<Brick> bricks) {
        for (Brick brick:bricks        ) {
            ColisionTools.contact(player,brick);
        }

        this.checkGameState(player);
        //

    }
}
