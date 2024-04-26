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
import utils.SoundManager;

public class fightPane1_1 extends StackPane{
    int skillCoolDown = 0;
    int enemySkillCoolDown = 2;
    public fightPane1_1(){
        Image backgroundImage = new Image("PikachuFightPane.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(false);
        backgroundImageView.setFitWidth(1200);
        backgroundImageView.setFitHeight(550);
        backgroundImageView.setTranslateY(-80);// move 50 pixels up

        BasePokemon playerPokemon;
        BasePokemon enemy;
        playerPokemon = GameController.getInstance().getPlayer().getCurrentPokemon();
        playerPokemon.setHp(playerPokemon.getMaxHp());
        ImageView skillImg = playerPokemon.getMySkillImg();
        switch (playerPokemon) {
            case Pikachu pikachu -> skillImg.setFitWidth(100);
            case Dragon dragon -> skillImg.setFitWidth(200);
            case Fox fox -> skillImg.setFitWidth(200);
            case Rat rat -> skillImg.setFitWidth(100);
            default -> {
            }
        }
        switch (playerPokemon) {
            case Pikachu pikachu -> skillImg.setFitHeight(200);
            case Dragon dragon -> skillImg.setFitHeight(200);
            case Fox fox -> skillImg.setFitHeight(200);
            case Rat rat -> skillImg.setFitHeight(100);
            default -> {
            }
        }
        skillImg.setVisible(false);
        //All skill path
        PathTransition skillTransition = new PathTransition();
        skillTransition.setDuration(Duration.seconds(1));
        skillTransition.setNode(skillImg);
        //thunder (Pikachu)
        Path thunderPath = new Path();
        thunderPath.getElements().add(new MoveTo(350,-200));
        thunderPath.getElements().add(new LineTo(350,150));
        PathTransition thunderTransition = new PathTransition();
        //fire (Dragon)
        Path firePath = new Path();
        firePath.getElements().add(new MoveTo(-250,-100));
        firePath.getElements().add(new LineTo(350,150));
        //Ice (fox)
        Path icePath = new Path();
        icePath.getElements().add(new MoveTo(-250,-100));
        icePath.getElements().add(new LineTo(350,150));
        //Poison (Rat)
        Path poisonPath = new Path();
        poisonPath.getElements().add(new MoveTo(-250,0));
        poisonPath.getElements().add(new LineTo(350,150));
        //Set Transition
        switch (playerPokemon) {
            case Pikachu pikachu -> skillTransition.setPath(thunderPath);
            case Dragon dragon -> skillTransition.setPath(firePath);
            case Fox fox -> skillTransition.setPath(icePath);
            case Rat rat -> skillTransition.setPath(poisonPath);
            default -> {
            }
        }
        switch (playerPokemon) {
            case Pikachu pikachu -> skillTransition.setDuration(Duration.seconds(1));
            case Dragon dragon -> skillTransition.setDuration(Duration.seconds(2));
            case Fox fox -> skillTransition.setDuration(Duration.seconds(2));
            case Rat rat -> skillTransition.setDuration(Duration.seconds(3));
            default -> {
            }
        }

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


        enemy = new Pikachu();
        ImageView playerPokemonImg = playerPokemon.getPokemonImg();
        ImageView enemyImg = enemy.getEnemyImg();
        ImageView enemySkillImg = enemy.getSkillImg();
        enemySkillImg.setFitWidth(300);
        enemySkillImg.setFitHeight(400);
        enemySkillImg.setVisible(false);
        //set Pokemon position and size
        playerPokemonImg.setFitHeight(playerPokemon.getHeight());
        playerPokemonImg.setFitWidth(playerPokemon.getWidth());
        playerPokemonImg.setTranslateX(-350);
        playerPokemonImg.setTranslateY(playerPokemon.getTranslateY());

        //set enemy position and size
        enemyImg.setFitHeight(200);
        enemyImg.setFitWidth(200);
        enemyImg.setTranslateX(300);
        enemyImg.setTranslateY(65);

        //set enemy skill path
        Path pikachuPath = new Path();
        pikachuPath.getElements().add(new MoveTo(-150,-200));
        pikachuPath.getElements().add(new LineTo(-150,150));

        PathTransition pikachuTransition = new PathTransition();
        pikachuTransition.setDuration(Duration.seconds(1));
        pikachuTransition.setNode(enemySkillImg);
        pikachuTransition.setPath(pikachuPath);

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
        ImageView leaveButton = new ImageView(new Image("LeaveButton.png"));
        leaveButton.setFitHeight(75);
        leaveButton.setFitWidth(200);
        leaveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
                Goto.mapPage();
            }
        });
        leaveButton.setOnMouseReleased(event -> {
            // Revert back to the original image
            leaveButton.setImage(new Image("LeaveButton.png"));
        });

        leaveButton.setOnMouseEntered(event -> {
            leaveButton.setImage(new Image("LeaveButtonOnClick.png"));
        });

        leaveButton.setOnMouseExited(event -> {
            leaveButton.setImage(new Image("LeaveButton.png"));
        });

        setAlignment(leaveButton, Pos.BOTTOM_RIGHT);

        ImageView atkButton = new ImageView(new Image("AttackButton.png"));
        atkButton.setFitHeight(75);
        atkButton.setFitWidth(200);

        atkButton.setOnMouseReleased(event -> {
            // Revert back to the original image
            atkButton.setImage(new Image("AttackButton.png"));
        });
        atkButton.setOnMouseEntered(event -> {
            atkButton.setImage(new Image("AttackButtonOnClick.png"));
        });
        atkButton.setOnMouseExited(event -> {
            atkButton.setImage(new Image("AttackButton.png"));
        });



        setAlignment(atkButton, Pos.BOTTOM_RIGHT);
        atkButton.setTranslateY(-80);
        atkButton.setTranslateX(-200);

        ImageView catchButton = new ImageView(new Image("CatchButton.png"));

        catchButton.setFitHeight(75);
        catchButton.setFitWidth(200);
        if(GameController.getInstance().getPlayer().getPokeBall()<1){
            catchButton.setDisable(true);
        }
        catchButton.setOnMouseReleased(event -> {
            // Revert back to the original image
            catchButton.setImage(new Image("CatchButton.png"));
        });

        catchButton.setOnMouseEntered(event -> {
            catchButton.setImage(new Image("CatchButtonOnClick.png"));
        });

        catchButton.setOnMouseExited(event -> {
            catchButton.setImage(new Image("CatchButton.png"));
        });



        setAlignment(catchButton, Pos.BOTTOM_RIGHT);
        catchButton.setTranslateX(-200);

        ImageView skillButton = new ImageView(new Image("SkillButton.png"));
        skillButton.setFitHeight(75);
        skillButton.setFitWidth(200);




        enemyAttack.setOnFinished(event -> {
            atkButton.setDisable(false);
            skillButton.setDisable(skillCoolDown > 0);
            leaveButton.setDisable(false);
            if(GameController.getInstance().getPlayer().getPokeBall()>0){
                catchButton.setDisable(false);
            }
            if(GameController.getInstance().getPlayer().getCurrentPokemon().isDead()){
                System.out.println("Your pokemon is faint");
                Goto.mapPage();
            }
        });
        //enemy Attack
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> {
            enemyImg.toFront();
            enemyAttack.play();
            enemy.attack(playerPokemon);
            hpBar.setProgress((playerPokemon.getHp() / playerPokemon.getMaxHp()));
            if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.25)
                hpBar.setStyle("-fx-accent: #FF0000;");
            else if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.5)
                hpBar.setStyle("-fx-accent: #FFFF00;");
            System.out.println("A:" + playerPokemon.getAtk());
            System.out.println("B:" + enemy.getAtk() * 0.5);
            System.out.println("A:" + playerPokemon.getHp());
            System.out.println("B:" + enemy.getHp());
        });
        pikachuTransition.setOnFinished(event -> {
            atkButton.setDisable(false);
            skillButton.setDisable(skillCoolDown > 0);
            leaveButton.setDisable(false);
            if(GameController.getInstance().getPlayer().getPokeBall()>0){
                catchButton.setDisable(false);
            }
            enemySkillImg.setVisible(false);
            if(GameController.getInstance().getPlayer().getCurrentPokemon().isDead()){
                System.out.println("Your pokemon is faint");
                Goto.mapPage();
            }
        });

        //enemy useSkill when cool down = 0;
        PauseTransition delay2 = new PauseTransition(Duration.seconds(1));
        delay2.setOnFinished(event -> {
            enemySkillCoolDown = 5;
            enemyImg.toFront();
            enemySkillImg.setVisible(true);
            enemySkillImg.toFront();
            pikachuTransition.play();
            enemy.useSkill(playerPokemon);
            hpBar.setProgress((playerPokemon.getHp() / playerPokemon.getMaxHp()));
            if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.25)
                hpBar.setStyle("-fx-accent: #FF0000;");
            else if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.5)
                hpBar.setStyle("-fx-accent: #FFFF00;");
            System.out.println("A:" + playerPokemon.getAtk());
            System.out.println("B:" + enemy.getAtk() * 0.5);
            System.out.println("A:" + playerPokemon.getHp());
            System.out.println("B:" + enemy.getHp());

        });

        skillButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                skillCoolDown = 2;
                System.out.println("USE SKILLS");
                playerPokemon.useSkill(enemy);
                enemyHpBar.setProgress((enemy.getHp()/enemy.getMaxHp()));
                if((enemy.getHp()/enemy.getMaxHp()) <= 0.25)
                    enemyHpBar.setStyle("-fx-accent: #FF0000;");
                else if((enemy.getHp()/enemy.getMaxHp()) <= 0.50)
                    enemyHpBar.setStyle("-fx-accent: #FFFF00;");
                atkButton.setDisable(true);
                skillButton.setDisable(true);
                leaveButton.setDisable(true);
                catchButton.setDisable(true);
                skillImg.toFront();
                skillImg.setVisible(true);
                skillTransition.play();
                skillButton.setDisable(true);
                skillTransition.setOnFinished(event -> {
                    skillImg.setVisible(false);
                    if(enemySkillCoolDown == 0){
                        delay2.play();
                    }else{
                        delay.play();
                    }
                    if(enemy.isDead()){
                        System.out.println("Enemy pokemon is faint");
                        GameController.getInstance().setPikachuCheckpoint(true);
                        SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
                        Goto.mapPage();
                    }
                });


            }
        });

        setAlignment(skillButton, Pos.BOTTOM_RIGHT);
        skillButton.setTranslateY(-80);
        atkButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("ATTACK");
                atkButton.setImage(new Image("AttackButtonOnClick.png"));
                decreaseCoolDown();
                leaveButton.setDisable(true);
                atkButton.setDisable(true);
                skillButton.setDisable(true);
                catchButton.setDisable(true);
                playerAttack.play();
                playerPokemonImg.toFront();
                playerPokemon.attack(enemy);
                enemyHpBar.setProgress((enemy.getHp()/enemy.getMaxHp()));
                if((enemy.getHp()/enemy.getMaxHp()) <= 0.25)
                    enemyHpBar.setStyle("-fx-accent: #FF0000;");
                else if((enemy.getHp()/enemy.getMaxHp()) <= 0.50)
                    enemyHpBar.setStyle("-fx-accent: #FFFF00;");
                playerAttack.setOnFinished(event -> {
                    if(enemy.isDead()){
                        System.out.println("Enemy pokemon is faint");
                        GameController.getInstance().setPikachuCheckpoint(true);
                        SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
                        Goto.mapPage();
                    }
                    if(enemySkillCoolDown == 0){
                        delay2.play();
                    }else{
                        delay.play();
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
                        GameController.getInstance().setPikachuCheckpoint(true);
                        GameController.getInstance().getPlayer().setPikachu(GameController.getInstance().getPlayer().getPikachu()+1);
                        if(!GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().contains(new Pikachu())){
                            GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().add(new Pikachu());
                        }
                        Goto.mapPage();
                    }
                    else{
                        atkButton.setDisable(false);
                        skillButton.setDisable(skillCoolDown > 0);
                        leaveButton.setDisable(false);
                        if(GameController.getInstance().getPlayer().getPokeBall()>0){
                            catchButton.setDisable(false);
                        }
                    }
                    GameController.getInstance().getPlayer().setPokeBall(GameController.getInstance().getPlayer().getPokeBall()-1);
                });
            }
        });

        if (skillCoolDown == 0) {
            skillButton.setDisable(false);
            skillButton.setImage(new Image("SkillButton.png"));
            skillButton.setOnMouseReleased(event -> {
                // Revert back to the original image
                skillButton.setImage(new Image("SkillButtonOnClick.png"));
            });
            skillButton.setOnMouseEntered(event -> {
                skillButton.setImage(new Image("SkillButtonOnClick.png"));
            });
            skillButton.setOnMouseExited(event -> {
                skillButton.setImage(new Image("SkillButton.png"));
            });
        } else {
            skillButton.setDisable(true); // Disable button when skillCooldown is more than 0
            skillButton.setImage(new Image("SkillButtonOnClick.png"));
            skillButton.setOnMouseReleased(null); // Remove mouse released event handler
            skillButton.setOnMouseEntered(null); // Remove mouse entered event handler
            skillButton.setOnMouseExited(null); // Remove mouse exited event handler
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
