package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fox extends BasePokemon{
    public Fox() {
        super("Fox", 2000, 100, 50, 3000, Element.ICE);
        Image pokemon = new Image("FoxLeft.png");
        Image enemy = new Image("FoxRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
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
