package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Fox extends BasePokemon{
    public Fox() {
        super("Fox", 2000, 250, 50, 3000, Element.ICE);
        Image pokemon = new Image("FoxLeft.png");
        Image enemy = new Image("FoxRight.png");
        Image skill = new Image("FoxSkillLeft.png");
        Image circle = new Image("FoxCircle.png");
        Image pokemonAttacked = new Image("FoxAttacked.png");
        Image enemyAttacked = new Image("FoxAttackedRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        ImageView cirlceImg = new ImageView(circle);
        ImageView pokemonImgAttacked = new ImageView(pokemonAttacked);
        ImageView enemyImgAttacked = new ImageView(enemyAttacked);
        ImageView playerPokemonGif = new ImageView("foxGif.gif");
        ImageView enemyPokemonGif = new ImageView("foxGifRight.gif");
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
        this.setCircleImg(cirlceImg);
        this.setPokemonImgAttacked(pokemonImgAttacked);
        this.setEnemyImgAttacked(enemyImgAttacked);
        this.setHeight(400);
        this.setWidth(400);
        this.setTranslateY(15);
        this.setEnemyGif(enemyPokemonGif);
        this.setPlayerGif(playerPokemonGif);
        Path skillPath = new Path();
        skillPath.getElements().add(new MoveTo(-200,-100));
        skillPath.getElements().add(new LineTo(400,200));
        this.setSkillPath(skillPath);

//        foxPath.getElements().add(new MoveTo(300,-100));
//        foxPath.getElements().add(new LineTo(-150,200));
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.ICE) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.LIGHT || pokemon.getElement()==Element.POISON) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(500);
    }
    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Fox){
            return true;
        }
        return false;
    }
}
