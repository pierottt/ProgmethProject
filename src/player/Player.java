package player;

import Pokemon.BasePokemon;
import item.*;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<BaseItem> inventory;

    private PokeDeck pokeDeck;

    //Constructor

    public Player(String name){
        this.name=name;
        this.money=500;
        this.inventory= new ArrayList<BaseItem>();
        //dumy code for test
        this.inventory.add(new Pokeball());
        this.inventory.add(new AtkPotion());
        this.inventory.add(new DefPotion());
        this.inventory.add(new HealPotion());

        this.pokeDeck = new PokeDeck();
    }
    //getter and setter

    public int getMoney() {
        return money;
    }
    public ArrayList<BaseItem> getInventory(){
        return this.inventory;
    }



    public boolean buyItem(BaseItem item) {
        if (this.money >= item.getPrice()) {
            this.money = this.money - item.getPrice();
            this.inventory.add(item);
            return true;
        }
        return false;

    }
    public boolean buyPokemon(BasePokemon pokemon) {
        if (this.money >= pokemon.getPrice()) {
            this.money = this.money - pokemon.getPrice();
            this.pokeDeck.getPokeDeck().add(pokemon);
            return true;
        }
        return false;

    }
    public void sellItem(BaseItem item){
        this.money=this.money+item.getPrice();
        this.inventory.remove(item);
    }
    public void usePokemon(BasePokemon pokemon){}



}
