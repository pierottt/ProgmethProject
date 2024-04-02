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

public class StartPane extends StackPane {
    public StartPane() {
        Image bg = new Image("startpage.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        setBackground(background);

        Text txt = new Text("MONSTARS");
        txt.setFill(Color.rgb(179,179,179));
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, 90));
        txt.setStrokeWidth(5);
        txt.setStroke(Color.rgb(50,27,16));

        StackPane.setAlignment(txt, Pos.TOP_CENTER);
        StackPane.setMargin(txt, new Insets(190, 0, 0, 0));
        getChildren().add(txt);

        Button start = new Button("START");
        start.setStyle("-fx-background-color: #B3B3B3; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 24; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
        start.setOnMouseEntered(e -> start.setStyle("-fx-background-color: #737272; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-size: 24;"));
        start.setOnMouseExited(e -> start.setStyle("-fx-background-color: #B3B3B3; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-size: 24; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );"));
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("click");
                Goto.mapPage();
            }
        });
        StackPane.setAlignment(start, Pos.CENTER);
        getChildren().add(start);
    }
}
