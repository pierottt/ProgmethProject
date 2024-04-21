package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dragon extends BasePokemon{
    public Dragon() {
        super("Dragon", 5000, 1000, 200, 100, Element.FIRE);
        Image pokemon = new Image("DragonLeft.png");
        Image enemy = new Image("DragonRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.FIRE) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.POISON || pokemon.getElement()==Element.ICE) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(2000);
    }
    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Dragon){
            return true;
        }
        return false;
    }
}
