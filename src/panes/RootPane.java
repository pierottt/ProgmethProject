package panes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Goto;

public class RootPane extends StackPane {
    private static RootPane instance;

    public RootPane(){
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        Goto.setRootPane(this); // Set the root pane in Goto
        Goto.fightPane1_1(); // Start with the start page
    }
    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}
