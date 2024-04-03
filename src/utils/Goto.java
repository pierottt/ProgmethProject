package utils;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import panes.MapPane;
import panes.RootPane;
import panes.ShopPane;
import panes.StartPane;


public class Goto {
    private static RootPane rootPane;

    public static void setRootPane(RootPane rootPane){
        Goto.rootPane = rootPane;
    }
    public static void clear(){
        if(rootPane.getChildren().size() > 1){
            rootPane.getChildren().subList(1, rootPane.getChildren().size()).clear();
        }
    }

    public static void startPage(){
        clear();
        rootPane.getChildren().add(new StartPane());
    }

    public static void mapPage(){
        clear();
        rootPane.getChildren().add(new MapPane());
    }

    public static void shopPage(){
        clear();
        rootPane.getChildren().add(new ShopPane());
    }

    public static void Page(){
        clear();
        rootPane.getChildren().add(new MapPane());
    }


}
