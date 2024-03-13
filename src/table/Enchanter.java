package table;

import item.usage.Evolable;
import pokemon.Pokemon;

public class Enchanter {
    private String name;
    public Enchanter(){
        setName("Enchanter");
    }
    public String interact(Pokemon pokemon){
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
