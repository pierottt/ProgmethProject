package Pokemon;

public class Chicken extends BasePokemon{
    public Chicken(double hp, double atk, double def, double hunger) {
        super("Chicken", hp, atk, def, hunger, Element.LIGHT);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.LIGHT) {
            decreaseHp(getAtk());
        } else if (pokemon.getElement()==Element.FIRE || pokemon.getElement()==Element.ELECTRIC) {
            decreaseHp(getAtk()*1.5);
        } else {
            decreaseHp(getAtk()*0.5);
        }
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
