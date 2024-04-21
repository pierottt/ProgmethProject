package game;

import player.Player;
import player.PokeDeck;

import java.util.ArrayList;

public class GameController {

    public static GameController instance = null;

    public Player player;

    public boolean isGameEnd = false;

    public boolean pikachuCheckpoint = false;
    public boolean foxCheckpoint = false;
    public boolean dragonCheckpoint = false;
    public boolean ratCheckpoint = false;
    public boolean chickenCheckpoint = false;


    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    //Constructor
    public GameController(){
        Player p=new Player("BABYNOW");
        PokeDeck pokeDeck = new PokeDeck();
        this.player=p;
    }

    //getter and setter for all fields

    public Player getPlayer(){
        return player;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        isGameEnd = gameEnd;
    }

    public boolean isPikachuCheckpoint() {
        return pikachuCheckpoint;
    }

    public void setPikachuCheckpoint(boolean pikachuCheckpoint) {
        this.pikachuCheckpoint = pikachuCheckpoint;
    }

    public boolean isFoxCheckpoint() {
        return foxCheckpoint;
    }

    public void setFoxCheckpoint(boolean foxCheckpoint) {
        this.foxCheckpoint = foxCheckpoint;
    }

    public boolean isDragonCheckpoint() {
        return dragonCheckpoint;
    }

    public void setDragonCheckpoint(boolean dragonCheckpoint) {
        this.dragonCheckpoint = dragonCheckpoint;
    }

    public boolean isRatCheckpoint() {
        return ratCheckpoint;
    }

    public void setRatCheckpoint(boolean ratCheckpoint) {
        this.ratCheckpoint = ratCheckpoint;
    }

    public boolean isChickenCheckpoint() {
        return chickenCheckpoint;
    }

    public void setChickenCheckpoint(boolean chickenCheckpoint) {
        this.chickenCheckpoint = chickenCheckpoint;
    }
}
