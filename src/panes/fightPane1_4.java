package panes;
import Pokemon.*;
import game.GameController;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import utils.Goto;

public class fightPane1_4 extends StackPane{
    int skillCoolDown = 0;
    int enemySkillCoolDown = 2;
    public fightPane1_4(){
        Image backgroundImage = new Image("RatFightPane.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(false);
        backgroundImageView.setFitWidth(1200);
        backgroundImageView.setFitHeight(550); //
        backgroundImageView.setTranslateY(-80);// move 50 pixels up

        BasePokemon playerPokemon;
        BasePokemon enemy;
        playerPokemon = GameController.getInstance().getPlayer().getCurrentPokemon();
        ImageView skillImg = playerPokemon.getSkillImg();
        skillImg.setFitHeight(300);
        skillImg.setFitWidth(100);
        skillImg.setVisible(false);

        Path thunderPath = new Path();
        thunderPath.getElements().add(new MoveTo(350,-200));
        thunderPath.getElements().add(new LineTo(350,150));
        PathTransition thunderTransition = new PathTransition();
        thunderTransition.setDuration(Duration.seconds(1));
        thunderTransition.setNode(skillImg);
        thunderTransition.setPath(thunderPath);

        Text vs = new Text("Vs");
        vs.setFont(Font.font(50));
        setAlignment(vs, Pos.TOP_CENTER);
        vs.setTranslateY(-10);
        //hpBar
        ProgressBar hpBar = new ProgressBar();
        hpBar.setProgress(1.0);
        hpBar.setStyle("-fx-accent: #00FF00;");
        hpBar.setPrefSize(500,30);
        setAlignment(hpBar,Pos.TOP_LEFT);
        hpBar.setTranslateX(10);
        hpBar.setTranslateY(10);

        //enemyHpBar
        ProgressBar enemyHpBar = new ProgressBar();
        enemyHpBar.setProgress(1.0);
        enemyHpBar.setStyle("-fx-accent: #00FF00;");
        enemyHpBar.setPrefSize(500,30);
        setAlignment(enemyHpBar,Pos.TOP_RIGHT);
        enemyHpBar.setTranslateX(-10);
        enemyHpBar.setTranslateY(10);


        enemy = new Rat();
        ImageView playerPokemonImg = playerPokemon.getPokemonImg();
        ImageView enemyImg = enemy.getEnemyImg();
        ImageView enemySkillImg = enemy.getSkillImg();
        enemySkillImg.setFitWidth(100);
        enemySkillImg.setFitHeight(100);
        enemySkillImg.setVisible(false);

        //set Pokemon position and size
        playerPokemonImg.setFitHeight(200);
        playerPokemonImg.setFitWidth(200);
        playerPokemonImg.setTranslateX(-350);
        playerPokemonImg.setTranslateY(65);

        //set enemy position and size
        enemyImg.setFitHeight(500);
        enemyImg.setFitWidth(500);
        enemyImg.setTranslateX(350);
        enemyImg.setTranslateY(-35);
        //set enemy skill path
        Path ratPath = new Path();
        ratPath.getElements().add(new MoveTo(300,50));
        ratPath.getElements().add(new LineTo(-250,100));
        PathTransition ratTransition = new PathTransition();
        ratTransition.setDuration(Duration.seconds(4));
        ratTransition.setNode(enemySkillImg);
        ratTransition.setPath(ratPath);
        ratTransition.setOnFinished(event -> {
            enemySkillImg.setVisible(false);
        });


        //attack animation
        TranslateTransition forward = new TranslateTransition(Duration.seconds(1), playerPokemonImg);
        forward.setByX(650);

        TranslateTransition backward = new TranslateTransition(Duration.seconds(1), playerPokemonImg);
        backward.setByX(-650);

        TranslateTransition forward2 = new TranslateTransition(Duration.seconds(1), enemyImg);
        forward2.setByX(650);

        TranslateTransition backward2 = new TranslateTransition(Duration.seconds(1), enemyImg);
        backward2.setByX(-650);

        SequentialTransition playerAttack = new SequentialTransition(forward,backward);
        SequentialTransition enemyAttack = new SequentialTransition(backward2,forward2);

        //Pokeball
        Image pokeball = new Image("pokeball.png");
        ImageView pokeballView = new ImageView(pokeball);
        pokeballView.setFitHeight(50);
        pokeballView.setFitWidth(50);
        pokeballView.setVisible(false);

        Path pokeballPath = new Path();
        pokeballPath.getElements().add(new MoveTo(0,200));
        pokeballPath.getElements().add(new QuadCurveTo(-150,-150,350,150));
        PathTransition pokeTransition = new PathTransition();
        pokeTransition.setDuration(Duration.seconds(1));
        pokeTransition.setNode(pokeballView);
        pokeTransition.setPath(pokeballPath); // Set the path along which the node will transition
        pokeTransition.setCycleCount(1);

        //BUTTON
        Button leaveButton = new Button("LEAVE");
        leaveButton.setPrefHeight(75);
        leaveButton.setPrefWidth(200);
        leaveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.mapPage();
            }
        });
        setAlignment(leaveButton, Pos.BOTTOM_RIGHT);

        Button atkButton = new Button("ATTACK");
        atkButton.setPrefHeight(75);
        atkButton.setPrefWidth(200);

        setAlignment(atkButton, Pos.BOTTOM_RIGHT);
        atkButton.setTranslateY(-80);
        atkButton.setTranslateX(-200);

        Button catchButton = new Button("CATCH");
        catchButton.setPrefHeight(75);
        catchButton.setPrefWidth(200);
        if(GameController.getInstance().getPlayer().getPokeBall()<1){
            catchButton.setDisable(true);
        }


        setAlignment(catchButton, Pos.BOTTOM_RIGHT);
        catchButton.setTranslateX(-200);

        Button skillButton = new Button("SKILL");
        skillButton.setPrefHeight(75);
        skillButton.setPrefWidth(200);
        //enemy Attack
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> {
            // Disable all buttons
            atkButton.setDisable(true);
            skillButton.setDisable(true);
            leaveButton.setDisable(true);
            catchButton.setDisable(true);

            enemyImg.toFront();
            enemyAttack.setOnFinished(animationEvent -> {
                // Enable all buttons after enemyAttack animation is finished
                atkButton.setDisable(false);
                if (skillCoolDown > 0) {
                    skillButton.setDisable(true);
                } else {
                    skillButton.setDisable(false);
                }
                leaveButton.setDisable(false);
                if(GameController.getInstance().getPlayer().getPokeBall()>0)
                catchButton.setDisable(false);
                if(GameController.getInstance().getPlayer().getCurrentPokemon().isDead()){
                    System.out.println("Your pokemon is faint");
                    Goto.mapPage();
                }
            });
            enemyAttack.play();
            enemy.attack(playerPokemon);
            hpBar.setProgress((playerPokemon.getHp() / playerPokemon.getMaxHp()));
            System.out.println("A:" + playerPokemon.getAtk());
            System.out.println("B:" + enemy.getAtk() * 0.5);
            System.out.println("A:" + playerPokemon.getHp());
            System.out.println("B:" + enemy.getHp());

        });

        //enemy useSkill when cool down = 0;
        PauseTransition delay2 = new PauseTransition(Duration.seconds(1));
        delay2.setOnFinished(event -> {
            // Disable all buttons
            atkButton.setDisable(true);
            skillButton.setDisable(true);
            leaveButton.setDisable(true);
            catchButton.setDisable(true);

            enemySkillCoolDown = 5;
            enemyImg.toFront();
            enemySkillImg.setVisible(true);
            enemySkillImg.toFront();
            ratTransition.setOnFinished(animationEvent -> {
                // Enable all buttons after ratTransition animation is finished
                atkButton.setDisable(false);
                if (skillCoolDown > 0) {
                    skillButton.setDisable(true);
                } else {
                    skillButton.setDisable(false);
                }
                leaveButton.setDisable(false);
                if(GameController.getInstance().getPlayer().getPokeBall()>0)
                catchButton.setDisable(false);
                enemySkillImg.setVisible(false);
                if(GameController.getInstance().getPlayer().getCurrentPokemon().isDead()){
                    System.out.println("Your pokemon is faint");
                    Goto.mapPage();
                }
            });
            ratTransition.play();
            enemy.useSkill(playerPokemon);
            hpBar.setProgress((playerPokemon.getHp() / playerPokemon.getMaxHp()));
            System.out.println("A:" + playerPokemon.getAtk());
            System.out.println("B:" + enemy.getAtk() * 0.5);
            System.out.println("A:" + playerPokemon.getHp());
            System.out.println("B:" + enemy.getHp());

        });

        skillButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                skillCoolDown = 2;
                System.out.println("USE SKILLS");
                playerPokemon.useSkill(enemy);
                enemyHpBar.setProgress((enemy.getHp()/enemy.getMaxHp()));
                atkButton.setDisable(true);
                skillButton.setDisable(true);
                leaveButton.setDisable(true);
                catchButton.setDisable(true);
                skillImg.toFront();
                skillImg.setVisible(true);
                thunderTransition.play();
                skillButton.setDisable(true);
                thunderTransition.setOnFinished(event -> {
                    skillImg.setVisible(false);
                    if(enemySkillCoolDown == 0){
                        delay2.play();
                    }else{
                        delay.play();
                    }
                    if(enemy.isDead()){
                        System.out.println("Enemy pokemon is faint");
                        GameController.getInstance().setRatCheckpoint(true);
                        Goto.mapPage();
                    }
                });

            }
        });
        setAlignment(skillButton, Pos.BOTTOM_RIGHT);
        skillButton.setTranslateY(-80);
        atkButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("ATTACK");
                decreaseCoolDown();
                leaveButton.setDisable(true);
                atkButton.setDisable(true);
                skillButton.setDisable(true);
                catchButton.setDisable(true);
                playerAttack.play();
                playerPokemonImg.toFront();
                playerPokemon.attack(enemy);
                enemyHpBar.setProgress((enemy.getHp()/enemy.getMaxHp()));
                playerAttack.setOnFinished(event -> {
                    if(enemySkillCoolDown == 0){
                        delay2.play();
                    }else{
                        delay.play();
                    }
                    if(enemy.isDead()){
                        System.out.println("Enemy pokemon is faint");
                        GameController.getInstance().setRatCheckpoint(true);
                        Goto.mapPage();
                    }
                });

            }
        });
        catchButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                atkButton.setDisable(true);
                skillButton.setDisable(true);
                catchButton.setDisable(true);
                leaveButton.setDisable(true);
                pokeballView.setVisible(true);
                pokeballView.toFront();
                pokeTransition.play();
                pokeTransition.setOnFinished(event -> {
                    pokeballView.setVisible(false);

                    if (GameController.getInstance().getPlayer().catched(enemy)) {
                        GameController.getInstance().setRatCheckpoint(true);
                        GameController.getInstance().getPlayer().setRat(GameController.getInstance().getPlayer().getRat()+1);
                        if(!GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().contains(new Rat())){
                            GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().add(new Rat());
                        }
                        Goto.mapPage();
                    }
                    else {
                        if(enemySkillCoolDown == 0){
                            delay2.play();
                        }else{
                            delay.play();
                        }
                    }
                    GameController.getInstance().getPlayer().setPokeBall(GameController.getInstance().getPlayer().getPokeBall()-1);

                });
            }
        });
        if(skillCoolDown == 0){
            skillButton.setDisable(false);
        }

        getChildren().addAll(backgroundImageView,enemyImg,playerPokemonImg,leaveButton,atkButton,skillButton,catchButton,pokeballView);
        getChildren().add(hpBar);
        getChildren().add(enemyHpBar);
        getChildren().add(vs);
        getChildren().add(skillImg);
        getChildren().add(enemySkillImg);

    }
    public void decreaseCoolDown(){
        if(skillCoolDown > 0) skillCoolDown--;
        if(enemySkillCoolDown > 0) enemySkillCoolDown--;
    }
}
