package player;

import Pokemon.BasePokemon;
import item.BaseItem;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<BaseItem> inventory;

    //Constructor

    public Player(String name){
        this.name=name;
        this.money=500;
        this.inventory=new ArrayList<BaseItem>();
    }

    public int getMoney() {
        return money;
    }

    public boolean buyItem(BaseItem item){
        if(this.money>=item.getPrice()){
            this.money=this.money-item.getPrice();
            this.inventory.add(item);
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
