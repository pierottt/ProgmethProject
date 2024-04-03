package game;

import player.Player;

import java.util.ArrayList;

public class GameController {

    public static GameController instance = null;

    public Player player;

    public boolean isGameEnd = false;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    public GameController(){
        Player p=new Player("BABYNOW");
        this.player=p;
    }
    public Player getPlayer(){
        return player;
    }
}
