package panes;

import Pokemon.*;
import game.GameController;
import item.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Goto;

import java.awt.*;

public class SellItemPane extends StackPane {
    Button btn0 = new Button("AtkPotion");
    Button btn1 = new Button("DefPotion");
    Button btn2 = new Button("Dragon");
    Button btn3 = new Button("Fox");
    Button btn4 = new Button("HealPotion");
    Button btn5 = new Button("PokeBall");
    Button btn6 = new Button("Rat");
    Button btn7 = new Button("Pikachu");

    public SellItemPane(){

        Label myMoney = new Label(GameController.getInstance().getPlayer().getMoney() + "");
        javafx.scene.image.Image bg = new Image("ShopBg.png");
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
        Button[] buttons = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7};
        Label amount0 = new Label(GameController.getInstance().getPlayer().getAtkPotion() + "");
        Label amount1 = new Label(GameController.getInstance().getPlayer().getDefPotion() + "");
        Label amount2 = new Label(GameController.getInstance().getPlayer().getDragon() + "");
        Label amount3 = new Label(GameController.getInstance().getPlayer().getFox() + "");
        Label amount4 = new Label(GameController.getInstance().getPlayer().getHealPotion() + "");
        Label amount5 = new Label(GameController.getInstance().getPlayer().getPokeBall() + "");
        Label amount6 = new Label(GameController.getInstance().getPlayer().getRat() + "");
        Label amount7 = new Label(GameController.getInstance().getPlayer().getPikachu() + "");

        Label[] amounts = {amount0, amount1, amount2, amount3, amount4, amount5, amount6, amount7};

        for (Label nameLabel : amounts) {
            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            nameLabel.setTextFill(Color.WHITE); // Set text color to white
            nameLabel.setPadding(new Insets(10));
            nameLabel.setBackground(new Background(new BackgroundFill(Color.rgb(139, 69, 19), new CornerRadii(5), Insets.EMPTY))); // Brown color
        }

        amount0.setTranslateX(-490);
        amount0.setTranslateY(-200);

        amount1.setTranslateX(-250);
        amount1.setTranslateY(-200);

        amount2.setTranslateX(250);
        amount2.setTranslateY(-200);

        amount3.setTranslateX(490);
        amount3.setTranslateY(-200);

        amount4.setTranslateX(-490);
        amount4.setTranslateY(0);

        amount5.setTranslateX(-250);
        amount5.setTranslateY(0);

        amount6.setTranslateX(250);
        amount6.setTranslateY(0);

        amount7.setTranslateX(490);
        amount7.setTranslateY(0);

        for (int i = 0; i < 8; i++) {
            getChildren().add(amounts[i]);
        }


        // Set preferred width and height for all buttons
        for (Button button : buttons) {
            button.setPrefWidth(200); // Set preferred width to 200 pixels
            button.setPrefHeight(50);
            button.setStyle(
                    "-fx-background-color: linear-gradient(#f0ff35, #a9ff00)," +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);" +
                            "-fx-background-radius: 6, 5;" +
                            "-fx-background-insets: 0, 1;" +
                            "-fx-text-fill: #395306;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;"
            );// Set preferred height to 100 pixels
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


        btn0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new AtkPotion());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setAtkPotion(GameController.getInstance().getPlayer().getAtkPotion()-1);
                amount0.setText(GameController.getInstance().getPlayer().getAtkPotion()+"");
                updateButtonDisableState();
            }
        });

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new DefPotion());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setDefPotion(GameController.getInstance().getPlayer().getDefPotion()-1);
                amount1.setText(GameController.getInstance().getPlayer().getDefPotion()+"");
                updateButtonDisableState();
            }
        });

        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Dragon(1,1,1,1));
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setDragon(GameController.getInstance().getPlayer().getDragon()-1);
                amount2.setText(GameController.getInstance().getPlayer().getDragon()+"");
                updateButtonDisableState();
            }
        });

        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Fox());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setFox(GameController.getInstance().getPlayer().getFox()-1);
                amount3.setText(GameController.getInstance().getPlayer().getFox()+"");
                updateButtonDisableState();
            }
        });

        btn4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new HealPotion());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setHealPotion(GameController.getInstance().getPlayer().getHealPotion()-1);
                amount4.setText(GameController.getInstance().getPlayer().getHealPotion()+"");
                updateButtonDisableState();

            }
        });

        btn5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new Pokeball());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setPokeBall(GameController.getInstance().getPlayer().getPokeBall()-1);
                amount5.setText(GameController.getInstance().getPlayer().getPokeBall()+"");
                updateButtonDisableState();
            }
        });

        btn6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Rat());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setRat(GameController.getInstance().getPlayer().getRat()-1);
                amount6.setText(GameController.getInstance().getPlayer().getRat()+"");
                updateButtonDisableState();
            }
        });

        btn7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Pikachu(1,1,1,1));
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");
                GameController.getInstance().getPlayer().setPikachu(GameController.getInstance().getPlayer().getPikachu()-1);
                amount7.setText(GameController.getInstance().getPlayer().getPikachu()+"");
                updateButtonDisableState();

            }
        });



        Button btnBuy = new Button("Buy Items");
        btnBuy.setTranslateX(550);
        btnBuy.setTranslateY(300);
        btnBuy.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #FF5722; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, #000000, 10, 0, 0, 0);");

        btnBuy.setOnMouseEntered(e -> {
            btnBuy.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #FF8A65; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, #000000, 10, 0, 0, 0);");
        });

        btnBuy.setOnMouseExited(e -> {
            btnBuy.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #FF5722; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, #000000, 10, 0, 0, 0);");
        });

        btnBuy.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.shopPage();
            }
        });

        myMoney.setTranslateX(455);
        myMoney.setTranslateY(300);

        myMoney.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 5px;");
        getChildren().add(myMoney);
        getChildren().add(btnBuy);



        //Price
        Label price0 = new Label("250");
        Label price1 = new Label("250");
        Label price2 = new Label("500");
        Label price3 = new Label("500");
        Label price4 = new Label("250");
        Label price5 = new Label("5");
        Label price6 = new Label("500");
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
            priceLabel.setStyle("-fx-font-family: Arial; " +
                    "-fx-font-weight: bold; " +
                    "-fx-font-size: 18px;");
        }

        for (int i = 0; i < 8; i++) {
            getChildren().add(prices[i]);
        }

    }
    private void updateButtonDisableState() {
        btn0.setDisable(GameController.getInstance().getPlayer().getAtkPotion() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1);
        btn1.setDisable(GameController.getInstance().getPlayer().getDefPotion() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1);
        btn2.setDisable(GameController.getInstance().getPlayer().getDragon() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Dragon(1,1,1,1)));
        btn3.setDisable(GameController.getInstance().getPlayer().getFox() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Fox()));
        btn4.setDisable(GameController.getInstance().getPlayer().getHealPotion() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 );
        btn5.setDisable(GameController.getInstance().getPlayer().getPokeBall() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1);
        btn6.setDisable(GameController.getInstance().getPlayer().getRat() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Rat()));
        btn7.setDisable(GameController.getInstance().getPlayer().getPikachu() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Pikachu(1,1,1,1)));
    }

}
