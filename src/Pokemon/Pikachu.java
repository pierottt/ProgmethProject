package Pokemon;

public class Pikachu extends BasePokemon{

    public Pikachu(double hp, double atk, double def, double hunger) {
        super("Pikachu", hp, atk, def, hunger, Element.ELECTRIC);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.ELECTRIC) {
            decreaseHp(getAtk());
        } else if (pokemon.getElement()==Element.FIRE || pokemon.getElement()==Element.ICE) {
            decreaseHp(getAtk()*1.5);
        } else {
            decreaseHp(getAtk()*0.5);
        }
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
