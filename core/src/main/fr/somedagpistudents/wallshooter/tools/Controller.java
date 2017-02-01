package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.screen.GameScreen;
import fr.somedagpistudents.wallshooter.world.World;
import fr.somedagpistudents.wallshooter.world.WorldRenderer;

import java.util.ArrayList;

import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_HEIGHT;
import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_WIDTH;

/**
 * Created by fjude001 on 30/01/17.
 */
public class Controller {

    String gamestate,str,t;
    WallShooter game;
    WorldRenderer worldRenderer;
    World world;

    public void setWorld(World world) {
        this.world = world;
    }

    public Controller(WallShooter game){
        this.gamestate="gameplay";
        this.game=game;



    }



    public int getPlayerScore(Player player){
        return player.getScore();
    }
    public void restartGame(){
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

        if (this.world!=null)
       return this.world.getPlayer().getScore();
        else return 0;
    }
    public int getPlayerLives() {
        if (this.world!=null)
        return this.world.getPlayer().getLives();
        else return 0;
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
