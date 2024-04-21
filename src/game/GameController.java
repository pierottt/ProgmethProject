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
    public GameController(){
        Player p=new Player("BABYNOW");
        PokeDeck pokeDeck = new PokeDeck();
        this.player=p;
    }

    public Player getPlayer(){
        return player;
    }

}
