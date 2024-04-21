package panes;

import Pokemon.*;
import game.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class ShopPane extends StackPane {
    Button buyAtkBtn = new Button("BUY");
    Button buyDefBtn = new Button("BUY");
    Button buyHealBtn = new Button("BUY");
    Button buyPokeballBtn = new Button("BUY");
    Button buyDragonBtn = new Button("BUY");
    Button buyFoxBtn = new Button("BUY");
    Button buyRatBtn = new Button("BUY");
    Button buyPikachuBtn = new Button("BUY");

    public ShopPane() {
        Label BuyItem = new Label("Buy Items");
        BuyItem.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 25));
        BuyItem.setStyle("-fx-text-fill: white; -fx-background-color: #7C3014; -fx-padding: 5px;");
        BuyItem.setPrefWidth(300);
        BuyItem.setPrefHeight(20);
        BuyItem.setAlignment(Pos.CENTER);
        BuyItem.setTranslateY(-320);
        getChildren().add(BuyItem);

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
        updateButtonDisableState();
        // ImageView add picture
        ImageView atkPotionImage = new ImageView(new Image("Attack.png"));
        ImageView defPotionImage = new ImageView(new Image("Defense.png"));
        ImageView healPotionImage = new ImageView(new Image("Heal.png"));
        ImageView pokeballImage = new ImageView(new Image("pokeball.png"));
        ImageView dragonImage = new ImageView(new Image("DragonCircle.png"));
        ImageView foxImage = new ImageView(new Image("FoxCircle.png"));
        ImageView ratImage = new ImageView(new Image("RatCircle.png"));
        ImageView pikachuImage = new ImageView(new Image("PikachuCircle.png"));
        ImageView[] images = {atkPotionImage, defPotionImage, healPotionImage, pokeballImage, dragonImage, foxImage, ratImage, pikachuImage};
        for (ImageView imageView : images) {
            if(imageView == atkPotionImage || imageView==defPotionImage || imageView==healPotionImage){
                imageView.setFitWidth(160);
                imageView.setFitHeight(160);
            }
            else {
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
            }
        }
        atkPotionImage.setTranslateX(-490);
        atkPotionImage.setTranslateY(-205);
        defPotionImage.setTranslateX(-250);
        defPotionImage.setTranslateY(-205);
        healPotionImage.setTranslateX(-490);
        healPotionImage.setTranslateY(30);
        pokeballImage.setTranslateX(-250);
        pokeballImage.setTranslateY(35);
        pikachuImage.setTranslateX(250);
        pikachuImage.setTranslateY(-200);
        dragonImage.setTranslateX(490);
        dragonImage.setTranslateY(-200);
        foxImage.setTranslateX(250);
        foxImage.setTranslateY(35);
        ratImage.setTranslateX(490);
        ratImage.setTranslateY(35);
        for (int i = 0; i < 8; i++) {
            getChildren().add(images[i]);
        }


        Label myMoney = new Label(GameController.getInstance().getPlayer().getMoney() + "$");

        Button[] buttons = {buyAtkBtn, buyDefBtn, buyHealBtn, buyPokeballBtn, buyDragonBtn, buyFoxBtn, buyRatBtn, buyPikachuBtn};

        for (Button button : buttons) {
            button.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
            button.setPrefWidth(70);
            button.setPrefHeight(30);
            button.setStyle(" -fx-background-color: #20CD27; -fx-padding: 5px; -fx-text-fill: white;");
        }

        buyAtkBtn.setTranslateX(-490);
        buyAtkBtn.setTranslateY(-200);

        buyDefBtn.setTranslateX(-250);
        buyDefBtn.setTranslateY(-200);

        buyHealBtn.setTranslateX(-490);
        buyHealBtn.setTranslateY(30);

        buyPokeballBtn.setTranslateX(-250);
        buyPokeballBtn.setTranslateY(30);

        buyPikachuBtn.setTranslateX(250);
        buyPikachuBtn.setTranslateY(-200);

        buyDragonBtn.setTranslateX(490);
        buyDragonBtn.setTranslateY(-200);

        buyFoxBtn.setTranslateX(250);
        buyFoxBtn.setTranslateY(30);

        buyRatBtn.setTranslateX(490);
        buyRatBtn.setTranslateY(30);

        for (int i = 0; i < 8; i++) {
            getChildren().add(buttons[i]);
            buttons[i].setVisible(false); // Initially hide the button
            buttons[i].setTranslateZ(20);
            int finalI = i;
            images[i].setOnMouseEntered(e -> buttons[finalI].setVisible(true));
            images[i].setOnMouseExited(e -> buttons[finalI].setVisible(false));
            buttons[i].setOnMouseEntered(e -> buttons[finalI].setVisible(true));
            buttons[i].setOnMouseExited(e -> buttons[finalI].setVisible(false));
        }
        //show myMoney
        myMoney.setTranslateX(370);
        myMoney.setTranslateY(300);
        myMoney.setPrefHeight(30);
        myMoney.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
        myMoney.setStyle("-fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 5px; -fx-border-width: 2px; -fx-border-radius: 5px;");

        getChildren().add(myMoney);

        //Go to SellItemPane
        Button btnSell = new Button("Sell Items");

        btnSell.setTranslateX(520);
        btnSell.setTranslateY(300);
        btnSell.setPrefWidth(120);
        btnSell.setPrefHeight(30);
        btnSell.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
        btnSell.setStyle("-fx-text-fill: white; -fx-background-color: #2C8FDC; -fx-padding: 5px; -fx-border-radius: 5px;");

        btnSell.setOnMouseEntered(e -> {
            btnSell.setStyle("-fx-text-fill: white; -fx-background-color: #509DDA; -fx-padding: 5px; -fx-border-radius: 5px;");
        });

        btnSell.setOnMouseExited(e -> {
            btnSell.setStyle("-fx-text-fill: white; -fx-background-color: #2C8FDC; -fx-padding: 5px; -fx-border-radius: 5px;");
        });

        getChildren().add(btnSell);

        //Go to MapPane
        Button btnExit = new Button("EXIT");
        btnExit.setTranslateX(-520);
        btnExit.setTranslateY(300);
        btnExit.setPrefWidth(70);
        btnExit.setPrefHeight(30);
        btnExit.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
        btnExit.setStyle("-fx-text-fill: white; -fx-background-color: #E62727; -fx-padding: 5px; -fx-border-radius: 5px;");

        btnExit.setOnMouseEntered(e -> {
            btnExit.setStyle("-fx-text-fill: white; -fx-background-color: #EB5D5D; -fx-padding: 5px; -fx-border-radius: 5px;");
        });

        btnExit.setOnMouseExited(e -> {
            btnExit.setStyle("-fx-text-fill: white; -fx-background-color: #E62727; -fx-padding: 5px; -fx-border-radius: 5px;");
        });

        btnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.mapPage();
            }
        });

        getChildren().add(btnExit);


        //button functions
        buyAtkBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new AtkPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                    updateButtonDisableState();
                }
            }
        });

        buyDefBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new DefPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                updateButtonDisableState();
                }
            }
        });

        buyHealBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new HealPotion())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                updateButtonDisableState();
                }
            }
        });

        buyPokeballBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyItem(new Pokeball())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                    updateButtonDisableState();
                }
            }
        });

        buyDragonBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Dragon())) {

                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                    updateButtonDisableState();
                }
            }
        });

        buyFoxBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Fox())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                    updateButtonDisableState();
                }
            }
        });

        buyRatBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Rat())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                    updateButtonDisableState();
                }
            }
        });

        buyPikachuBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameController.getInstance().player.buyPokemon(new Pikachu())) {
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
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

        ////Name
        Label atkName = new Label("AtkPoiton");
        Label defName = new Label("DefPotion");
        Label healName = new Label("HealPotion");
        Label pokeballName = new Label("Pokeball");
        Label dragonName = new Label("Dragon");
        Label foxName = new Label("Fox");
        Label ratName = new Label("Rat");
        Label pikachuName = new Label("Pikachu");
        Label[] names = {atkName, defName, healName, pokeballName, dragonName, foxName, ratName, pikachuName};

        for (Label nameLable : names) {
            nameLable.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 18)); // Setting font size to 18
            //nameLable.setStyle(" -fx-background-color: #D2B48C; -fx-padding: 5px;");
        }

        atkName.setTranslateX(-490);
        atkName.setTranslateY(-280);

        defName.setTranslateX(-250);
        defName.setTranslateY(-280);

        healName.setTranslateX(-490);
        healName.setTranslateY(-42);

        pokeballName.setTranslateX(-250);
        pokeballName.setTranslateY(-42);

        pikachuName.setTranslateX(250);
        pikachuName.setTranslateY(-280);

        dragonName.setTranslateX(490);
        dragonName.setTranslateY(-280);

        foxName.setTranslateX(250);
        foxName.setTranslateY(-42);

        ratName.setTranslateX(490);
        ratName.setTranslateY(-42);


        for (int i = 0; i < 8; i++) {
            getChildren().add(names[i]);
        }

        //Price
        Label atkPrice = new Label("500$");
        Label defPrice = new Label("500$");
        Label healPrice = new Label("500$");
        Label pokeballPrice = new Label("10$");
        Label pikachuPrice = new Label("100$");
        Label dragonPrice = new Label("1000$");
        Label ratPrice = new Label("1000$");
        Label foxPrice = new Label("1000$");

        Label[] prices = {atkPrice, defPrice, healPrice, pokeballPrice, pikachuPrice, dragonPrice, ratPrice, foxPrice};

        for (Label priceLable : prices) {
            priceLable.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Setting font size to 18
            priceLable.setStyle(" -fx-background-color: #D2B48C; -fx-padding: 5px;");
            priceLable.setPrefWidth(65);
            priceLable.setPrefHeight(20);
            priceLable.setAlignment(Pos.CENTER);
        }
        atkPrice.setTranslateX(-490);
        atkPrice.setTranslateY(-130);

        defPrice.setTranslateX(-250);
        defPrice.setTranslateY(-130);

        healPrice.setTranslateX(-490);
        healPrice.setTranslateY(100);

        pokeballPrice.setTranslateX(-250);
        pokeballPrice.setTranslateY(100);

        pikachuPrice.setTranslateX(250);
        pikachuPrice.setTranslateY(-130);

        dragonPrice.setTranslateX(490);
        dragonPrice.setTranslateY(-130);

        foxPrice.setTranslateX(250);
        foxPrice.setTranslateY(100);

        ratPrice.setTranslateX(490);
        ratPrice.setTranslateY(100);

        for (int i = 0; i < 8; i++) {
            getChildren().add(prices[i]);
        }
    }
    private void updateButtonDisableState() {
        buyAtkBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new AtkPotion().getPrice());
        buyDefBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new DefPotion().getPrice());
        buyHealBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new HealPotion().getPrice());
        buyPokeballBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new Pokeball().getPrice());
        buyPikachuBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new Pikachu().getPrice());
        buyDragonBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new Dragon().getPrice());
        buyFoxBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new Fox().getPrice());
        buyRatBtn.setDisable(GameController.getInstance().getPlayer().getMoney() < new Rat().getPrice());
    }
}
