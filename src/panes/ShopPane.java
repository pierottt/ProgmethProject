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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShopPane extends StackPane {

//    ImageView name0 = createImageView("purchaseButtonOnClick.png","purchaseButton.png");

    Button btn0 = new Button("AtkPotion");
    Button btn1 = new Button("DefPotion");
    Button btn2 = new Button("Dragon");
    Button btn3 = new Button("Fox");
    Button btn4 = new Button("HealPotion");
    Button btn5 = new Button("PokeBall");
    Button btn6 = new Button("Rat");
    Button btn7 = new Button("Pikachu");

    private ImageView createImageView(String imagePath, String newImagePath) {
            Image image = new Image((imagePath));
            ImageView imageView = new ImageView(image);
            double imageSize = 200;
            imageView.setFitWidth(imageSize);
            imageView.setFitHeight(imageSize);
            // Add mouse entered event handler
            imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    // Change the image when mouse enters

                        Image newImage = new Image((newImagePath));
                        imageView.setImage(newImage);

                }
            });
        imageView.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Change the image when mouse enters

                Image newImage = new Image((imagePath));
                imageView.setImage(newImage);

            }
        });

            return imageView;
    }
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

        updateButtonDisableState();

        // Set padding for the StackPane
        setPadding(new Insets(20)); // 20 pixels of padding from all sides
        Label myMoney = new Label(GameController.getInstance().getPlayer().getMoney() + "");

        Button[] buttons = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7};
        Button btnSell = new Button("Sell Items");
        // Set preferred width and height for all buttons
        for (Button button : buttons) {
            button.setPrefWidth(200); // Set preferred width to 200 pixels
            button.setPrefHeight(50); // Set preferred height to 100 pixels
            button.setStyle(

                    "-fx-background-color: linear-gradient(#f0ff35, #a9ff00)," +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);" +
                            "-fx-background-radius: 6, 5;" +
                            "-fx-background-insets: 0, 1;" +
                            "-fx-text-fill: #395306;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;"
            );

            // Add hover effects
            button.setOnMouseEntered(e -> button.setStyle(
                    "-fx-background-color: linear-gradient(#d9ff00, #adff00)," +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);" +
                            "-fx-background-radius: 6, 5;" +
                            "-fx-background-insets: 0, 1;" +
                            "-fx-text-fill: #395306;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;"
            ));
            button.setOnMouseExited(e -> button.setStyle(
                    "-fx-background-color: linear-gradient(#f0ff35, #a9ff00)," +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);" +
                            "-fx-background-radius: 6, 5;" +
                            "-fx-background-insets: 0, 1;" +
                            "-fx-text-fill: #395306;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;"
            ));
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
        btn4.setTranslateY(-50);


        btn5.setTranslateX(-250);
        btn5.setTranslateY(-50);


        btn6.setTranslateX(250);
        btn6.setTranslateY(-50);


        btn7.setTranslateX(490);
        btn7.setTranslateY(-50);


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

//        name0.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                if (GameController.getInstance().player.buyItem(new AtkPotion())) {
//                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
//                    updateButtonDisableState();
//                }
//            }
//        });

        btn0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new AtkPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();
                }
            }
        });

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new DefPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();

                }

            }
        });

        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Dragon(1,1,1,1))) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();

                }

            }
        });

        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Fox(1,1,1,1))) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();

                }

            }
        });

        btn4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new HealPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();

                }

            }
        });

        btn5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new Pokeball())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();

                }

            }
        });

        btn6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Rat(1, 1, 1, 1))) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();

                }

            }
        });

        btn7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Pikachu(1, 1, 1, 1))) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                    updateButtonDisableState();

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
        Label name1 = new Label("DefPotion");
        Label name2 = new Label("Dragon");
        Label name3 = new Label("Fox");
        Label name4 = new Label("HealPotion");
        Label name5 = new Label("Pokeball");
        Label name6 = new Label("Rat");
        Label name7 = new Label("Pikachu");

//        Label[] names = {name0, name1, name2, name3, name4, name5, name6, name7};
//
//        for (Label nameLabel : names) {
//                nameLabel.setFont(Font.font("Impact", FontWeight.BOLD, 18));
//                nameLabel.setTextFill(Color.WHITE); // Set text color to white
//                nameLabel.setPadding(new Insets(10));
//                nameLabel.setBackground(new Background(new BackgroundFill(Color.rgb(139, 69, 19), new CornerRadii(5), Insets.EMPTY))); // Brown color
//
//        }

//        name0.setTranslateX(-490);
//        name0.setTranslateY(-200);

        name1.setTranslateX(-250);
        name1.setTranslateY(-200);

        name2.setTranslateX(250);
        name2.setTranslateY(-200);

        name3.setTranslateX(490);
        name3.setTranslateY(-200);


        name4.setTranslateX(-490);
        name4.setTranslateY(0);


        name5.setTranslateX(-250);
        name5.setTranslateY(0);


        name6.setTranslateX(250);
        name6.setTranslateY(0);


        name7.setTranslateX(490);
        name7.setTranslateY(0);


//        for (int i = 0; i < 8; i++) {
//            getChildren().add(names[i]);
//        }

        //Price
        Label price0 = new Label("500");
        Label price1 = new Label("500");
        Label price2 = new Label("1000");
        Label price3 = new Label("1000");
        Label price4 = new Label("500");
        Label price5 = new Label("10");
        Label price6 = new Label("1000");
        Label price7 = new Label("100");

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
        price4.setTranslateY(-100);


        price5.setTranslateX(-250);
        price5.setTranslateY(-100);


        price6.setTranslateX(250);
        price6.setTranslateY(-100);


        price7.setTranslateX(490);
        price7.setTranslateY(-100);

        for (Label priceLabel : prices) {
            priceLabel.setStyle("-fx-font-family: Impact; " +
                    "-fx-font-weight: bold; " +
                    "-fx-font-size: 24px; " + // Make font size bigger
                    "-fx-text-fill: brown;"); // Change text color to brown
        }

        for (int i = 0; i < 8; i++) {
            getChildren().add(prices[i]);
        }

        myMoney.setTranslateX(455);
        myMoney.setTranslateY(300);

        myMoney.setStyle("-fx-font-family: Impact; -fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 5px;");

        getChildren().add(myMoney);
//        getChildren().add(name0);

    }
    private void updateButtonDisableState() {
        btn0.setDisable(GameController.getInstance().getPlayer().getMoney()<500);
        btn1.setDisable(GameController.getInstance().getPlayer().getMoney()<500);
        btn2.setDisable(GameController.getInstance().getPlayer().getMoney()<1000);
        btn3.setDisable(GameController.getInstance().getPlayer().getMoney()<1000);
        btn4.setDisable(GameController.getInstance().getPlayer().getMoney()<500);
        btn5.setDisable(GameController.getInstance().getPlayer().getMoney()<10);
        btn6.setDisable(GameController.getInstance().getPlayer().getMoney()<1000);
        btn7.setDisable(GameController.getInstance().getPlayer().getMoney()<100);
    }
}
