package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.world.World;

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
    public void checkGameState(Player player, Brick brick){

        if (ColisionTools.contact(player,brick)==true){
            if (gamestate=="gameplay"){
                player.setLives(player.getLives()-1);}

            gamestate="gameover";
            this.displayGameStateText();

        }



    }
    public String displayGameStateText(){

///à utiliser avec draw.text ?
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
}
