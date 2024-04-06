package utils;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import panes.*;


public class Goto {
    private static RootPane rootPane;

    public static void setRootPane(RootPane rootPane){
        Goto.rootPane = rootPane;
    }
    public static void clear(){
        rootPane.getChildren().clear();
//        if(rootPane.getChildren().size() > 1){
//            rootPane.getChildren().subList(1, rootPane.getChildren().size()).clear();
//        }
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
    public static void sellItemPage(){
        clear();
        rootPane.getChildren().add(new SellItemPane());
    }

    public static void Page(){
        clear();
        rootPane.getChildren().add(new MapPane());
    }
    public static void fightPane1(){
        clear();
        rootPane.getChildren().add(new fightPane1());
    }

}
