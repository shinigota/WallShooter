package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.WallShooter;
import fr.somedagpistudents.wallshooter.entity.player.Player;
import fr.somedagpistudents.wallshooter.entity.wall.Brick;
import fr.somedagpistudents.wallshooter.screen.GameScreen;
import fr.somedagpistudents.wallshooter.world.World;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
    Timer time;
    int t=0;
    float gameMoney;
    boolean moneyUpdated;

    public void setWorld(World world) {
        this.world = world;
        player = this.world.getPlayer();
    }

    public Controller(WallShooter game){
        this.gamestate="gamestart";
        this.game=game;
        this.moneyUpdated = false;
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
                updateGameMoney();
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
        if (gamestate.equals("tuto")){
            int trig=Math.round(t/4);
            ArrayList<String> strTuto = new ArrayList<String>();
            strTuto.add("Welcome to Wallshooter's tutorial : ");
            strTuto.add("Press Q to move left, d to move right,z to move up and s to move down.");
            strTuto.add("Avoid walls that will push you to the bottom, and fire with SPACE key");
            strTuto.add("Don't shoot blindly, or your weapon may heat");
            strTuto.add("Bricks will gets harder and harder to avoid");
            strTuto.add("If you get stuck on the left you'll die");
            strTuto.add("Good luck, you'll need it !");

            //sets the tutorial's text or else starts the game as it ends
            
            if (trig>strTuto.size()-1) start();
                else
            strGamestate =strTuto.get(trig);


        }


        if (gamestate=="gameover"){
            strGamestate ="GAME OVER\nPRESS R to Restart.\nYou scored : "+player.getScore();
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

    public void updateGameMoney(){
        if(!this.moneyUpdated){
            this.gameMoney = player.getMoney();
            System.out.println(this.gameMoney);
            this.moneyUpdated = true;
        }

    }

    public void update(Player player, ArrayList<Brick> bricks) {
        for (Brick brick:bricks        ) {
            //ColisionTools.contact(player,brick);
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
        player.setMoney(this.gameMoney);

    }


    public void startTuto() {

        ///GAMEOVER
        GameScreen gameScreen = new GameScreen(game,this);
        game.setScreen(gameScreen);

        gamestate = "tuto";
        createTimer();

    }
    public void createTimer(){
        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {

                    createTimer();
                    t++;

            }
        },1000);
    }
}
