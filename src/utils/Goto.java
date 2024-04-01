package utils;

import panes.RootPane;

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

}
