package Pokemon;

import com.sun.javafx.runtime.async.BackgroundExecutor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Chicken extends BasePokemon{
    public Chicken() {
        super("Chicken", 99999, 100, 100, 999999999, Element.LIGHT);
        Image pokemon = new Image("ChickenLeft.png");
        Image enemy = new Image("ChickenRight.png");
        Image skill = new Image("ChickenSkillLeft.png");
        Image circle = new Image("ChickenCircle.png");
        Image pokemonAttacked = new Image("ChickenAttacked.png");
        Image enemyAttacked = new Image("ChickenAttackedRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        ImageView cirlceImg = new ImageView(circle);
        ImageView playerPokemongif = new ImageView(("chickenGif.gif"));
        ImageView enemyPokemongif = new ImageView("chickenGifRight.gif");
        ImageView pokemonImgAttacked = new ImageView(pokemonAttacked);
        ImageView enemyImgAttacked = new ImageView(enemyAttacked);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
        this.setCircleImg(cirlceImg);
        this.setEnemyImgAttacked(enemyImgAttacked);
        this.setPokemonImgAttacked(pokemonImgAttacked);
        this.setHeight(500);
        this.setWidth(500);
        this.setTranslateY(-55);
        this.setEnemyGif(enemyPokemongif);
        this.setPlayerGif(playerPokemongif);
        Path skillPath = new Path();
        skillPath.getElements().add(new MoveTo(50,90));
        skillPath.getElements().add(new LineTo(500,90));
        this.setSkillPath(skillPath);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.LIGHT) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.FIRE || pokemon.getElement()==Element.ELECTRIC) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }
    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(50000);
    }

    @Override
    public int getPrice() {
        return 999999;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Chicken){
            return true;
        }
        return false;
    }
}
