package panes;

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

        ImageView chickenView = createImageView("LocationGreen.png");
        ImageView dragonView = createImageView("LocationGreen.png");
        ImageView foxView = createImageView("LocationGreen.png");
        ImageView pikachuView = createImageView("LocationGreen.png");
        ImageView ratView = createImageView("LocationGreen.png");
        ImageView homeView = createImageView("LocationGreen.png");

        // Set image positions
        StackPane.setAlignment(chickenView, Pos.TOP_CENTER);
        StackPane.setMargin(chickenView, new Insets(190, 210, 0, 0));
        StackPane.setAlignment(foxView, Pos.TOP_RIGHT);
        StackPane.setMargin(foxView, new Insets(210, 300, 0, 0));
        StackPane.setAlignment(dragonView, Pos.CENTER_LEFT);
        StackPane.setMargin(dragonView, new Insets(0, 0, 100, 300));
        StackPane.setAlignment(pikachuView, Pos.BOTTOM_LEFT);
        StackPane.setMargin(pikachuView, new Insets(0, 0, 200, 350));
        StackPane.setAlignment(ratView, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(ratView, new Insets(0, 250, 200, 0));
        StackPane.setAlignment(homeView, Pos.CENTER);
        StackPane.setMargin(homeView, new Insets(0, 60, 0, 0));

        getChildren().addAll(chickenView, dragonView, foxView, pikachuView, ratView, homeView);
    }

    private ImageView createImageView(String imagePath) {
        ImageView imageView = new ImageView(new Image(imagePath));
        double imageSize = 60;
        imageView.setFitWidth(imageSize);
        imageView.setFitHeight(imageSize);
        // Add drop shadow effect to images
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.6)); // Shadow color with transparency
        dropShadow.setRadius(10); // Blur radius
        dropShadow.setSpread(0.5); // Shadow spread
        dropShadow.setOffsetX(4); // Horizontal shadow offset
        dropShadow.setOffsetY(4); // Vertical shadow offset
        imageView.setEffect(dropShadow);
        DropShadow dropShadowOn = new DropShadow();
        dropShadowOn.setColor(Color.WHITE);
        // Apply drop shadow effect on mouse hover
        imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> imageView.setEffect(dropShadowOn));

        // Remove drop shadow effect on mouse exit
        imageView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> imageView.setEffect(dropShadow));

        return imageView;
    }
}





