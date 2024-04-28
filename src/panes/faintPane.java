package panes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import utils.Goto;

public class faintPane extends StackPane {
    public faintPane(){
        Image bg = new Image("Faint.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        setBackground(background);

        Button goBack = new Button("Go to World Map");
        goBack.setStyle("-fx-background-color: #B3B3B3; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 24; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
        goBack.setOnMouseEntered(e -> goBack.setStyle("-fx-background-color: #737272; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-size: 24;"));
        goBack.setOnMouseExited(e -> goBack.setStyle("-fx-background-color: #B3B3B3; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-size: 24; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );"));
        goBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("click");
                Goto.mapPage();
            }
        });
        goBack.setTranslateX(450);
        goBack.setTranslateY(300);
        getChildren().add(goBack);
    }

}
