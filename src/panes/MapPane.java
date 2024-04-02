package panes;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

        Text chicken = new Text("!");
        Text dragon = new Text("!");
        Text fox = new Text("!");
        Text pikachu = new Text("!");
        Text rat = new Text("!");

        Font font = Font.font("Arial", FontWeight.BOLD, 14);
        chicken.setFont(font);
        dragon.setFont(font);
        fox.setFont(font);
        pikachu.setFont(font);
        rat.setFont(font);

        // Set text colors
        chicken.setFill(Color.WHITE);
        dragon.setFill(Color.WHITE);
        fox.setFill(Color.WHITE);
        pikachu.setFill(Color.WHITE);
        rat.setFill(Color.WHITE);

        // Set text positions
        StackPane.setAlignment(chicken, Pos.TOP_LEFT);
        StackPane.setAlignment(dragon, Pos.TOP_RIGHT);
        StackPane.setAlignment(fox, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(pikachu, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(rat, Pos.CENTER);

        getChildren().addAll(chicken, dragon, fox, pikachu, rat);
    }
}





