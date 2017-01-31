package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.entity.Brick;
import fr.somedagpistudents.wallshooter.entity.Player;

/**
 * Created by fjude001 on 30/01/17.
 */
public class Controller {
    String gamestate,str,t;



    public Controller(){
        this.gamestate="gamestart";
    }


    public void checkGameState(Player player,Brick brick){



        if (ColisionTools.contact(player,brick)==true){
            gamestate="gameover";
            this.displayGameStateText();

        }


    }
    public void displayGameStateText(){

///à utiliser avec draw.text ?
        if (gamestate=="gamestart"){
            str="WALLSHOOTER \n Press start";

        }
        if (gamestate=="gameover"){
            str="You Died.";}

    System.out.print(str);

    }



}
