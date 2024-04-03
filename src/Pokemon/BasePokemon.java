package Pokemon;

import item.usage.Evolable;

public abstract class BasePokemon implements Evolable {
    private String name;
    private double maxHp;
    private double hp;
    private double atk;
    private double def;
    private double hunger;
    private Element element;

    private int price;

    //Abstact
    public abstract int getPrice();


    public BasePokemon(String name,double MaxHp, double atk, double def, double hunger, Element element) {
        setName(name);
        setMaxHp(maxHp);
        setHp(maxHp);
        setAtk(atk);
        setDef(def);
        setHunger(hunger);
        setElement(element);
    }

    public boolean isDead() {
        if(hp<=0) return true;
        else return false;
    }

    public void decreaseHp (double amount) {
        setHp(getHp()-(amount-getDef()));
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        if (hp < 0) {
            this.hp = 0;
        }
        else this.hp = hp;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        if (hunger < 0) {
            this.hunger = 0;
        }
        this.hunger = hunger;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    @Override
    public boolean getIsEvoled() {
        return false;
    }

    @Override
    public void setIsEvoled(boolean bool) {

    }
}
