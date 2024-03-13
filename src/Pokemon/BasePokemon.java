package Pokemon;

public class BasePokemon {
    private String name;
    private double hp;
    private double atk;
    private double def;
    private double hunger;
    private Element element;


    public BasePokemon(String name, double hp, double atk, double def, double hunger, Element element) {
        setName(name);
        setHp(hp);
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
}
