package panes;

import game.GameController;
import item.BaseItem;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Goto;

import java.awt.*;

public class SellItemPane extends StackPane {

    public SellItemPane(){
        GridPane gridPane = new GridPane();
        Label myMoney = new Label(GameController.getInstance().getPlayer().getMoney() + "");
        setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, null, null)));

        int col=0;
        gridPane.setHgap(10); // Horizontal gap between items
        gridPane.setVgap(10); // Vertical gap between items
        for(BaseItem baseItem:GameController.getInstance().getPlayer().getInventory()){
            Text text =new Text(baseItem.getName());
            text.setFont(Font.font("Arial", FontWeight.BOLD, 16)); // Set font and size
            text.setStyle("-fx-fill:red; -fx-letter-spacing: 0.1em;"); // Set text color and letter spacing
            Button sellButton = new Button("Sell");
            sellButton.setStyle("-fx-background-color: #008CBA; -fx-background-radius: 5em; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8px 16px;");
            sellButton.setOnMouseEntered(e -> {
                sellButton.setStyle("-fx-background-color: #005F6B; -fx-background-radius: 5em; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8px 16px;");
            });
            sellButton.setOnMouseExited(e -> {
                sellButton.setStyle("-fx-background-color: #008CBA; -fx-background-radius: 5em; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8px 16px;");
            });



            sellButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    GameController.getInstance().getPlayer().sellItem(baseItem);
                    myMoney.setText(GameController.getInstance().getPlayer().getMoney() + "");

                }
            });

            // Add text and button to the gridPane
            gridPane.add(text, col, 0);
            gridPane.add(sellButton, col, 1);
            col++;
        }

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

        myMoney.setTranslateX(455);
        myMoney.setTranslateY(300);

        myMoney.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 5px;");
        getChildren().add(gridPane);
        getChildren().add(myMoney);
        getChildren().add(btnBuy);


    }

}
