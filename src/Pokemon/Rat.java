package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Rat extends BasePokemon{
    public Rat() {
        super("Rat", 2500, 200, 0, 10000,Element.POISON);
        Image pokemon = new Image("RatLeft.png");
        Image enemy = new Image("RatRight.png");
        Image skill = new Image("RatSkillLeft.png");
        Image circle = new Image("RatCircle.png");
        Image pokemonAttacked = new Image("RatAttacked.png");
        Image enemyAttacked = new Image("RatAttackedRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        ImageView cirlceImg = new ImageView(circle);
        ImageView pokemonImgAttacked = new ImageView(pokemonAttacked);
        ImageView enemyImgAttacked = new ImageView(enemyAttacked);
        ImageView playerPokemonGif = new ImageView("ratGif.gif");
        ImageView enemyPokemonGif = new ImageView("ratGifRight.gif");
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
        this.setCircleImg(cirlceImg);
        this.setPokemonImgAttacked(pokemonImgAttacked);
        this.setEnemyImgAttacked(enemyImgAttacked);
        this.setHeight(500);
        this.setWidth(500);
        this.setTranslateY(-35);
        this.setEnemyGif(enemyPokemonGif);
        this.setPlayerGif(playerPokemonGif);
        Path skillPath = new Path();
        skillPath.getElements().add(new MoveTo(-80,80));
        skillPath.getElements().add(new LineTo(400,150));
        this.setSkillPath(skillPath);
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(1500);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.POISON) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.ELECTRIC || pokemon.getElement()==Element.LIGHT) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Rat){
            return true;
        }
        return false;
    }
}
