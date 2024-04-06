package item;

public class Pokeball extends BaseItem{
    public Pokeball(){
        super("Pokeball",10);
    }
    public String catchPokemon(int maxHp,int hp){
        //TODO: randomizer
        if(hp <= maxHp*0.1){
            return null;
        }
        else if(hp <= maxHp*0.2){
            return null;
        }
        else if(hp <= maxHp*0.5){
            return null;
        }else{
            return "Catch failed";
        }
    }
}
