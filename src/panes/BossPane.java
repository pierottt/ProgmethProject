package panes;
import Pokemon.*;
import game.GameController;
import javafx.animation.*;
import javafx.application.Platform;
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

public class BossPane extends StackPane{
    int skillCoolDown = 0;
    int enemySkillCoolDown = 5;
    public BossPane(){
        Image backgroundImage = new Image("ChickenFightPane.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(false);
        backgroundImageView.setFitWidth(1200);
        backgroundImageView.setFitHeight(550); //
        backgroundImageView.setTranslateY(-80);// move 50 pixels up

        BasePokemon playerPokemon;
        BasePokemon enemy;
        playerPokemon = GameController.getInstance().getPlayer().getCurrentPokemon();
        playerPokemon.setHp(playerPokemon.getMaxHp());
        ImageView skillImg = playerPokemon.getSkillImg();
        skillImg.setFitHeight(300);
        skillImg.setFitWidth(300);
        skillImg.setVisible(false);


        PathTransition playerSkillTransition = new PathTransition();
        playerSkillTransition.setDuration(Duration.seconds(1));
        switch (playerPokemon) {
            case Pikachu pikachu -> playerSkillTransition.setDuration(Duration.seconds(1));
            case Dragon dragon -> playerSkillTransition.setDuration(Duration.seconds(2));
            case Fox fox -> playerSkillTransition.setDuration(Duration.seconds(2));
            case Rat rat -> playerSkillTransition.setDuration(Duration.seconds(3));
            case Chicken chicken -> playerSkillTransition.setDuration(Duration.seconds(5));
            default -> {
            }
        }
        playerSkillTransition.setNode(skillImg);
        playerSkillTransition.setPath(playerPokemon.getSkillPath());


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


        enemy = new Chicken();
        ImageView playerPokemonImg = playerPokemon.getPokemonImg();
        ImageView enemyImg = enemy.getEnemyImg();
        ImageView enemySkillImg = new ImageView(new Image("ChickenSkillRight.png"));
        ImageView playerPokemonImgAttacked = playerPokemon.getPokemonImgAttacked();
        ImageView enemyImgAttacked = enemy.getEnemyImgAttacked();

        ImageView playerPokemonGif = playerPokemon.getPlayerGif();
        ImageView enemyPokemonGif = enemy.getEnemyGif();

        enemySkillImg.setFitWidth(100);
        enemySkillImg.setFitHeight(50);
        enemySkillImg.setVisible(false);
        playerPokemonImgAttacked.setVisible(false);
        enemyImgAttacked.setVisible(false);
        playerPokemonGif.setVisible(false);
        enemyPokemonGif.setVisible(false);
        //set Pokemon position and size
        playerPokemonImg.setFitHeight(playerPokemon.getHeight());
        playerPokemonImg.setFitWidth(playerPokemon.getWidth());
        playerPokemonImg.setTranslateX(-350);
        playerPokemonImg.setTranslateY(playerPokemon.getTranslateY());

        playerPokemonImgAttacked.setFitHeight(playerPokemon.getHeight());
        playerPokemonImgAttacked.setFitWidth(playerPokemon.getWidth());
        playerPokemonImgAttacked.setTranslateX(-350);
        playerPokemonImgAttacked.setTranslateY(playerPokemon.getTranslateY());

        //set enemy position and size
        enemyImg.setFitHeight(500);
        enemyImg.setFitWidth(500);
        enemyImg.setTranslateX(300);
        enemyImg.setTranslateY(-55);

        enemyImgAttacked.setFitHeight(500);
        enemyImgAttacked.setFitWidth(500);
        enemyImgAttacked.setTranslateX(300);
        enemyImgAttacked.setTranslateY(-55);

        enemyPokemonGif.setFitHeight(500);
        enemyPokemonGif.setFitWidth(500);
        enemyPokemonGif.setTranslateX(300);
        enemyPokemonGif.setTranslateY(-55);
        //set enemy skill path
        Path chickenPath = new Path();
        chickenPath.getElements().add(new MoveTo(150,0));
        chickenPath.getElements().add(new LineTo(-250,100));
        PathTransition chickenTransition = new PathTransition();
        chickenTransition.setDuration(Duration.seconds(2));
        chickenTransition.setNode(enemySkillImg);
        chickenTransition.setPath(chickenPath);
        chickenTransition.setOnFinished(event -> {
            enemySkillImg.setVisible(false);
        });

        //attack animation
        TranslateTransition forward = new TranslateTransition(Duration.seconds(1), playerPokemonImg);
        forward.setByX(500);

        TranslateTransition backward = new TranslateTransition(Duration.millis(1000), playerPokemonImg);
        backward.setByX(-500);
//        TranslateTransition enemyKnockBack = new TranslateTransition(Duration.millis(900),enemyImg);
//        enemyKnockBack.setByX(100);
//        TranslateTransition enemyComeBack = new TranslateTransition(Duration.millis(900),enemyImg);
//        enemyComeBack.setByX(-30);

        TranslateTransition forward2 = new TranslateTransition(Duration.seconds(1), enemyImg);
        forward2.setByX(500);

        TranslateTransition backward2 = new TranslateTransition(Duration.millis(1000), enemyImg);
        backward2.setByX(-500);

        RotateTransition rotate = new RotateTransition(Duration.seconds(0.2), playerPokemonImg);
        rotate.setByAngle(20); // Rotate by -20 degrees

        RotateTransition rotateBack = new RotateTransition(Duration.seconds(0.2), playerPokemonImg);
        rotateBack.setByAngle(-20); // Rotate back by 20 degrees

        RotateTransition rotate2 = new RotateTransition(Duration.seconds(0.2), enemyImg);
        rotate2.setByAngle(-20); // Rotate by -20 degrees

        RotateTransition rotateBack2 = new RotateTransition(Duration.seconds(0.2), enemyImg);
        rotateBack2.setByAngle(20); // Rotate back by 20 degrees


//        TranslateTransition playerKnockBack = new TranslateTransition(Duration.millis(900),playerPokemonImg);
//        playerKnockBack.setByX(-100);
//        TranslateTransition playerComeBack = new TranslateTransition(Duration.millis(900),playerPokemonImg);
//        playerComeBack.setByX(30);

//        ParallelTransition parallelTransition = new ParallelTransition(enemyComeBack,backward);
//        ParallelTransition parallelTransition2 = new ParallelTransition(playerComeBack,forward2);

        backward.setOnFinished(event -> {
            enemyImgAttacked.setVisible(false); // Show the attacked image
            enemyImg.setVisible(true); // Hide the original image
        });
        forward.setOnFinished(event -> {
            enemyImgAttacked.setVisible(true); // Show the attacked image
            enemyImg.setVisible(false); // Hide the original image

        });

        // Change the image after backward2 is finished
        backward2.setOnFinished(event -> {
            playerPokemonImgAttacked.setVisible(true); // Show the attacked image
            playerPokemonImg.setVisible(false); // Hide the original image
        });
        forward2.setOnFinished(event -> {
            playerPokemonImgAttacked.setVisible(false); // Show the attacked image
            playerPokemonImg.setVisible(true); // Hide the original image
        });
        SequentialTransition playerAttack = new SequentialTransition(forward,rotate,rotateBack,backward);
        SequentialTransition enemyAttack = new SequentialTransition(backward2,rotate2,rotateBack2,forward2);
//        enemyKnockBack.setDelay(Duration.millis(700));
//        playerKnockBack.setDelay(Duration.millis(700));



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

        //backgound
        ImageView battleControlBackground = new ImageView(new Image("BattleControlBG.png"));
        battleControlBackground.setFitWidth(1200);
        battleControlBackground.setFitHeight(165);

        battleControlBackground.setTranslateY(280);

        //Items
        ImageView attackPotion = new ImageView(new Image("AttackPotion.png"));
        attackPotion.setFitHeight(100);
        attackPotion.setFitWidth(100);

        attackPotion.setTranslateY(280);
        attackPotion.setTranslateX(-380);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), attackPotion);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);


        // Set event handlers
        attackPotion.setOnMouseEntered(event -> {
            scaleTransition.playFromStart(); // Start animation when mouse enters
        });

        attackPotion.setOnMouseExited(event -> {
            scaleTransition.stop(); // Stop animation when mouse exits
            attackPotion.setScaleX(1.0); // Reset scale
            attackPotion.setScaleY(1.0);
        });

        // Items amount left
        Text attackPotionLeft = new Text(GameController.getInstance().getPlayer().getAtkPotion() + "");
        attackPotionLeft.setTranslateY(316);
        attackPotionLeft.setTranslateX(-344);
        attackPotionLeft.setStyle("-fx-fill: white; -fx-font-weight: bold; -fx-font-size: 20px; -fx-font-family: 'Arial';");

        // Synchronize text animation with image animation
        TranslateTransition textTransition = new TranslateTransition(Duration.millis(200), attackPotionLeft);
        textTransition.setToY(316 +8); // Adjust as needed
        textTransition.setToX(-344 +8); // Adjust as needed

        attackPotion.setOnMouseEntered(event -> {
            scaleTransition.playFromStart();
            textTransition.playFromStart(); // Start text animation when mouse enters
        });

        attackPotion.setOnMouseExited(event -> {
            scaleTransition.stop();
            attackPotion.setScaleX(1.0);
            attackPotion.setScaleY(1.0);
            textTransition.stop(); // Stop text animation when mouse exits
            attackPotionLeft.setTranslateY(316);
            attackPotionLeft.setTranslateX(-344);
        });

        ImageView healPotion = new ImageView(new Image("HealPotion.png"));
        healPotion.setFitHeight(100);
        healPotion.setFitWidth(100);

        healPotion.setTranslateY(280);
        healPotion.setTranslateX(-230);

        ScaleTransition scaleTransitionHeal = new ScaleTransition(Duration.millis(200), healPotion);
        scaleTransitionHeal.setToX(1.2);
        scaleTransitionHeal.setToY(1.2);


        // Set event handlers
        healPotion.setOnMouseEntered(event -> {
            scaleTransitionHeal.playFromStart(); // Start animation when mouse enters
        });

        healPotion.setOnMouseExited(event -> {
            scaleTransitionHeal.stop(); // Stop animation when mouse exits
            healPotion.setScaleX(1.0); // Reset scale
            healPotion.setScaleY(1.0);
        });

        // Items amount left
        Text healPotionLeft = new Text(GameController.getInstance().getPlayer().getHealPotion() + "");
        healPotionLeft.setTranslateY(316);
        healPotionLeft.setTranslateX(-194);
        healPotionLeft.setStyle("-fx-fill: white; -fx-font-weight: bold; -fx-font-size: 20px; -fx-font-family: 'Arial';");

        // Synchronize text animation with image animation
        TranslateTransition textTransitionHeal = new TranslateTransition(Duration.millis(200), healPotionLeft);
        textTransitionHeal.setToY(316 + 8); // Adjust as needed
        textTransitionHeal.setToX(-194 + 8); // Adjust as needed

        healPotion.setOnMouseEntered(event -> {
            scaleTransitionHeal.playFromStart();
            textTransitionHeal.playFromStart(); // Start text animation when mouse enters
        });

        healPotion.setOnMouseExited(event -> {
            scaleTransitionHeal.stop();
            healPotion.setScaleX(1.0);
            healPotion.setScaleY(1.0);
            textTransitionHeal.stop(); // Stop text animation when mouse exits
            healPotionLeft.setTranslateY(316);
            healPotionLeft.setTranslateX(-194);
        });

        ImageView defPotion = new ImageView(new Image("DefPotion.png"));
        defPotion.setFitHeight(100);
        defPotion.setFitWidth(100);

        defPotion.setTranslateY(280);
        defPotion.setTranslateX(-80);

        ScaleTransition scaleTransitionDef = new ScaleTransition(Duration.millis(200), defPotion);
        scaleTransitionDef.setToX(1.2);
        scaleTransitionDef.setToY(1.2);


        // Set event handlers
        defPotion.setOnMouseEntered(event -> {
            scaleTransitionDef.playFromStart(); // Start animation when mouse enters
        });

        defPotion.setOnMouseExited(event -> {
            scaleTransitionDef.stop(); // Stop animation when mouse exits
            defPotion.setScaleX(1.0); // Reset scale
            defPotion.setScaleY(1.0);
        });

        // Items amount left
        Text defPotionLeft = new Text(GameController.getInstance().getPlayer().getDefPotion() + "");
        defPotionLeft.setTranslateY(316);
        defPotionLeft.setTranslateX(-44);
        defPotionLeft.setStyle("-fx-fill: white; -fx-font-weight: bold; -fx-font-size: 20px; -fx-font-family: 'Arial';");

        // Synchronize text animation with image animation
        TranslateTransition textTransitionDef = new TranslateTransition(Duration.millis(200), defPotionLeft);
        textTransitionDef.setToY(316 + 8); // Adjust as needed
        textTransitionDef.setToX(-44 + 8); // Adjust as needed

        defPotion.setOnMouseEntered(event -> {
            scaleTransitionDef.playFromStart();
            textTransitionDef.playFromStart(); // Start text animation when mouse enters
        });

        defPotion.setOnMouseExited(event -> {
            scaleTransitionDef.stop();
            defPotion.setScaleX(1.0);
            defPotion.setScaleY(1.0);
            textTransitionDef.stop(); // Stop text animation when mouse exits
            defPotionLeft.setTranslateY(316);
            defPotionLeft.setTranslateX(-44);
        });

        ImageView pokeballItem = new ImageView(new Image("PokeballItem.png"));
        pokeballItem.setFitHeight(100);
        pokeballItem.setFitWidth(100);

        pokeballItem.setTranslateY(280);
        pokeballItem.setTranslateX(70);

        // Items amount left
        Text pokeballItemLeft = new Text(GameController.getInstance().getPlayer().getPokeBall() + "");
        pokeballItemLeft.setTranslateY(316);
        pokeballItemLeft.setTranslateX(106);
        pokeballItemLeft.setStyle("-fx-fill: white; -fx-font-weight: bold; -fx-font-size: 20px; -fx-font-family: 'Arial';");

        // Synchronize text animation with image animation
        TranslateTransition textTransitionPokeballItem = new TranslateTransition(Duration.millis(200), pokeballItemLeft);
        textTransitionPokeballItem.setToY(316 + 8); // Adjust as needed
        textTransitionPokeballItem.setToX(106 + 8); // Adjust as needed



        //itemsBar
        ImageView itemsBar = new ImageView(new Image("ItemsBar.png"));
        itemsBar.setFitHeight(70);
        itemsBar.setFitWidth(150);

        itemsBar.setTranslateY(220);
        itemsBar.setTranslateX(-520);



        enemyAttack.setOnFinished(event -> {
            // Enable all buttons after enemyAttack animation is finished
            atkButton.setDisable(false);
            skillButton.setDisable(skillCoolDown > 0);
            leaveButton.setDisable(false);
            hpBar.setProgress((playerPokemon.getHp() / playerPokemon.getMaxHp()));
            if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.5)
                hpBar.setStyle("-fx-accent: #FFFF00;");
            if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.25)
                hpBar.setStyle("-fx-accent: #FF0000;");
            if(GameController.getInstance().getPlayer().getPokeBall()>0){
                catchButton.setDisable(false);
            }
            if(GameController.getInstance().getPlayer().getCurrentPokemon().isDead()){
                System.out.println("Your pokemon is faint");
                SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
                Goto.mapPage();
            }
        });
        //enemy Attack
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> {
            enemyImg.toFront();
            enemyAttack.play();
//            playerKnockBack.play();
            enemy.attack(playerPokemon);
            System.out.println("A:" + playerPokemon.getAtk());
            System.out.println("B:" + enemy.getAtk() * 0.5);
            System.out.println("A:" + playerPokemon.getHp());
            System.out.println("B:" + enemy.getHp());
            if (skillCoolDown == 0) {
                skillButton.setImage(new Image("SkillButton.png"));
                skillButton.setOnMouseReleased(e -> {
                    // Revert back to the original image
                    skillButton.setImage(new Image("SkillButtonOnClick.png"));
                });
                skillButton.setOnMouseEntered(e -> {
                    skillButton.setImage(new Image("SkillButtonOnClick.png"));
                });
                skillButton.setOnMouseExited(e -> {
                    skillButton.setImage(new Image("SkillButton.png"));
                });
            } else {
                skillButton.setDisable(true); // Disable button when skillCooldown is more than 0
                skillButton.setImage(new Image("SkillButtonOnclick.png"));
                skillButton.setOnMouseReleased(null); // Remove mouse released event handler
                skillButton.setOnMouseEntered(null); // Remove mouse entered event handler
                skillButton.setOnMouseExited(null); // Remove mouse exited event handler
            }

        });
        chickenTransition.setOnFinished(event -> {
            playerPokemonImg.setVisible(false);
            playerPokemonGif.setVisible(true);
            atkButton.setDisable(false);
            skillButton.setDisable(skillCoolDown > 0);
            leaveButton.setDisable(false);
            hpBar.setProgress((playerPokemon.getHp() / playerPokemon.getMaxHp()));
            if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.25)
                hpBar.setStyle("-fx-accent: #FF0000;");
            else if(playerPokemon.getHp()/playerPokemon.getMaxHp() <= 0.5)
                hpBar.setStyle("-fx-accent: #FFFF00;");
            if(GameController.getInstance().getPlayer().getPokeBall()>0){
                catchButton.setDisable(false);
            }
            enemySkillImg.setVisible(false);
            if(GameController.getInstance().getPlayer().getCurrentPokemon().isDead()){
                System.out.println("Your pokemon is faint");
                SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
                Goto.mapPage();
            }
            PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
            pause.setOnFinished(e -> {
                playerPokemonImg.setVisible(true);
                playerPokemonGif.setVisible(false);
                // Add any other actions you want to perform after the delay here
            });
            pause.play();

        });
        //enemy useSkill when cool down = 0;
        PauseTransition delay2 = new PauseTransition(Duration.seconds(1));
        delay2.setOnFinished(event -> {
//            // Disable all buttons
//            atkButton.setDisable(true);
//            skillButton.setDisable(true);
//            leaveButton.setDisable(true);
//            catchButton.setDisable(true);
            enemySkillCoolDown = 5;
            enemyImg.toFront();
            enemySkillImg.setVisible(true);
            enemySkillImg.toFront();
            chickenTransition.play();
            enemy.useSkill(playerPokemon);
            System.out.println("A:" + playerPokemon.getAtk());
            System.out.println("B:" + enemy.getAtk() * 0.5);
            System.out.println("A:" + playerPokemon.getHp());
            System.out.println("B:" + enemy.getHp());
            if (skillCoolDown == 0) {
                skillButton.setImage(new Image("SkillButton.png"));
                skillButton.setOnMouseReleased(e -> {
                    // Revert back to the original image
                    skillButton.setImage(new Image("SkillButtonOnClick.png"));
                });
                skillButton.setOnMouseEntered(e -> {
                    skillButton.setImage(new Image("SkillButtonOnClick.png"));
                });
                skillButton.setOnMouseExited(e -> {
                    skillButton.setImage(new Image("SkillButton.png"));
                });
            } else {
                skillButton.setDisable(true); // Disable button when skillCooldown is more than 0
                skillButton.setImage(new Image("SkillButtonOnClick.png"));
                skillButton.setOnMouseReleased(null); // Remove mouse released event handler
                skillButton.setOnMouseEntered(null); // Remove mouse entered event handler
                skillButton.setOnMouseExited(null); // Remove mouse exited event handler
            }
        });

//        parallelTransition.setOnFinished(event -> {
//            if(enemySkillCoolDown == 0){
//                delay2.play();
//            }else{
//                delay.play();
//            }
//        });

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
                playerSkillTransition.play();
                playerSkillTransition.setOnFinished(event -> {
                    enemyImg.setVisible(false);
                    enemyPokemonGif.setVisible(true);
                    PauseTransition pauseEnemy = new PauseTransition(Duration.seconds(1));
                    pauseEnemy.setOnFinished(e -> {
                        enemyImg.setVisible(true);
                        enemyPokemonGif.setVisible(false);
                        // Add any other actions you want to perform after the delay here
                    });
                    pauseEnemy.play();
                    skillImg.setVisible(false);
                    if(enemy.isDead()){
                        System.out.println("Enemy pokemon is faint");
                        GameController.getInstance().setChickenCheckpoint(true);
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
//                enemyKnockBack.play();
                playerPokemon.attack(enemy);
                playerAttack.setOnFinished(event -> {
                    enemyHpBar.setProgress((enemy.getHp()/enemy.getMaxHp()));
                    if((enemy.getHp()/enemy.getMaxHp()) <= 0.25)
                        enemyHpBar.setStyle("-fx-accent: #FF0000;");
                    else if((enemy.getHp()/enemy.getMaxHp()) <= 0.50)
                        enemyHpBar.setStyle("-fx-accent: #FFFF00;");
                    if(enemy.isDead()){
                        System.out.println("Enemy pokemon is faint");
                        GameController.getInstance().setChickenCheckpoint(true);
                        SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
                        Goto.mapPage();
                    }
                    if(enemySkillCoolDown == 0){
                        delay2.play();
                    }else{
                        delay.play();
                    }
//                    parallelTransition.play();
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
                        GameController.getInstance().setChickenCheckpoint(true);
                        GameController.getInstance().getPlayer().setChicken(GameController.getInstance().getPlayer().getChicken()+1);
                        if(!GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().contains(new Chicken())){
                            GameController.getInstance().getPlayer().getPokeDeck().getPokeDeck().add(new Chicken());
                        }
                        SoundManager.getInstance().changeSound("res/backgroundMusic.mp3");
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

        getChildren().addAll(backgroundImageView,enemyImgAttacked,enemyImg,playerPokemonImg,playerPokemonImgAttacked,battleControlBackground,leaveButton,atkButton,skillButton,catchButton,pokeballView);
        getChildren().add(hpBar);
        getChildren().add(enemyHpBar);
        getChildren().add(vs);
        getChildren().add(skillImg);
        getChildren().add(enemySkillImg);
        getChildren().addAll(attackPotion,attackPotionLeft,healPotion,healPotionLeft,defPotion,defPotionLeft,pokeballItem,pokeballItemLeft,itemsBar);
        getChildren().addAll(playerPokemonGif,enemyPokemonGif);


    }
    public void decreaseCoolDown(){
        if(skillCoolDown > 0) skillCoolDown--;
        if(enemySkillCoolDown > 0) enemySkillCoolDown--;
    }
}
