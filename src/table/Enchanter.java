package table;

import item.usage.Evolable;
import Pokemon.BasePokemon;

public class Enchanter {
    private String name;
    public Enchanter(){
        setName("Enchanter");
    }
    public String interact(BasePokemon pokemon){
        //TODO: something
        if(pokemon instanceof Evolable){
            if(!((Evolable) pokemon).getIsEvoled()){
                ((Evolable) pokemon).setIsEvoled(true);
                return "Evolved successfully";
            }
            else{
                return "Already evolved";
            }
        }
        return "This item cannot be evolved";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
