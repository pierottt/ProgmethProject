package panes;

import Pokemon.*;
import game.GameController;
import item.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Goto;

import java.awt.*;

public class SellItemPane extends StackPane {
    Button sellAtkBtn = new Button("SELL");
    Button sellDefBtn = new Button("SELL");
    Button sellHealBtn = new Button("SELL");
    Button sellPokeballBtn = new Button("SELL");
    Button sellPikachuBtn = new Button("SELL");
    Button sellDragonBtn = new Button("SELL");
    Button sellFoxBtn = new Button("SELL");
    Button sellRatBtn = new Button("SELL");

    public SellItemPane(){
        Label SellItem = new Label("Sell Items");
        SellItem.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 25));
        SellItem.setStyle("-fx-text-fill: white; -fx-background-color: #7C3014; -fx-padding: 5px;");
        SellItem.setPrefWidth(300);
        SellItem.setPrefHeight(20);
        SellItem.setAlignment(Pos.CENTER);
        SellItem.setTranslateY(-320);
        getChildren().add(SellItem);

        Label myMoney = new Label(GameController.getInstance().getPlayer().getMoney() + "$");
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
        setPadding(new Insets(20));
        
        updateButtonDisableState();
        
        Button[] buttons = {sellAtkBtn, sellDefBtn, sellHealBtn, sellPokeballBtn, sellPikachuBtn, sellDragonBtn, sellFoxBtn, sellRatBtn};

        // ImageView add picture
        ImageView atkPotionImage = new ImageView(new Image("Attack.png"));
        ImageView defPotionImage = new ImageView(new Image("Defense.png"));
        ImageView healPotionImage = new ImageView(new Image("Heal.png"));
        ImageView pokeballImage = new ImageView(new Image("pokeball.png"));
        ImageView dragonImage = new ImageView(new Image("DragonCircle.png"));
        ImageView foxImage = new ImageView(new Image("FoxCircle.png"));
        ImageView ratImage = new ImageView(new Image("RatCircle.png"));
        ImageView pikachuImage = new ImageView(new Image("PikachuCircle.png"));
        ImageView[] images = {atkPotionImage, defPotionImage, healPotionImage, pokeballImage, pikachuImage, dragonImage, foxImage, ratImage};
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

        Label amountAtk = new Label("total : " + GameController.getInstance().getPlayer().getAtkPotion());
        Label amountDef = new Label("total : " + GameController.getInstance().getPlayer().getDefPotion());
        Label amountDragon = new Label("total : " + GameController.getInstance().getPlayer().getDragon());
        Label amountFox = new Label("total : " + GameController.getInstance().getPlayer().getFox());
        Label amountHeal = new Label("total : " + GameController.getInstance().getPlayer().getHealPotion());
        Label amountPokeball = new Label("total : " + GameController.getInstance().getPlayer().getPokeBall());
        Label amountRat = new Label("total : " + GameController.getInstance().getPlayer().getRat());
        Label amountPikachu = new Label("total : " + GameController.getInstance().getPlayer().getPikachu());
        Label[] amounts = {amountAtk, amountDef, amountHeal, amountPokeball, amountPikachu, amountDragon, amountFox, amountRat};

        for (Label nameLabel : amounts) {
            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            nameLabel.setStyle(" -fx-background-color: #D2B48C; -fx-padding: 5px;");
            nameLabel.setPrefWidth(100);
            nameLabel.setPrefHeight(20);
            nameLabel.setAlignment(Pos.CENTER);
        }

        amountAtk.setTranslateX(-490);
        amountAtk.setTranslateY(-130);

        amountDef.setTranslateX(-250);
        amountDef.setTranslateY(-130);

        amountHeal.setTranslateX(-490);
        amountHeal.setTranslateY(100);

        amountPokeball.setTranslateX(-250);
        amountPokeball.setTranslateY(100);

        amountPikachu.setTranslateX(250);
        amountPikachu.setTranslateY(-130);

        amountDragon.setTranslateX(490);
        amountDragon.setTranslateY(-130);

        amountFox.setTranslateX(250);
        amountFox.setTranslateY(100);

        amountRat.setTranslateX(490);
        amountRat.setTranslateY(100);

        for (int i = 0; i < 8; i++) {
            getChildren().add(amounts[i]);
        }


        // Set preferred width and height for all buttons
        for (Button button : buttons) {
            button.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
            button.setStyle(" -fx-background-color: #20CD27; -fx-padding: 5px; -fx-text-fill: white;");
            button.setPrefWidth(70);
            button.setPrefHeight(30);
        }

        sellAtkBtn.setTranslateX(-490);
        sellAtkBtn.setTranslateY(-200);

        sellDefBtn.setTranslateX(-250);
        sellDefBtn.setTranslateY(-200);

        sellHealBtn.setTranslateX(-490);
        sellHealBtn.setTranslateY(30);

        sellPokeballBtn.setTranslateX(-250);
        sellPokeballBtn.setTranslateY(30);

        sellPikachuBtn.setTranslateX(250);
        sellPikachuBtn.setTranslateY(-200);

        sellDragonBtn.setTranslateX(490);
        sellDragonBtn.setTranslateY(-200);

        sellFoxBtn.setTranslateX(250);
        sellFoxBtn.setTranslateY(30);

        sellRatBtn.setTranslateX(490);
        sellRatBtn.setTranslateY(30);


        for (int i = 0; i < 8; i++) {
            getChildren().add(buttons[i]);
            buttons[i].setVisible(false);
            buttons[i].setTranslateZ(20);
            int finalI = i;
            images[i].setOnMouseEntered(e -> buttons[finalI].setVisible(true));
            images[i].setOnMouseExited(e -> buttons[finalI].setVisible(false));
            buttons[i].setOnMouseEntered(e -> buttons[finalI].setVisible(true));
            buttons[i].setOnMouseExited(e -> buttons[finalI].setVisible(false));
        }


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


        sellAtkBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new AtkPotion());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setAtkPotion(GameController.getInstance().getPlayer().getAtkPotion()-1);
                amountAtk.setText("total : "+GameController.getInstance().getPlayer().getAtkPotion()+"");
                updateButtonDisableState();
            }
        });

        sellDefBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new DefPotion());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setDefPotion(GameController.getInstance().getPlayer().getDefPotion()-1);
                amountDef.setText("total : "+GameController.getInstance().getPlayer().getDefPotion()+"");
                updateButtonDisableState();
            }
        });

        sellDragonBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Dragon());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setDragon(GameController.getInstance().getPlayer().getDragon()-1);
                amountDragon.setText("total : "+GameController.getInstance().getPlayer().getDragon()+"");
                updateButtonDisableState();
            }
        });

        sellFoxBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Fox());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setFox(GameController.getInstance().getPlayer().getFox()-1);
                amountFox.setText("total : "+GameController.getInstance().getPlayer().getFox()+"");
                updateButtonDisableState();
            }
        });

        sellHealBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new HealPotion());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setHealPotion(GameController.getInstance().getPlayer().getHealPotion()-1);
                amountHeal.setText("total : "+GameController.getInstance().getPlayer().getHealPotion()+"");
                updateButtonDisableState();

            }
        });

        sellPokeballBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellItem(new Pokeball());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setPokeBall(GameController.getInstance().getPlayer().getPokeBall()-1);
                amountPokeball.setText("total : "+GameController.getInstance().getPlayer().getPokeBall()+"");
                updateButtonDisableState();
            }
        });

        sellRatBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Rat());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setRat(GameController.getInstance().getPlayer().getRat()-1);
                amountRat.setText("total : "+GameController.getInstance().getPlayer().getRat()+"");
                updateButtonDisableState();
            }
        });

        sellPikachuBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameController.getInstance().getPlayer().sellPokemon(new Pikachu());
                myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "$");
                GameController.getInstance().getPlayer().setPikachu(GameController.getInstance().getPlayer().getPikachu()-1);
                amountPikachu.setText("total : "+GameController.getInstance().getPlayer().getPikachu()+"");
                updateButtonDisableState();

            }
        });
        //Go to BuyItemPane
        Button btnBuy = new Button("Buy Items");
        btnBuy.setTranslateX(520);
        btnBuy.setTranslateY(300);
        btnBuy.setPrefWidth(120);
        btnBuy.setPrefHeight(30);
        btnBuy.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
        btnBuy.setStyle("-fx-text-fill: white; -fx-background-color: #2C8FDC; -fx-padding: 5px; -fx-border-radius: 5px;");
        btnBuy.setOnMouseEntered(e -> {
            btnBuy.setStyle("-fx-text-fill: white; -fx-background-color: #509DDA; -fx-padding: 5px; -fx-border-radius: 5px;");
        });
        btnBuy.setOnMouseExited(e -> {
            btnBuy.setStyle("-fx-text-fill: white; -fx-background-color: #2C8FDC; -fx-padding: 5px; -fx-border-radius: 5px;");
        });
        btnBuy.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.shopPage();
            }
        });
        getChildren().add(btnBuy);

        //show myMoney
        myMoney.setTranslateX(370);
        myMoney.setTranslateY(300);
        myMoney.setPrefHeight(30);
        myMoney.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
        myMoney.setStyle("-fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 5px; -fx-border-width: 2px; -fx-border-radius: 5px;");
        getChildren().add(myMoney);

        //Price
        Label priceAtk = new Label("Atk Potion : 250$");
        Label priceDef = new Label("Def Potion : 250$");
        Label priceHeal = new Label("Heal Potion : 250$");
        Label pricePokeball = new Label("Pokeball : 5$");
        Label pricePikachu = new Label("Pikachu : 50$");
        Label priceDragon = new Label("Dragon : 500$");
        Label priceFox = new Label("Fox : 500$");
        Label priceRat = new Label("Rat : 500$");

        Label[] prices = {priceAtk, priceDef, priceHeal, pricePokeball, pricePikachu, priceDragon, priceFox, priceRat};


        priceAtk.setTranslateX(-490);
        priceAtk.setTranslateY(-280);

        priceDef.setTranslateX(-250);
        priceDef.setTranslateY(-280);

        priceHeal.setTranslateX(-490);
        priceHeal.setTranslateY(-42);

        pricePokeball.setTranslateX(-250);
        pricePokeball.setTranslateY(-42);

        pricePikachu.setTranslateX(250);
        pricePikachu.setTranslateY(-280);

        priceDragon.setTranslateX(490);
        priceDragon.setTranslateY(-280);

        priceFox.setTranslateX(250);
        priceFox.setTranslateY(-42);

        priceRat.setTranslateX(490);
        priceRat.setTranslateY(-42);

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
        sellAtkBtn.setDisable(GameController.getInstance().getPlayer().getAtkPotion() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1);
        sellDefBtn.setDisable(GameController.getInstance().getPlayer().getDefPotion() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1);
        sellHealBtn.setDisable(GameController.getInstance().getPlayer().getHealPotion() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 );
        sellPokeballBtn.setDisable(GameController.getInstance().getPlayer().getPokeBall() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1);
        sellPikachuBtn.setDisable(GameController.getInstance().getPlayer().getPikachu() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || (GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Pikachu()) && GameController.getInstance().getPlayer().getPikachu() == 1));
        sellDragonBtn.setDisable(GameController.getInstance().getPlayer().getDragon() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || (GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Dragon()) && GameController.getInstance().getPlayer().getDragon() == 1));
        sellFoxBtn.setDisable(GameController.getInstance().getPlayer().getFox() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || (GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Fox()) && GameController.getInstance().getPlayer().getFox() == 1));
        sellRatBtn.setDisable(GameController.getInstance().getPlayer().getRat() == 0 ||GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().size()<=1 || (GameController.getInstance().getPlayer().getCurrentPokemon().equals(new Rat()) && GameController.getInstance().getPlayer().getRat() == 1));
    }

}
