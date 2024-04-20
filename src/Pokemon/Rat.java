package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rat extends BasePokemon{
    public Rat() {
        super("Rat", 2000, 200, 0, 10000,Element.POISON);
        Image pokemon = new Image("RatLeft.png");
        Image enemy = new Image("RatRight.png");
        Image skill = new Image("RatSkill.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
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
