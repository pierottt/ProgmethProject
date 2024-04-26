package game;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import player.Player;
import player.PokeDeck;
import utils.Goto;
import utils.SoundManager;

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

    public void endBattle(ImageView pokemon, ImageView grave) {
        FadeTransition fadeOutPokemonTransition = new FadeTransition(Duration.millis(3000), pokemon);

        // Set the initial and final opacity values for the fade animation
        fadeOutPokemonTransition.setFromValue(1.0);
        fadeOutPokemonTransition.setToValue(0.0);

        // Set what happens after the animation ends
        fadeOutPokemonTransition.setOnFinished(event -> {
            // Animation ended, hide the Pokemon ImageView after fading out
            pokemon.setVisible(false);

            // Create fade in transition for the grave ImageView
            FadeTransition fadeInGraveTransition = new FadeTransition(Duration.millis(1000), grave);
            // Set the initial and final opacity values for the fade animation
            fadeInGraveTransition.setFromValue(0.0);
            fadeInGraveTransition.setToValue(1.0);
            // Make the grave ImageView visible
            grave.setVisible(true);
            // Start the fade in animation for the grave ImageView
            fadeInGraveTransition.play();
        });

        // Start the fade out animation for the Pokemon ImageView
        fadeOutPokemonTransition.play();
    }


}
