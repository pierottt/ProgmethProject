package Pokemon;

public class Fox extends BasePokemon{
    public Fox(double hp, double atk, double def, double hunger) {
        super("Fox", hp, atk, def, hunger, Element.ICE);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.ICE) {
            decreaseHp(getAtk());
        } else if (pokemon.getElement()==Element.LIGHT || pokemon.getElement()==Element.POISON) {
            decreaseHp(getAtk()*1.5);
        } else {
            decreaseHp(getAtk()*0.5);
        }
    }
}
