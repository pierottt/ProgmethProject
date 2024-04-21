package panes;

import Pokemon.*;
import game.GameController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.Goto;

public class pokemonDeckPane extends StackPane {
    ImageView currentPokemon;

    public pokemonDeckPane() {
        javafx.scene.image.Image bg = new Image("PokemonDeckPane.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        setBackground(background);
        updateCurrentPokemon();
        ImageView pikachu;
        ImageView fox;
        ImageView dragon;
        ImageView rat;
        ImageView chicken;
        if(GameController.getInstance().player.getPikachu()==0){
            pikachu= new ImageView(new Image("UnknownCircle.png"));
        }
        else{
            pikachu = new ImageView(new Image("PikachuCircle.png"));
            pikachu.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    GameController.getInstance().player.setCurrentPokemon(new Pikachu());
                    updateCurrentPokemon();
                }
            });
        }
        if(GameController.getInstance().player.getFox()==0){
            fox = new ImageView(new Image("UnknownCircle.png"));
        }
        else {
            fox = new ImageView(new Image("FoxCircle.png"));
            fox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    GameController.getInstance().player.setCurrentPokemon(new Fox());
                    updateCurrentPokemon();
                }
            });
        }
        if(GameController.getInstance().player.getDragon()==0){
            dragon = new ImageView(new Image("UnknownCircle.png"));
        }
        else {
            dragon = new ImageView(new Image("DragonCircle.png"));
            dragon.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    GameController.getInstance().player.setCurrentPokemon(new Dragon());
                    updateCurrentPokemon();
                }
            });
        }
        if(GameController.getInstance().player.getRat()==0){
            rat = new ImageView(new Image("UnknownCircle.png"));
        }
        else {
            rat = new ImageView(new Image("RatCircle.png"));
            rat.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    GameController.getInstance().player.setCurrentPokemon(new Rat());
                    updateCurrentPokemon();
                }
            });
        }
        if(GameController.getInstance().player.getChicken()==0){
            chicken = new ImageView(new Image("UnknownCircle.png"));
        }
        else {
            chicken = new ImageView(new Image("ChickenCircle.png"));
            chicken.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    GameController.getInstance().player.setCurrentPokemon(new Chicken());
                    updateCurrentPokemon();
                }
            });
        }

        ImageView[] images = {pikachu,fox,dragon,rat,chicken};
        for (ImageView imageView : images) {
            imageView.setFitWidth(140);
            imageView.setFitHeight(140);
            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.rgb(0, 0, 0, 0.6)); // Shadow color with transparency
            dropShadow.setRadius(10);
            dropShadow.setSpread(0.5);
            dropShadow.setOffsetX(4);
            dropShadow.setOffsetY(4);
            imageView.setEffect(dropShadow);
            DropShadow dropShadowOn = new DropShadow();
            dropShadowOn.setColor(Color.WHITE);
            imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> imageView.setEffect(dropShadowOn));
            imageView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> imageView.setEffect(dropShadow));
        }
        pikachu.setTranslateX(60);
        pikachu.setTranslateY(-150);
        fox.setTranslateX(280);
        fox.setTranslateY(-150);
        rat.setTranslateX(-40);
        rat.setTranslateY(50);
        dragon.setTranslateX(160);
        dragon.setTranslateY(50);
        chicken.setTranslateX(380);
        chicken.setTranslateY(50);



        getChildren().addAll(pikachu,fox,dragon,rat,chicken);

        //Go to MapPane
        Button btnExit = new Button("EXIT");
        btnExit.setTranslateX(-520);
        btnExit.setTranslateY(300);
        btnExit.setPrefWidth(70);
        btnExit.setPrefHeight(30);
        btnExit.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
        btnExit.setStyle("-fx-text-fill: white; -fx-background-color: #E62727; -fx-padding: 5px; -fx-border-radius: 5px;");

        btnExit.setOnMouseEntered(e -> {
            btnExit.setStyle("-fx-text-fill: white; -fx-background-color: #EB5D5D; -fx-padding: 5px; -fx-border-radius: 5px;");
        });

        btnExit.setOnMouseExited(e -> {
            btnExit.setStyle("-fx-text-fill: white; -fx-background-color: #E62727; -fx-padding: 5px; -fx-border-radius: 5px;");
        });

        btnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.mapPage();
            }
        });
        getChildren().add(btnExit);


    }
    private void updateCurrentPokemon() {
        getChildren().remove(currentPokemon);
        currentPokemon = GameController.getInstance().player.getCurrentPokemon().getCircleImg();
        currentPokemon.setFitWidth(120);
        currentPokemon.setFitHeight(120);
        StackPane.setAlignment(currentPokemon, Pos.TOP_LEFT);
        StackPane.setMargin(currentPokemon, new Insets(0, 0, 0, 0));
        getChildren().add(currentPokemon);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.6)); // Shadow color with transparency
        dropShadow.setRadius(10);
        dropShadow.setSpread(0.5);
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(4);
        currentPokemon.setEffect(dropShadow);
        DropShadow dropShadowOn = new DropShadow();
        dropShadowOn.setColor(Color.WHITE);
    }
}
