package Pokemon;

public class Dragon extends BasePokemon{
    public Dragon(double hp, double atk, double def, double hunger) {
        super("Dragon", hp, atk, def, hunger, Element.FIRE);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.FIRE) {
            decreaseHp(getAtk());
        } else if (pokemon.getElement()==Element.POISON || pokemon.getElement()==Element.ICE) {
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
