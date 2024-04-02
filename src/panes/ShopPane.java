package panes;

import game.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import item.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import player.*;

public class ShopPane extends StackPane {

    private AtkPotion atkPotion;

    public ShopPane() {
        atkPotion = new AtkPotion();
        // Set padding for the StackPane
        setPadding(new Insets(20)); // 20 pixels of padding from all sides
        Text error = new Text("Don't have enough money");
        error.setFont(Font.font(50));
        error.setVisible(false);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            error.setVisible(true);
        }));
        timeline.setCycleCount(1);
        Button btn0 = new Button("AtkPotion");
        Button btn1 = new Button("Item 2");
        Button btn2 = new Button("Item 3");
        Button btn3 = new Button("Item 4");
        Button btn4 = new Button("Item 5");
        Button btn5 = new Button("Item 6");
        Button btn6 = new Button("Item 7");
        Button btn7 = new Button("Item 8");
        Label myMoney = new Label(GameController.getInstance().getPlayer().getMoney()+"");

        Button[] buttons = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7};
        Button btnSell = new Button("Sell Items");
        // Set preferred width and height for all buttons
        for (Button button : buttons) {
            button.setPrefWidth(200); // Set preferred width to 200 pixels
            button.setPrefHeight(50); // Set preferred height to 100 pixels
        }

        btn0.setTranslateX(-490);
        btn0.setTranslateY(-250);

        btn1.setTranslateX(-250);
        btn1.setTranslateY(-250);

        btn2.setTranslateX(250);
        btn2.setTranslateY(-250);

        btn3.setTranslateX(490);
        btn3.setTranslateY(-250);


        btn4.setTranslateX(-490);
        btn4.setTranslateY(-70);


        btn5.setTranslateX(-250);
        btn5.setTranslateY(-70);


        btn6.setTranslateX(250);
        btn6.setTranslateY(-70);


        btn7.setTranslateX(490);
        btn7.setTranslateY(-70);


        for (int i = 0; i < 8; i++) {
            getChildren().add(buttons[i]);
        }
        btnSell.setTranslateX(550);
        btnSell.setTranslateY(300);

        getChildren().add(btnSell);


        //button functions
        btn0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               if(GameController.getInstance().player.buyItem(new AtkPotion())){
                myMoney.setText(GameController.getInstance().getPlayer().getMoney()+"");
               }else{
                   timeline.play();
                   timeline.setOnFinished(event -> error.setVisible(false));
               }

            }
        });
        ////Label
        Label name0 = new Label("Name 1");
        Label name1 = new Label("Name 2");
        Label name2 = new Label("Name 3");
        Label name3 = new Label("Name 4");
        Label name4 = new Label("Name 5");
        Label name5 = new Label("Name 6");
        Label name6 = new Label("Name 7");
        Label name7 = new Label("Name 8");

        Label[] names = {name0, name1, name2, name3, name4, name5, name6, name7};


        name0.setTranslateX(-490);
        name0.setTranslateY(-200);

        name1.setTranslateX(-250);
        name1.setTranslateY(-200);

        name2.setTranslateX(250);
        name2.setTranslateY(-200);

        name3.setTranslateX(490);
        name3.setTranslateY(-200);


        name4.setTranslateX(-490);
        name4.setTranslateY(-20);


        name5.setTranslateX(-250);
        name5.setTranslateY(-20);


        name6.setTranslateX(250);
        name6.setTranslateY(-20);


        name7.setTranslateX(490);
        name7.setTranslateY(-20);


        for (int i = 0; i < 8; i++) {
            getChildren().add(names[i]);
        }

        //Price
        Label price0 = new Label("Price1");
        Label price1 = new Label("Price2");
        Label price2 = new Label("Price3");
        Label price3 = new Label("Price4");
        Label price4 = new Label("Price5");
        Label price5 = new Label("Price6");
        Label price6 = new Label("Price7");
        Label price7 = new Label("Price8");

        Label[] prices = {price0, price1, price2, price3, price4, price5, price6, price7};


        price0.setTranslateX(-490);
        price0.setTranslateY(-300);

        price1.setTranslateX(-250);
        price1.setTranslateY(-300);

        price2.setTranslateX(250);
        price2.setTranslateY(-300);

        price3.setTranslateX(490);
        price3.setTranslateY(-300);


        price4.setTranslateX(-490);
        price4.setTranslateY(-120);


        price5.setTranslateX(-250);
        price5.setTranslateY(-120);


        price6.setTranslateX(250);
        price6.setTranslateY(-120);


        price7.setTranslateX(490);
        price7.setTranslateY(-120);

        for (int i = 0; i < 8; i++) {
            getChildren().add(prices[i]);
        }
        getChildren().add(myMoney);
        getChildren().add(error);


        myMoney.setTranslateX(500);
        myMoney.setTranslateY(300);

        //Function


    }
//    public void setDisable() {
//        if(atkPotion.getPrice()>GameController.getInstance().player.getMoney()){
//            btn0.
//        }
//    }
}
