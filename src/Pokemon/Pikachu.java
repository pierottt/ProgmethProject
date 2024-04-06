package Pokemon;

public class Pikachu extends BasePokemon{

    public Pikachu(double hp, double atk, double def, double hunger) {
        super("Pikachu", hp, atk, def, 100, Element.ELECTRIC);
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
