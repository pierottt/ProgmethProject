package Pokemon;

public class Rat extends BasePokemon{
    public Rat(double hp, double atk, double def, double hunger) {
        super("Rat", hp, atk, def, hunger, Element.POISON);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.POISON) {
            decreaseHp(getAtk());
        } else if (pokemon.getElement()==Element.ELECTRIC || pokemon.getElement()==Element.LIGHT) {
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
