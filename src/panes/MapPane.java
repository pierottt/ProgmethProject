package panes;

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
import javafx.scene.text.Text;
import utils.Goto;
import utils.SoundManager;

public class MapPane extends StackPane {
    public MapPane(){
        Image bg = new Image("home.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        setBackground(background);

        ImageView chickenView;
        ImageView dragonView;
        ImageView foxView;
        ImageView pikachuView;
        ImageView ratView;
        if(GameController.getInstance().chickenCheckpoint){
            chickenView = createImageView("LocationGreen.png");
        }
        else {
            chickenView = createImageView("LocationBlue.png");
        }
        chickenView.setVisible(false);
        if(GameController.getInstance().pikachuCheckpoint && GameController.getInstance().foxCheckpoint && GameController.getInstance().dragonCheckpoint && GameController.getInstance().ratCheckpoint) {
            chickenView.setVisible(true);
        }

        if(GameController.getInstance().dragonCheckpoint){
            dragonView = createImageView("LocationGreen.png");
        }
        else {
            dragonView = createImageView("LocationBlue.png");
        }
        if(GameController.getInstance().foxCheckpoint){
            foxView = createImageView("LocationGreen.png");
        }
        else {
            foxView = createImageView("LocationBlue.png");
        }
        if(GameController.getInstance().pikachuCheckpoint){
            pikachuView = createImageView("LocationGreen.png");
        }
        else {
            pikachuView = createImageView("LocationBlue.png");
        }
        if(GameController.getInstance().ratCheckpoint){
            ratView = createImageView("LocationGreen.png");
        }
        else {
            ratView = createImageView("LocationBlue.png");
        }
        ImageView homeView = createImageView("LocationHome.png");


        ImageView chickenPopup = createImageViewPopup("ChickenCircle.png");
        chickenPopup.setVisible(false);
        chickenView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> chickenPopup.setVisible(true));
        chickenView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> chickenPopup.setVisible(false));
        ImageView dragonPopup = createImageViewPopup("DragonCircle.png");
        dragonPopup.setVisible(false);
        dragonView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dragonPopup.setVisible(true));
        dragonView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dragonPopup.setVisible(false));
        ImageView foxPopup = createImageViewPopup("FoxCircle.png");
        foxPopup.setVisible(false);
        foxView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> foxPopup.setVisible(true));
        foxView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> foxPopup.setVisible(false));
        ImageView pikachuPopup = createImageViewPopup("PikachuCircle.png");
        pikachuPopup.setVisible(false);
        pikachuView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> pikachuPopup.setVisible(true));
        pikachuView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> pikachuPopup.setVisible(false));
        ImageView ratPopup = createImageViewPopup("RatCircle.png");
        ratPopup.setVisible(false);
        ratView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> ratPopup.setVisible(true));
        ratView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> ratPopup.setVisible(false));


        homeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.shopPage();
            }
        });

        chickenView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SoundManager.getInstance().changeSound("res/fighting.mp3");
                Goto.bossPane();
            }
        });
        pikachuView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SoundManager.getInstance().changeSound("res/fighting.mp3");
                Goto.fightPane1_1();
            }
        });
        foxView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SoundManager.getInstance().changeSound("res/fighting.mp3");
                Goto.fightPane1_2();
            }
        });
        dragonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SoundManager.getInstance().changeSound("res/fighting.mp3");
                Goto.fightPane1_3();
            }
        });
        ratView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SoundManager.getInstance().changeSound("res/fighting.mp3");
                Goto.fightPane1_4();
            }
        });

        // Set image positions
        StackPane.setAlignment(chickenView, Pos.TOP_CENTER);
        StackPane.setMargin(chickenView, new Insets(190, 210, 0, 0));
        StackPane.setAlignment(chickenPopup, Pos.TOP_CENTER);
        StackPane.setMargin(chickenPopup, new Insets(190, 110, 0, 0));

        StackPane.setAlignment(foxView, Pos.TOP_RIGHT);
        StackPane.setMargin(foxView, new Insets(210, 300, 0, 0));
        StackPane.setAlignment(foxPopup, Pos.TOP_RIGHT);
        StackPane.setMargin(foxPopup, new Insets(210, 250, 0, 0));

        StackPane.setAlignment(dragonView, Pos.CENTER_LEFT);
        StackPane.setMargin(dragonView, new Insets(0, 0, 100, 300));
        StackPane.setAlignment(dragonPopup, Pos.CENTER_LEFT);
        StackPane.setMargin(dragonPopup, new Insets(0, 0, 100, 350));

        StackPane.setAlignment(pikachuView, Pos.BOTTOM_LEFT);
        StackPane.setMargin(pikachuView, new Insets(0, 0, 200, 350));
        StackPane.setAlignment(pikachuPopup, Pos.BOTTOM_LEFT);
        StackPane.setMargin(pikachuPopup, new Insets(0, 0, 200, 400));

        StackPane.setAlignment(ratView, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(ratView, new Insets(0, 250, 200, 0));
        StackPane.setAlignment(ratPopup, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(ratPopup, new Insets(0, 200, 200, 0));

        StackPane.setAlignment(homeView, Pos.CENTER);
        StackPane.setMargin(homeView, new Insets(0, 60, 0, 0));

        getChildren().addAll(chickenView, dragonView, foxView, pikachuView, ratView, homeView);
        getChildren().addAll(chickenPopup, dragonPopup, foxPopup, pikachuPopup, ratPopup);

        ImageView currentPokemon = GameController.getInstance().player.getCurrentPokemon().getCircleImg();
        currentPokemon.setFitWidth(120);
        currentPokemon.setFitHeight(120);
        StackPane.setAlignment(currentPokemon, Pos.BOTTOM_LEFT);
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
        currentPokemon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> currentPokemon.setEffect(dropShadowOn));
        currentPokemon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> currentPokemon.setEffect(dropShadow));
        currentPokemon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.pokemonDeck();
            }
        });
    }

    private ImageView createImageView(String imagePath) {
        ImageView imageView = new ImageView(new Image(imagePath));
        double imageSize = 60;
        imageView.setFitWidth(imageSize);
        imageView.setFitHeight(imageSize);
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
        return imageView;
    }
    private ImageView createImageViewPopup(String imagePath) {
        ImageView imageView = new ImageView(new Image(imagePath));
        double imageSize = 60;
        imageView.setFitWidth(imageSize);
        imageView.setFitHeight(imageSize);
        return imageView;
    }
}





