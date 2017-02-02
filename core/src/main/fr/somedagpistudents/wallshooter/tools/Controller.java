package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.screen.GameScreen;
import fr.somedagpistudents.wallshooter.world.World;

import java.util.ArrayList;

import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_HEIGHT;
import static fr.somedagpistudents.wallshooter.WallShooter.SCREEN_WIDTH;

/**
 * Created by fjude001 on 30/01/17.
 */
public class Controller {

    String gamestate, strGamestate;
    WallShooter game;
    World world;
    Player player;

    public void setWorld(World world) {
        this.world = world;
        player = this.world.getPlayer();
    }

    public Controller(WallShooter game){
        this.gamestate="gamestart";
        this.game=game;



    }



    public int getPlayerScore(Player player){
        return player.getScore();
    }
    public void restartGame(){
    }

    public Player getPlayer(){
        return this.player;
    }

    public void checkGameState(Player player){


        if ((player.getX()<-SCREEN_WIDTH/2))
        {
            if (player.getXSpeed()<0)
                player.setXSpeed(0);
            if ((player.getX()<-player.getWidth()-SCREEN_WIDTH/2)) {
                gamestate = "gameover";





            }
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

        if (gamestate.equals("gamestart")){
            strGamestate ="START WALLSHOOTER \n Press SPACE key to start";

        }
        if (gamestate.equals("gameplay")){
            strGamestate ="";

        }

        if (gamestate.equals("gameover")){
            strGamestate ="GAME OVER\nPRESS R.\nYou scored : "+player.getScore();
            player.stop();

        }

    return(strGamestate);


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
            if (gamestate.equals("gameplay")){
        player.setLives(player.getLives()-1);
                gamestate.equals("gameover");
            }
    }
    public void update(Player player, ArrayList<Brick> bricks) {
        for (Brick brick:bricks        ) {
            ColisionTools.contact(player,brick);
        }

        this.checkGameState(player);
        //

    }

    public void start(){

        ///BEGIN
        GameScreen gameScreen = new GameScreen(game,this);
        game.setScreen(gameScreen);
        gamestate = "gameplay";

    }

    public void restart(){

        ///GAMEOVER
        GameScreen gameScreen = new GameScreen(game,this);
        game.setScreen(gameScreen);
        gamestate = "gameplay";

    }


    public void startTuto() {
        ///GAMEOVER
        GameScreen gameScreen = new GameScreen(game,this);
        game.setScreen(gameScreen);
        gamestate = "tuto";

    }
}
