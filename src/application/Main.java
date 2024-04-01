package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import panes.RootPane;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        RootPane parent = RootPane.getRootPane();
        Scene scene = new Scene(parent,1200,700);

        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("MONSTARS");

        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }
}