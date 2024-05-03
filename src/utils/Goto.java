package utils;

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
        SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
        rootPane.getChildren().add(new StartPane());
    }

    public  static  void gotchaPage(){
        clear();
        rootPane.getChildren().add(new gotchaPane());
    }

    public static void mapPage(){
        clear();
        SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
        rootPane.getChildren().add(new MapPane());
    }
    public static  void victoryPage(){
        clear();
        rootPane.getChildren().add(new victoryPane());
    }

    public static void shopPage(){
        clear();
        rootPane.getChildren().add(new ShopPane());
    }
    public static void sellItemPage(){
        clear();
        rootPane.getChildren().add(new SellItemPane());
    }

    public static void bossPane(){
        clear();
        SoundManager.getInstance().changeSound("res/fighting.mp3");
        rootPane.getChildren().add(new BossPane());
    }
    public static void fightPane1_1(){
        clear();
        SoundManager.getInstance().changeSound("res/fighting.mp3");
        rootPane.getChildren().add(new fightPane1_1());
    }
    public static void fightPane1_2(){
        clear();
        SoundManager.getInstance().changeSound("res/fighting.mp3");
        rootPane.getChildren().add(new fightPane1_2());
    }
    public static void fightPane1_3(){
        clear();
        SoundManager.getInstance().changeSound("res/fighting.mp3");
        rootPane.getChildren().add(new fightPane1_3());
    }
    public static void fightPane1_4(){
        clear();
        SoundManager.getInstance().changeSound("res/fighting.mp3");
        rootPane.getChildren().add(new fightPane1_4());
    }
    public static void pokemonDeck(){
        clear();
        rootPane.getChildren().add(new pokemonDeckPane());
    }
    public static void faintPane(){
        clear();
        rootPane.getChildren().add(new faintPane());
    }


}
