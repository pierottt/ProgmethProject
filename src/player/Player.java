package player;

import Pokemon.*;
import item.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.RandomAccess;

public class Player {
    private String name;

    private int money;
    private ArrayList<BaseItem> inventory;

    private BasePokemon currentPokemon;

    private PokeDeck pokeDeck;

    private int atkPotion;
    private int defPotion;
    private int healPotion;
    private int pokeBall;
    private int chicken;
    private int dragon;
    private int fox;
    private int pikachu;
    private int rat;

    //getter and setter for all fields

    public void setMoney(int money) {
        this.money = Math.min(money,999999);
    }

    public int getAtkPotion() {
        return atkPotion;
    }

    public void setAtkPotion(int atkPotion) {
        if(atkPotion < 0) atkPotion = 0;
        this.atkPotion = atkPotion;
    }

    public int getDefPotion() {
        return defPotion;
    }

    public void setDefPotion(int defPotion) {
        if(defPotion < 0) defPotion = 0;
        this.defPotion = defPotion;
    }

    public int getHealPotion() {
        return healPotion;
    }

    public void setHealPotion(int healPotion) {
        if(healPotion < 0) healPotion = 0;
        this.healPotion = healPotion;
    }

    public int getPokeBall() {
        return pokeBall;
    }

    public void setPokeBall(int pokeBall) {
        this.pokeBall = pokeBall;
    }

    public int getChicken() {
        return chicken;
    }

    public void setChicken(int chicken) {
        this.chicken = chicken;
    }

    public int getDragon() {
        return dragon;
    }

    public void setDragon(int dragon) {
        this.dragon = dragon;
    }

    public int getFox() {
        return fox;
    }

    public void setFox(int fox) {
        this.fox = fox;
    }

    public int getPikachu() {
        return pikachu;
    }

    public void setPikachu(int pikachu) {
        this.pikachu = pikachu;
    }

    public int getRat() {
        return rat;
    }

    public void setRat(int rat) {
        this.rat = rat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(ArrayList<BaseItem> inventory) {
        this.inventory = inventory;
    }

    public PokeDeck getPokeDeck() {
        return pokeDeck;
    }

    public void setPokeDeck(PokeDeck pokeDeck) {
        this.pokeDeck = pokeDeck;
    }
    //Constructor

    public Player(String name){
        this.name=name;
        this.money=5000;
        this.inventory= new ArrayList<BaseItem>();
        //dumb code for test
        this.pokeDeck = new PokeDeck();
        this.getPokeDeck().getPokeDeck().add(new Pikachu());
        setChicken(0);
        setFox(0);
        setPikachu(1);
        setDragon(0);
        setAtkPotion(0);
        setDefPotion(0);
        setHealPotion(0);
        setPokeBall(5);
        setCurrentPokemon(new Pikachu());
    }
    //getter and setter


    public BasePokemon getCurrentPokemon() {
        return currentPokemon;
    }

    public void setCurrentPokemon(BasePokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public int getMoney() {
        return money;
    }
    public ArrayList<BaseItem> getInventory(){
        return this.inventory;
    }

    public void addItem(BaseItem item){
        if(item instanceof AtkPotion){
            setAtkPotion(getAtkPotion()+1);
        }
        else if(item instanceof DefPotion){
            setDefPotion(getDefPotion()+1);
        }else if(item instanceof HealPotion){
            setHealPotion(getHealPotion()+1);
        }else if(item instanceof Pokeball){
            setPokeBall(getPokeBall()+1);
        }
    }
    public void addPokemon(BasePokemon pokemon){
        if(pokemon instanceof Dragon){
            setDragon(getDragon()+1);
        }
        else if(pokemon instanceof Fox){
            setFox(getFox()+1);
        }
        else if(pokemon instanceof Rat){
            setRat(getRat()+1);
        }
        else if(pokemon instanceof Pikachu){
            setPikachu(getPikachu()+1);
        }
        else if(pokemon instanceof Chicken){
            setChicken(getChicken()+1);
        }
        getPokeDeck().getPokeDeck().add(pokemon);
    }

    public boolean catched(BasePokemon pokemon){
        double percent = (pokemon.getHp()/pokemon.getMaxHp())*100;
        if(percent>50){
            System.out.println("unsuccessful catch!");
            return false;
        }
        else if(percent>25){
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;
            if(randomNumber>50){
                return true;
            }
            return false;
        }
        else return true;
    }




    public boolean buyItem(BaseItem item) {
        if (this.money >= item.getPrice()) {
            setMoney(this.money = this.money - item.getPrice());
            this.inventory.add(item);
            addItem(item);
            return true;
        }
        return false;

    }
    public boolean buyPokemon(BasePokemon pokemon) {
        if (this.money >= pokemon.getPrice()) {
            setMoney(this.money - pokemon.getPrice());
            this.pokeDeck.getPokeDeck().add(pokemon);
            addPokemon(pokemon);
            return true;
        }
        return false;

    }
    public void sellItem(BaseItem item){
        setMoney(this.money+item.getPrice()/2);
    }

    public void sellPokemon(BasePokemon pokemon){
        setMoney(this.money=this.money+pokemon.getPrice()/2);
        getPokeDeck().getPokeDeck().remove(pokemon);
    }
    public void usePokemon(BasePokemon pokemon){}



}
