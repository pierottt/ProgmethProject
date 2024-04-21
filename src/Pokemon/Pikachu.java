package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pikachu extends BasePokemon{

    public Pikachu() {
        super("Pikachu", 1000, 150, 50, 100, Element.ELECTRIC);
        Image pokemon = new Image("PikachuLeft.png");
        Image enemy = new Image("PikachuRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.ELECTRIC) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.FIRE || pokemon.getElement()==Element.ICE) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(100);
    }

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Pikachu) {
            return true;
        }
        return false;
    }
}
