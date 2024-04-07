package Pokemon;

public class Dragon extends BasePokemon{
    public Dragon(double hp, double atk, double def, double hunger) {
        super("Dragon", hp, atk, def, 100, Element.FIRE);
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
