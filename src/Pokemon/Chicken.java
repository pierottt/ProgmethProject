package Pokemon;

import com.sun.javafx.runtime.async.BackgroundExecutor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chicken extends BasePokemon{
    public Chicken() {
        super("Chicken", 99999, 100, 100, 999999999, Element.LIGHT);
        Image pokemon = new Image("ChickenLeft.png");
        Image enemy = new Image("ChickenRight.png");
        Image skill = new Image("ChickenSkill.png");
        Image circle = new Image("ChickenCircle.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        ImageView cirlceImg = new ImageView(circle);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
        this.setCircleImg(cirlceImg);
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
