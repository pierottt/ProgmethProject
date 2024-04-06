package panes;

import Pokemon.*;
import game.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import item.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import player.*;
import utils.Goto;

public class ShopPane extends StackPane {


    public ShopPane() {
        Image bg = new Image("ShopBg.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        setBackground(background);

        // Set padding for the StackPane
        setPadding(new Insets(20)); // 20 pixels of padding from all sides
        Button btn0 = new Button("AtkPotion");
        Button btn1 = new Button("DefPotion");
        Button btn2 = new Button("HealPotion");
        Button btn3 = new Button("Pokeball");
        Button btn4 = new Button("Dragon");
        Button btn5 = new Button("Fox");
        Button btn6 = new Button("Rat");
        Button btn7 = new Button("Chicken");
        Label myMoney = new Label(GameController.getInstance().getPlayer().getMoney() + "");

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
        btnSell.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #FF5722; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, #000000, 10, 0, 0, 0);");

        btnSell.setOnMouseEntered(e -> {
            btnSell.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #FF8A65; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, #000000, 10, 0, 0, 0);");
        });

        btnSell.setOnMouseExited(e -> {
            btnSell.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #FF5722; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, #000000, 10, 0, 0, 0);");
        });

        getChildren().add(btnSell);

        Button btnExit = new Button("EXIT");

        btnExit.setTranslateX(-500);
        btnExit.setTranslateY(300);

        btnExit.setStyle("-fx-background-color: #ff0000; " +
                "-fx-text-fill: #ffffff; " +
                "-fx-font-size: 18px; " +  // Increased font size
                "-fx-font-family: Arial;");
        btnExit.setPrefWidth(100);  // Set preferred width
        btnExit.setPrefHeight(40);  // Set preferred height

// Set style for mouse entered
        btnExit.setOnMouseEntered(e -> {
            btnExit.setStyle("-fx-background-color: #ff6666; " +
                    "-fx-text-fill: #ffffff; " +
                    "-fx-font-size: 18px; " +  // Increased font size
                    "-fx-font-family: Arial;");
        });

// Set style for mouse exited
        btnExit.setOnMouseExited(e -> {
            btnExit.setStyle("-fx-background-color: #ff0000; " +
                    "-fx-text-fill: #ffffff; " +
                    "-fx-font-size: 18px; " +  // Increased font size
                    "-fx-font-family: Arial;");
        });

        btnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.mapPage();
            }
        });


        getChildren().add(btnExit);


        //button functions

        btn0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new AtkPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new DefPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new HealPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new Pokeball())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btn4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Dragon(1.5, 1.5, 1.5, 1.5))) {

                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btn5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Fox(1, 1, 1, 1))) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btn6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Rat(1, 1, 1, 1))) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btn7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Chicken(1, 1, 1, 1))) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not Enough");
                    alert.setContentText("Not Enough");
                    alert.showAndWait();
                }

            }
        });

        btnSell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.sellItemPage();
            }
        });
        ////Label
        Label name0 = new Label("AtkPoiton");
        Label name1 = new Label("DefPotion");
        Label name2 = new Label("HealPotion");
        Label name3 = new Label("Pokeball");
        Label name4 = new Label("Dragon");
        Label name5 = new Label("Fox");
        Label name6 = new Label("Rat");
        Label name7 = new Label("Chicken");

        Label[] names = {name0, name1, name2, name3, name4, name5, name6, name7};

        for (Label nameLabel : names) {
            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Setting font size to 18
        }


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
        Label price0 = new Label("500");
        Label price1 = new Label("500");
        Label price2 = new Label("500");
        Label price3 = new Label("10");
        Label price4 = new Label("1000");
        Label price5 = new Label("1000");
        Label price6 = new Label("1000");
        Label price7 = new Label("1000");

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

        for (Label priceLabel : prices) {
            priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Setting font size to 18
        }

        for (int i = 0; i < 8; i++) {
            getChildren().add(prices[i]);
        }

        myMoney.setTranslateX(455);
        myMoney.setTranslateY(300);

        myMoney.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 5px;");

        getChildren().add(myMoney);
//        getChildren().add(error);




        //Function


    }
}
