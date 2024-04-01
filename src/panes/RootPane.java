package panes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import utils.Goto;

public class RootPane extends StackPane {
    private static RootPane instance;

    public RootPane(){
        setBackground(Background.fill(Color.WHITE));
        Text t = new Text("This is root Pane");
        setAlignment(t, Pos.TOP_CENTER);
        getChildren().add(t);
        Goto.setRootPane(this);
        Button b = new Button();
        b.setText("go to map");
//        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                Goto.mapScene();
//            }
//        });
//        getChildren().add(b);
    }
    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}
